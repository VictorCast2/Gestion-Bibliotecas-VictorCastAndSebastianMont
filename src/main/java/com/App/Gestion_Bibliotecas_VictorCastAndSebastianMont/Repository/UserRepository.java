package com.App.Gestion_Bibliotecas_VictorCastAndSebastianMont.Repository;

import com.App.Gestion_Bibliotecas_VictorCastAndSebastianMont.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    /**
     * Método que busca un usuario por su nombre de usuario
     * @param username nombre de usuario
     * @return usuario
     */
    Optional<UserModel> findByUsername(String username);
}