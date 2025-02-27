package com.App.Gestion_Bibliotecas_VictorCastAndSebastianMont.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador de autenticación.
 */
@Controller
@RequestMapping("/Api/Auth/")
public class AuthController {

    @GetMapping("/Login")
    public String Login() {
        return "Login";
    }

    @GetMapping("/Home")
    public String home() {
        return "Libros";
    }

}
