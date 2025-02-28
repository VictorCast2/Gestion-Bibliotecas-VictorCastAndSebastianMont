package com.App.Gestion_Bibliotecas_VictorCastAndSebastianMont.Controller;

import com.App.Gestion_Bibliotecas_VictorCastAndSebastianMont.Service.LibroServices;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Data
@Controller
@RequestMapping("/Api/User")
@AllArgsConstructor
public class UserController {

    @Autowired
    private final LibroServices libroService;

    @GetMapping("/Buscar")
    public String buscarLibro() {
        libroService.buscarLibro();
        return "";
    }

    @GetMapping("/Prestamo")
    public String solicitarPrestamoLibro(@RequestParam("id") Long id) {
        libroService.solicitarPrestamoLibro(id);
        return "";
    }

}