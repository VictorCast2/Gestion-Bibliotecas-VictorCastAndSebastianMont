package com.App.Gestion_Bibliotecas_VictorCastAndSebastianMont.Services;

import com.App.Gestion_Bibliotecas_VictorCastAndSebastianMont.Repository.UserRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
@AllArgsConstructor
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    

}