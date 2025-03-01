package com.App.Gestion_Bibliotecas_VictorCastAndSebastianMont.Services;

import com.App.Gestion_Bibliotecas_VictorCastAndSebastianMont.Model.UserModel;
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

    /**
     * Registra un usuario en la base de datos
     * @param user
     */
    public void registrarUser(UserModel user){
        userRepository.save(user);
    }

    /**
     * Elimina un usuario de la base de datos
     */
    public void modificarUser(UserModel user){
        if(userRepository.existsById(user.getId())) {
            userRepository.save(user);
        } else {
            throw new IllegalArgumentException("El usuario no existe ... ");
        }
    }

}