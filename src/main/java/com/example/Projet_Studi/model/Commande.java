package com.example.Projet_Studi.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Cette classe représente une commande passée par un utilisateur.
 * Une commande est associée à un utilisateur, a une quantité de billets et une date de commande.
 *
 * @author Anthony
 * @version Version initiale
 */
@Entity
@Table(name= "commande")
@Data // Génère getters, setters, toString, equals, et hashCode
@NoArgsConstructor // Génère un constructeur sans arguments
@AllArgsConstructor // Génère un constructeur avec tous les arguments
public class Commande implements Serializable {

    private static final long serialVersionUID = 1L;

    // L'identifiant unique de la commande.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // L'utilisateur qui a passé la commande.
    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;

    // La quantité de billets dans la commande.
    @Column(name = "quantite")
    private int quantite;

    // La date de la commande.
    @Column(name ="date_commande")
    private LocalDateTime dateCommande;
}
