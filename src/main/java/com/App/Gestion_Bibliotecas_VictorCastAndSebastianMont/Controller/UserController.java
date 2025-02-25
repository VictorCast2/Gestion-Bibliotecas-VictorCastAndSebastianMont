package com.App.Gestion_Bibliotecas_VictorCastAndSebastianMont.Controller;

import lombok.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Data
@Controller
@RequestMapping("/Api/User")
@PreAuthorize("hasRole('Admin')")
@AllArgsConstructor
public class UserController {
}
