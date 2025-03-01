package com.App.Gestion_Bibliotecas_VictorCastAndSebastianMont.Services;

import com.App.Gestion_Bibliotecas_VictorCastAndSebastianMont.Model.LibroModel;
import com.App.Gestion_Bibliotecas_VictorCastAndSebastianMont.Repository.LibroRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Data
@Service
@AllArgsConstructor
public class LibroServices {

    @Autowired
    private final LibroRepository libroRepository;

    /**
     * Guarda un libro en la base de datos
     * @param libro
     */
    public void guardarLibro(LibroModel libro) {
        libroRepository.save(libro);
    }

    /**
     * Elimina un libro de la base de datos
     * @param id
     */
    public void eliminarLibro(Long id) {
        libroRepository.deleteById(id);
    }

    /**
     * Actualiza un libro en la base de datos
     * @param libro
     */
    public LibroModel actualizarLibro(LibroModel libro, Long id) {
        if (libroRepository.existsById(id)) {
            LibroModel Libro1 = libroRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Libro no encontrado"));
            Libro1.setTitulo(libro.getTitulo());
            Libro1.setAutor(libro.getAutor());
            Libro1.setAnno(libro.getAnno());
            Libro1.setDescripcion(libro.getDescripcion());
            Libro1.setDisponible(libro.getDisponible());
            Libro1.setGenero(libro.getGenero());
            return libroRepository.save(Libro1);
        } else {
            throw new IllegalArgumentException("El libro no existe");
        }
    }

    /**
     * Busca un libro en la base de datos
     * @return
     */
    public List<LibroModel> buscarLibro() {
        return libroRepository.findAll();
    }


    /**
     * Solicita un prestamo de un libro
     * @param id
     */
    public void solicitarPrestamoLibro(Long id) {
        LibroModel libro = libroRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Libro no encontrado"));
        if (libro.getDisponible() > 0) {
            libro.setDisponible(libro.getDisponible() - 1);
            libroRepository.save(libro);
        } else {
            throw new IllegalArgumentException("No hay ejemplares disponibles");
        }
    }

}