package com.App.Gestion_Bibliotecas_VictorCastAndSebastianMont.Controller;

import com.App.Gestion_Bibliotecas_VictorCastAndSebastianMont.Model.LibroModel;
import com.App.Gestion_Bibliotecas_VictorCastAndSebastianMont.Services.LibroService;
import lombok.*;

import java.util.ArrayList;

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
        return "libros";
    }

    @GetMapping("/UsuariosPrestamo")
    public String listarUsuariosPrestamo(Model model){
        model.addAttribute("usuarios", new ArrayList<>()); // Simulación
        return "usuarios"; // Asegúrate de tener una vista usuarios.html
    }

    @PostMapping("/Agregar")
    public String agregarLibro(@ModelAttribute LibroModel libro) {
        libroService.guardarLibro(libro);
        return "redirect:/Api/Admin/Libros";
    }

    @PostMapping("/Eliminar")
    public String eliminarLibro(@RequestParam Long id) {
        libroService.eliminarLibro(id);
        return "redirect:/Api/Admin/Libros";
    }
}