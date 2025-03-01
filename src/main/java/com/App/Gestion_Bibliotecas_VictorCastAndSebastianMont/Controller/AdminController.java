package com.App.Gestion_Bibliotecas_VictorCastAndSebastianMont.Controller;

import com.App.Gestion_Bibliotecas_VictorCastAndSebastianMont.Model.LibroModel;
import com.App.Gestion_Bibliotecas_VictorCastAndSebastianMont.Services.LibroServices;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Data
@Controller
@RequestMapping("/Api/Admin")
@AllArgsConstructor
public class AdminController {

    @Autowired
    private final LibroServices libroServices;

    @PostMapping("/Agregar")
    public String agregarLibro(@ModelAttribute LibroModel libro) {
        libroServices.guardarLibro(libro);
        return "redirect:/Api/Admin/Home";
    }

    @PutMapping("/Actualizar")
    public String actualizarLibro(LibroModel libro) {
        libroServices.actualizarLibro(libro);
        return "redirect:/Api/Admin/Home";
    }

    @DeleteMapping("/Eliminar")
    public String eliminarLibro(@RequestParam Long id) {
        libroServices.eliminarLibro(id);
        return "redirect:/Api/Admin/Home";
    }

    @GetMapping("/Home")
    public String Admin(Model model) {
        model.addAttribute("libros",libroServices.buscarLibro());
        return "Libros";
    }

}