package com.App.Gestion_Bibliotecas_VictorCastAndSebastianMont.Controller;

import com.App.Gestion_Bibliotecas_VictorCastAndSebastianMont.Model.LibroModel;
import com.App.Gestion_Bibliotecas_VictorCastAndSebastianMont.Services.LibroService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import lombok.*;

@Data
@Controller
@RequestMapping("/Api/Admin")
@PreAuthorize("hasRole('Admin')")
@AllArgsConstructor
public class AdminController {

    private final LibroService libroService;

    @GetMapping("/Libros")
    public String listarLibros(Model model) {
        model.addAttribute("libros", libroService.listarLibros());
        return "";
    }

    @PostMapping("/Agregar")
    public String agregarLibro(LibroModel libro) {
        libroService.guardarLibro(libro);
        return "";
    }

    @PostMapping("/Eliminar")
    public String eliminarLibro(Long id) {
        libroService.eliminarLibro(id);
        return "";
    }

}