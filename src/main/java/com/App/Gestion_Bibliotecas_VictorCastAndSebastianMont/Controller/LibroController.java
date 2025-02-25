package com.App.Gestion_Bibliotecas_VictorCastAndSebastianMont.Controller;

import com.App.Gestion_Bibliotecas_VictorCastAndSebastianMont.Model.LibroModel;
import com.App.Gestion_Bibliotecas_VictorCastAndSebastianMont.Services.LibroService;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Data
@Controller
@RequestMapping("/Api/Admin")
@PreAuthorize("hasRole('Admin')")
@AllArgsConstructor
public class LibroController {

    @Autowired
    private final LibroService libroService;

    @GetMapping("/Libros")
    public String listarLibros(Model model) {
        model.addAttribute("libros", libroService.listarLibros());
        return "Libros";
    }

    @GetMapping("/UsuariosPrestamo")
    public String listarUsuariosPrestamo(Model model){
        libroService.listarLibros();
        return "";
    }

    @PostMapping("/Agregar")
    public String agregarLibro(LibroModel libro) {
        libroService.guardarLibro(libro);
        return "";
    }

    @PostMapping("/Actualizar")
    public String actualizarLibro(LibroModel libro) {
        libroService.actualizarLibro(libro);
        return "";
    }

    @PostMapping("/Eliminar")
    public String eliminarLibro(Long id) {
        libroService.eliminarLibro(id);
        return "";
    }

}