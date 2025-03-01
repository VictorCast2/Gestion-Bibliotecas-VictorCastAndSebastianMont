package com.App.Gestion_Bibliotecas_VictorCastAndSebastianMont.Services;

import com.App.Gestion_Bibliotecas_VictorCastAndSebastianMont.Model.UserModel;
import com.App.Gestion_Bibliotecas_VictorCastAndSebastianMont.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import lombok.*;

@Data
@Service
@AllArgsConstructor
public class CustomUserDetailsServices implements UserDetailsService {

    @Autowired
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Intentando autenticar usuario: " + username);
        UserModel usuario = userRepository.findByUsername(username)
                .orElseThrow(() -> {
                    System.out.println("Usuario no encontrado en la base de datos.");
                    return new UsernameNotFoundException("Usuario no encontrado ... ");
                });
        System.out.println("Usuario encontrado : " + usuario.getUsername()+ " ... " );
        System.out.println(" La contraseña es : " + usuario.getPassword());
        return new User(
                // Devuelve un nuevo usuario con los datos del usuario encontrado
                usuario.getUsername(),
                // Devuelve la contraseña del usuario
                usuario.getPassword(),
                // Devuelve si el usuario está habilitado
                usuario.isEnabled(),
                // Devuelve si la cuenta del usuario ha expirado
                usuario.isAccountNonExpired(),
                // Devuelve si las credenciales del usuario han expirado
                usuario.isCredentialsNonExpired(),
                // Devuelve si la cuenta del usuario está bloqueada
                usuario.isAccountNonLocked(),
                // Devuelve las autoridades del usuario
                usuario.getAuthorities()
        );
    }

}