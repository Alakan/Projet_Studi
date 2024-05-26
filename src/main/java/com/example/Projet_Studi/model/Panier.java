package com.example.Projet_Studi.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Cette classe représente un panier d'utilisateur.
 * Un panier est associé à un utilisateur et contient la date de sa création.
 *
 * @author Anthony
 * @version Version initiale
 */
@Entity
@Table(name = "panier")
@Data // Génère getters, setters, toString, equals, et hashCode
@NoArgsConstructor // Génère un constructeur sans arguments
@AllArgsConstructor // Génère un constructeur avec tous les arguments
public class Panier implements Serializable {

    private static final long serialVersionUID = 1L;

    // L'identifiant unique du panier.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // L'utilisateur associé au panier.
    @ManyToOne
    @JoinColumn(name = "id_utilisateur", nullable = false)
    private Utilisateur utilisateur;

    // La date de création du panier.
    @Column(name = "date_creation", nullable = false)
    private LocalDateTime dateCreation;
}
