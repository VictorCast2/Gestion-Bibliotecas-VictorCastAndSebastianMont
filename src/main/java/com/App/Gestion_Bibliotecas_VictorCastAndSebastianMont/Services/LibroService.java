package com.App.Gestion_Bibliotecas_VictorCastAndSebastianMont.Services;

import com.App.Gestion_Bibliotecas_VictorCastAndSebastianMont.Model.LibroModel;
import com.App.Gestion_Bibliotecas_VictorCastAndSebastianMont.Repository.LibroRepository;
import lombok.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import java.util.List;

@Data
@Service
@AllArgsConstructor
public class LibroService {

    private final LibroRepository libroRepository = null;

    public List<LibroModel> listarLibros() {
        return libroRepository.findAll();
    }

    @PreAuthorize("hasRole('Admin')")
    public void guardarLibro(LibroModel libro) {
        libroRepository.save(libro);
    }

    @PreAuthorize("hasRole('Admin')")
    public void eliminarLibro(Long id) {
        libroRepository.deleteById(id);
    }

    @PreAuthorize("hasRole('Admin')")
    public void actualizarLibro(LibroModel libro) {
        if (libroRepository.existsById(libro.getId())) {
            libroRepository.save(libro);
        } else {
            throw new IllegalArgumentException("El libro no existe");
        }
    }

    @PreAuthorize("hasRole('User')")
    public List<LibroModel> buscarLibro() {
        return libroRepository.findAll();
    }

    @PreAuthorize("hasRole('User')")
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