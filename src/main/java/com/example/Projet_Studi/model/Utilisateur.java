package com.example.Projet_Studi.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;


/**
 * Cette classe représente un utilisateur dans l'application.
 * Un utilisateur a un identifiant, un nom, un prénom, une adresse e-mail et un mot de passe.
 *
 * @author Anthony
 * @version Version initiale
 *
 */
@Entity
@Table(name = "utilisateur")
public class Utilisateur {

    /**
     * L'identifiant unique de l'utilisateur.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Le nom de famille de l'utilisateur.
     */
    @Column(name = "nom")
    private String nom;

    /**
     * Le prénom de l'utilisateur.
     */
    @Column(name = "prenom")
    private String prenom;

    /**
     * L'adresse e-mail de l'utilisateur.
     */
    @Column(name = "email")
    private String email;

    /**
     * Le mot de passe de l'utilisateur. Il est recommandé de stocker les mots de passe de manière sécurisée en utilisant un algorithme de hachage.
     */
    @Column(name = "mot_de_passe")
    private String motDePasse;
    /**
     * Le type d'utilisateur.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "type_utilisateur")
    private TypeUtilisateur typeUtilisateur;

    @Column(name ="date_creation")
    private LocalDateTime dateCreation;


    // Getters and Setters

    /**
     * Obtient l'identifiant de l'utilisateur.
     *
     * @return l'identifiant de l'utilisateur.
     */
    public Long getId() {
        return id;
    }

    /**
     * Définit l'identifiant de l'utilisateur.
     *
     * @param id l'identifiant à définir.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtient le nom de famille de l'utilisateur.
     *
     * @return le nom de famille de l'utilisateur.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définit le nom de famille de l'utilisateur.
     *
     * @param nom le nom de famille à définir.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Obtient le prénom de l'utilisateur.
     *
     * @return le prénom de l'utilisateur.
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Définit le prénom de l'utilisateur.
     *
     * @param prenom le prénom à définir.
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Obtient l'adresse e-mail de l'utilisateur.
     *
     * @return l'adresse e-mail de l'utilisateur.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Définit l'adresse e-mail de l'utilisateur.
     *
     * @param email l'adresse e-mail à définir.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtient le mot de passe de l'utilisateur.
     *
     * @return le mot de passe de l'utilisateur.
     */
    public String getMotDePasse() {
        return motDePasse;
    }

    /**
     * Définit le mot de passe de l'utilisateur. Il est recommandé de stocker les mots de passe de manière sécurisée en utilisant un algorithme de hachage.
     *
     * @param motDePasse le mot de passe à définir.
     */
    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }
    /**
     * Obtient le type d'utilisateur.
     *
     * @return le type d'utilisateur.
     */
    public TypeUtilisateur getTypeUtilisateur() {
        return typeUtilisateur;
    }

    /**
     * Définit le type d'utilisateur.
     *
     * @param typeUtilisateur le type d'utilisateur à définir.
     */
    public void setTypeUtilisateur(TypeUtilisateur typeUtilisateur) {
        this.typeUtilisateur = typeUtilisateur;
    }

}

