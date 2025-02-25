package com.App.Gestion_Bibliotecas_VictorCastAndSebastianMont.Model;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@Data
@Entity
@Table(name = "Usuario")
@AllArgsConstructor
@NoArgsConstructor
public class UserModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(unique = true, nullable = false)
    private String Username;

    @Column(nullable = false)
    private String Password;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "Roles", joinColumns = @JoinColumn(name = "Usuario_Id"))
    @Column(name = "Rol")
    private Set<String> Roles;

}