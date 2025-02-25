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
	 * @param args
	 * @throws Exception
	 */
	@Override
	public void run(String... args) throws Exception {
		BCryptPasswordEncoder encoder1 = new BCryptPasswordEncoder();
		String rawPassword1 = "admin";
		String encodedPassword1 = encoder1.encode(rawPassword1);
		System.out.println("Contraseña encriptada del Admin: " + encodedPassword1);

		BCryptPasswordEncoder encoder2 = new BCryptPasswordEncoder();
		String rawPassword2 = "user";
		String encodedPassword2 = encoder2.encode(rawPassword2);
		System.out.println("Contraseña encriptada del User: " + encodedPassword2);
	}

}