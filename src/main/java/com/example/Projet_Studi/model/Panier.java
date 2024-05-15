package com.example.Projet_Studi.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Cette classe représente un panier d'utilisateur.
 * Un panier est associé à un utilisateur et contient la date de sa création.
 *
 * @author Anthony
 * @version Version initiale
 *
 */
@Entity
@Table(name = "panier")
public class Panier {

    /**
     * L'identifiant unique du panier.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * L'utilisateur associé au panier.
     */
    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;

    /**
     * La date de création du panier.
     */
    @Column(name = "date_creation")
    private LocalDateTime dateCreation;

    // Getters and Setters

    /**
     * Obtient l'identifiant du panier.
     *
     * @return l'identifiant du panier.
     */
    public Long getId() {
        return id;
    }

    /**
     * Définit l'identifiant du panier.
     *
     * @param id l'identifiant à définir.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtient l'utilisateur associé au panier.
     *
     * @return l'utilisateur associé au panier.
     */
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    /**
     * Définit l'utilisateur associé au panier.
     *
     * @param utilisateur l'utilisateur à associer.
     */
    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    /**
     * Obtient la date de création du panier.
     *
     * @return la date de création du panier.
     */
    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    /**
     * Définit la date de création du panier.
     *
     * @param dateCreation la date de création à définir.
     */
    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }
}
