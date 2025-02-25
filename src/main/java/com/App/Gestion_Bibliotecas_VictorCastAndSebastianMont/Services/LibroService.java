package com.App.Gestion_Bibliotecas_VictorCastAndSebastianMont.Services;

import com.App.Gestion_Bibliotecas_VictorCastAndSebastianMont.Model.LibroModel;
import com.App.Gestion_Bibliotecas_VictorCastAndSebastianMont.Repository.LibroRepository;
import lombok.*;
import org.springframework.stereotype.Service;
import java.util.List;

@Data
@Service
@AllArgsConstructor
public class LibroService {

    private final LibroRepository libroRepository;

    public List<LibroModel> listarLibros() {
        return libroRepository.findAll();
    }

    public void guardarLibro(LibroModel libro) {
        libroRepository.save(libro);
    }

    public void eliminarLibro(Long id) {
        libroRepository.deleteById(id);
    }

}