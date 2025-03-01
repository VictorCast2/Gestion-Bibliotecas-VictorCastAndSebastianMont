package com.App.Gestion_Bibliotecas_VictorCastAndSebastianMont.Controller;

import com.App.Gestion_Bibliotecas_VictorCastAndSebastianMont.Model.LibroModel;
import com.App.Gestion_Bibliotecas_VictorCastAndSebastianMont.Services.LibroServices;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@Data
@Controller
@RequestMapping("/Api/Admin")
@AllArgsConstructor
public class AdminController {

    @Autowired
    private final LibroServices libroServices;

    @PostMapping("/UsuariosPrestamo")
    public String buscarUsuariosPrestamos(Model model){
        model.addAttribute("usuariosPrestamos", new ArrayList<>());
        return "Libros";
    }

    @PostMapping("/Agregar")
    public String agregarLibro(@ModelAttribute LibroModel libro) {
        libroServices.guardarLibro(libro);
        return "Libros";
    }

    @PutMapping("/Actualizar")
    public String actualizarLibro(LibroModel libro) {
        libroServices.actualizarLibro(libro);
        return "Libros";
    }

    @DeleteMapping("/Eliminar")
    public String eliminarLibro(@RequestParam Long id) {
        libroServices.eliminarLibro(id);
        return "Libros";
    }

    @GetMapping("/Home")
    public String Admin(Model model) {
        model.addAttribute("libro","Libros");
        return "Libros";
    }

}