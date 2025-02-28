package com.App.Gestion_Bibliotecas_VictorCastAndSebastianMont.Model;

import jakarta.persistence.*;
import lombok.*;
import org.slf4j.helpers.SubstituteLogger;

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


    Descricion
    Año
    Autor
    @Column(name = "Disponible")
    private int Disponible;

}