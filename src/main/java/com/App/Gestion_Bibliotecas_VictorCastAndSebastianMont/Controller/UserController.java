package com.App.Gestion_Bibliotecas_VictorCastAndSebastianMont.Controller;

import lombok.*;
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

    @GetMapping("/Catalogo")
    public String verCatalogo() {
        return "";
    }

}