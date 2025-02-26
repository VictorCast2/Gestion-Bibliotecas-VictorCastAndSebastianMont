package com.App.Gestion_Bibliotecas_VictorCastAndSebastianMont.Model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "Libro")
@AllArgsConstructor
@NoArgsConstructor
public class LibroModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "Nombre")
    private String Nombre;

    @Column(name = "Genero")
    private String Genero;

    @Column(name = "Disponible")
    private int Disponible;

}