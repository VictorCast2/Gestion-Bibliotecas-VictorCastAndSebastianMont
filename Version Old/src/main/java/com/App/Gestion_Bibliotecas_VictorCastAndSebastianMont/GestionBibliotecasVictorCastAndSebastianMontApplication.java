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
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String rawPassword = "tuContraseña"; // Asegúrate de probar con la contraseña correcta
		String encodedPassword = encoder.encode("tuContraseña");

		if (encoder.matches(rawPassword, encodedPassword)) {
			System.out.println("¡Contraseña válida!");
		} else {
			System.out.println("Contraseña incorrecta.");
		}
	}

}