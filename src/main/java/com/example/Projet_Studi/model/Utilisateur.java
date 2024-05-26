package com.example.Projet_Studi.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.*;
import java.io.Serializable;

/**
 * Cette classe représente un utilisateur dans l'application.
 * Un utilisateur a un identifiant, un nom, un prénom, une adresse e-mail et un mot de passe.
 *
 * @author Anthony
 * @version Version initiale
 */
@Entity
@Table(name = "utilisateur")
@Data // Génère getters, setters, toString, equals, et hashCode
@NoArgsConstructor // Génère un constructeur sans arguments
@AllArgsConstructor // Génère un constructeur avec tous les arguments
public class Utilisateur implements Serializable {

    private static final long serialVersionUID = 1L;

    // L'identifiant unique de l'utilisateur.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Le nom de famille de l'utilisateur.
    @Column(name = "nom", nullable = false)
    private String nom;

    // Le prénom de l'utilisateur.
    @Column(name = "prenom", nullable = false)
    private String prenom;

    // L'adresse e-mail de l'utilisateur.
    @Column(name = "email", unique = true, nullable = false)
    private String email;

    // Le mot de passe de l'utilisateur.
    @Column(name = "mot_de_passe", nullable = false)
    private String motDePasse;

    // Le type d'utilisateur.
    @Enumerated(EnumType.STRING)
    @Column(name = "type_utilisateur")
    private TypeUtilisateur typeUtilisateur;

    // La date de création de l'utilisateur.
    @Column(name ="date_creation", nullable = false)
    private LocalDateTime dateCreation;
}
