package com.App.Gestion_Bibliotecas_VictorCastAndSebastianMont.Controller;

import java.util.ArrayList;
import com.App.Gestion_Bibliotecas_VictorCastAndSebastianMont.Model.LibroModel;
import com.App.Gestion_Bibliotecas_VictorCastAndSebastianMont.Service.LibroServices;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Data
@RestController
@RequestMapping("/Api/Admin")
@AllArgsConstructor
public class LibroController {

    @Autowired
    private final LibroServices libroServices;

    @GetMapping("/Libros")
    public String listarLibros(Model model) {

        return "Libros";
    }

    @GetMapping("/UsuariosPrestamo")
    public String listarUsuariosPrestamo(Model model){
        model.addAttribute("usuarios", new ArrayList<>());
        return "usuarios";
    }

    @PostMapping("/Agregar")
    public String agregarLibro(@ModelAttribute LibroModel libro) {
        libroServices.guardarLibro(libro);
        return "Libros";
    }

    @PostMapping("/Actualizar")
    public String actualizarLibro(LibroModel libro) {
        libroServices.actualizarLibro(libro);
        return "";
    }

    @PostMapping("/Eliminar")
    public String eliminarLibro(@RequestParam Long id) {
        libroServices.eliminarLibro(id);
        return "Libros";
    }

}