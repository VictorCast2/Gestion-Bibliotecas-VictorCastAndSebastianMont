package com.App.Gestion_Bibliotecas_VictorCastAndSebastianMont.Model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.*;
import java.util.stream.Collectors;

@Data
@Entity
@Table(name = "Usuario")
@AllArgsConstructor
@NoArgsConstructor
public class UserModel implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "Roles", joinColumns = @JoinColumn(name = "Usuario_Id"))
    @Column(name = "Rol")
    private Set<String> Roles;

    /**
     * Obtiene los roles del usuario.
     * @return Los roles del usuario.
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Roles.stream()
                .map(SimpleGrantedAuthority::new) // Convierte cada rol en una autoridad
                .collect(Collectors.toList());
    }

    /**
     * Obtiene la contraseña del usuario.
     * @return La contraseña del usuario.
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Indica si la cuenta del usuario está bloqueada.
     * @return Si la cuenta del usuario está bloqueada.
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Indica si las credenciales del usuario han expirado.
     * @return Si las credenciales del usuario han expirado.
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Indica si el usuario está habilitado.
     * @return Si el usuario está habilitado.
     */
    @Override
    public boolean isEnabled() {
        return true;
    }

    /**
     * Obtiene el nombre de usuario.
     * @return El nombre de usuario.
     */
    @Override
    public String getUsername() {
        return this.username;
    }

    /**
     * Obtiene la contraseña del usuario.
     * @return La contraseña del usuario.
     */
    @Override
    public String getPassword() {
        return this.password;
    }

}