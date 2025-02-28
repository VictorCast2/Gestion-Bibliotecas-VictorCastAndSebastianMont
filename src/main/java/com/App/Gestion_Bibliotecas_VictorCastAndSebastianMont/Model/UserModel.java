package com.App.Gestion_Bibliotecas_VictorCastAndSebastianMont.Model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.*;
import java.util.stream.Collectors;

import static jakarta.persistence.CascadeType.ALL;

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

    public String getPassword() {
        return this.password;
    }

    public Set<String> getRoles() {
        return this.Roles;
    }

    public String getUsername() {
        return this.username;
    }

}