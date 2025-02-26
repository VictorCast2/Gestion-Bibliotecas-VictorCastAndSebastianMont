package com.App.Gestion_Bibliotecas_VictorCastAndSebastianMont.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

}