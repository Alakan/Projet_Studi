package com.example.Projet_Studi.model;

import jakarta.persistence.*;

/**
 * Cette classe représente un billet.
 * Un billet est associé à une commande et à un utilisateur. Il possède une clé unique et un QR code.
 *
 * @author Anthony
 * @version Version initiale
 */
@Entity
@Table(name = "billet")
public class Billet {

    /**
     * L'identifiant unique du billet.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * La commande à laquelle est associé le billet.
     */
    @ManyToOne
    @JoinColumn(name = "id_commande")
    private Commande commande;

    /**
     * L'utilisateur qui possède le billet.
     */
    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;

    /**
     * La clé unique du billet.
     */
    @Column(name = "cle_billet")
    private String cleBillet;

    /**
     * Le QR code du billet.
     */
    @Column(name = "qrcode")
    private String qrcode;

    // Getters and Setters

    /**
     * Obtient l'identifiant du billet.
     *
     * @return l'identifiant du billet.
     */
    public Long getId() {
        return id;
    }

    /**
     * Définit l'identifiant du billet.
     *
     * @param id l'identifiant à définir.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtient la commande associée au billet.
     *
     * @return la commande associée au billet.
     */
    public Commande getCommande() {
        return commande;
    }

    /**
     * Définit la commande associée au billet.
     *
     * @param commande la commande à associer.
     */
    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    /**
     * Obtient l'utilisateur qui possède le billet.
     *
     * @return l'utilisateur qui possède le billet.
     */
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    /**
     * Définit l'utilisateur qui possède le billet.
     *
     * @param utilisateur l'utilisateur à définir.
     */
    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    /**
     * Obtient la clé unique du billet.
     *
     * @return la clé unique du billet.
     */
    public String getCleBillet() {
        return cleBillet;
    }

    /**
     * Définit la clé unique du billet.
     *
     * @param cleBillet la clé unique à définir.
     */
    public void setCleBillet(String cleBillet) {
        this.cleBillet = cleBillet;
    }

    /**
     * Obtient le QR code du billet.
     *
     * @return le QR code du billet.
     */
    public String getQrcode() {
        return qrcode;
    }

    /**
     * Définit le QR code du billet.
     *
     * @param qrcode le QR code à définir.
     */
    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }
}
