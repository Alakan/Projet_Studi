package com.example.Projet_Studi.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name= "commande")
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    private  Utilisateur utilisateur;

    @Column(name = "quantite")
    private int quantite;

    @Column(name ="date_commande")
    private LocalDateTime dateCommande;


// Getters and Setters

    public Long getId(){
        return id;
    }
    public void setId (Long id) {
        this.id = id;
    }
    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public LocalDateTime getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(LocalDateTime dateCommande) {
        this.dateCommande = dateCommande;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
}
