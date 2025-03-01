package com.App.Gestion_Bibliotecas_VictorCastAndSebastianMont;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class GestionBibliotecasVictorCastAndSebastianMontApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(GestionBibliotecasVictorCastAndSebastianMontApplication.class, args);
	}

	/**
	 * Método que se ejecuta al iniciar la aplicación
	 * @throws Exception
	 */
	@Override
	public void run(String... args) throws Exception {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode("admin");
		System.out.println("Password {Admin}: "+encodedPassword);

		String encodedPassword2 = encoder.encode("user");
		System.out.println("Password {User}: "+encodedPassword2);
	}

}