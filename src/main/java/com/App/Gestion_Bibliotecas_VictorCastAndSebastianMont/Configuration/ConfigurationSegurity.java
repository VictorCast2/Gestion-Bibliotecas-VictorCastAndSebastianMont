package com.App.Gestion_Bibliotecas_VictorCastAndSebastianMont.Configuration;

import com.App.Gestion_Bibliotecas_VictorCastAndSebastianMont.Repository.UserRepository;
import com.App.Gestion_Bibliotecas_VictorCastAndSebastianMont.Services.CustomUserDetailsServices;
import org.springframework.context.annotation.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.SessionManagementConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class ConfigurationSegurity {

    /**
     * Configura las reglas de seguridad de la aplicación.
     * @param http La configuración de seguridad HTTP.
     * @return El filtro de seguridad configurado.
     * @throws Exception Si ocurre un error al configurar la seguridad.
     */
    @Bean
    public SecurityFilterChain securedFilterChain(final HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Deshabilita CSRF
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/Api/Auth/Login", "/Api/Auth/Logout").permitAll() // Permite acceso público
                        .requestMatchers("/Css/**", "/Img/**", "/Js/**").permitAll() // Permite acceso público
                        .requestMatchers("/Error/**", "/Error").permitAll()
                        .requestMatchers("/Api/Admin/**").hasRole("Admin") // Requiere rol de administrador
                        .requestMatchers("/Api/User/**").hasRole("User") // Requiere rol de usuario
                        .anyRequest().authenticated() // Autenticación para otras rutas
                )
                .formLogin(form -> form
                        .loginPage("/Api/Auth/Login") // Página de inicio de sesión personalizada
                        .successHandler(AllSuccessHandler()) // Manejador de éxito personalizado
                        .failureUrl("/Error") // Redirigir si hay error
                        .permitAll() // Permitir acceso a la página de login
                )
                .logout(logout -> logout
                        .logoutUrl("/Api/Auth/Logout") // URL de cierre de sesión
                        .logoutSuccessUrl("/Api/Auth/Login?Logout") // Redirige tras cerrar sesión
                        .invalidateHttpSession(true) // Invalida completamente la sesión
                        .clearAuthentication(true) // Borra la autenticación actual
                        .deleteCookies("JSESSIONID") // Borra la cookie de sesión
                        .permitAll() // Permitir acceso a la página de logout
                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.ALWAYS) // Crea nueva sesión al autenticarse
                        .invalidSessionUrl("/Api/Auth/Login") // Redirige si la sesión es inválida
                        .sessionFixation(SessionManagementConfigurer.SessionFixationConfigurer::newSession) // Nueva sesión tras autenticarse
                )
                .httpBasic(Customizer.withDefaults()); // Habilita autenticación básica
        return http.build();
    }

    /**
     * Configura el servicio de usuarios.
     * @param usuarioRepository El repositorio de usuarios.
     * @return El servicio de usuarios personalizado.
     */
    @Bean
    public UserDetailsService userDetailsService(UserRepository usuarioRepository) {
        return new CustomUserDetailsServices(usuarioRepository);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Configura el proveedor de autenticación.
     * @param userDetailsService El servicio de usuarios.
     * @param passwordEncoder El encriptador de contraseñas.
     * @return El proveedor de autenticación personalizado.
     */
    @Bean
    public DaoAuthenticationProvider authenticationProvider(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder);
        return authProvider;
    }

    /**
     * Configura el manejador de autenticación.
     * @param http La configuración de seguridad HTTP.
     * @param userDetailsService El servicio de usuarios.
     * @param passwordEncoder El encriptador de contraseñas.
     * @return El manejador de autenticación personalizado.
     * @throws Exception Si ocurre un error al configurar el manejador de autenticación.
     */
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .authenticationProvider(authenticationProvider(userDetailsService, passwordEncoder))
                .build();
    }

    @Bean
    public AuthenticationSuccessHandler AllSuccessHandler() {
        return (_, response, authentication) -> {
            String role = authentication.getAuthorities().stream()
                    .map(authority -> authority.getAuthority().replace("ROLE_", ""))
                    .findFirst()
                    .orElse("");
            String redirectUrl = switch (role) {
                case "Admin" -> "/Api/Admin/Home";
                case "User" -> "/Api/User/Home";
                default -> "/Api/Auth/Login";
            };
            response.sendRedirect(redirectUrl);
        };
    }

}