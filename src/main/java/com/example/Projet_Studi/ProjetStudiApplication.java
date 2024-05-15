package com.example.Projet_Studi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Cette classe est le point d'entrée de l'application Spring Boot "Projet Studi".
 * Spring Boot utilise des annotations pour la configuration et la gestion des applications.
 *
 * @author Anthony
 * @version Version initiale
 */

@SpringBootApplication
public class ProjetStudiApplication {

	/**
	 * La méthode main est le point d'entrée principal de l'application.
	 * Elle démarre l'application Spring Boot en utilisant la classe SpringApplication.
	 *
	 * @param args Les arguments en ligne de commande passés à l'application.
	 */
	public static void main(String[] args) {
		SpringApplication.run(ProjetStudiApplication.class, args);
	}
}
