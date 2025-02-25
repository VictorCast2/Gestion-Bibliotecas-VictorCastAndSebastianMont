package com.App.Gestion_Bibliotecas_VictorCastAndSebastianMont.Controller;

import com.App.Gestion_Bibliotecas_VictorCastAndSebastianMont.Services.LibroService;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Data
@Controller
@RequestMapping("/Api/User")
@PreAuthorize("hasRole('User')")
@AllArgsConstructor
public class UserController {

    @Autowired
    private final LibroService libroService;

    @GetMapping("/Buscar")
    public String buscarLibro() {
        libroService.buscarLibro();
        return "";
    }

    @GetMapping("/Prestamo")
    public String solicitarPrestamoLibro() {
        libroService.solicitarPrestamoLibro();
        return "";
    }

}