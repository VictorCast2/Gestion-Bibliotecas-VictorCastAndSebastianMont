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

    @Column(name = "Titulo")
    private String Titulo;

    @Column(name = "Genero")
    private String Genero;

    @Column(name = "Descrición")
    private String Descricion;

    @Column(name = "Autor")
    private String Autor;

    @Column(name = "Año")
    private String Año;

    @Column(name = "Disponible")
    private int Disponible;

}