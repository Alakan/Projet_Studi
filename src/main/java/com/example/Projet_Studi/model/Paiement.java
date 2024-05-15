package com.example.Projet_Studi.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Cette classe représente un paiement.
 * Un paiement a un identifiant unique, un montant (en BigDecimal), une date de paiement (en LocalDateTime), une méthode de paiement (ex: carte bancaire, PayPal, etc.) et est associé à une commande.
 *
 * @author Anthony
 * @version Version initiale
 *
 */
@Entity
@Table(name = "paiement")
public class Paiement {

    /**
     * L'identifiant unique du paiement.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * La commande associée au paiement.
     */
    @ManyToOne
    @JoinColumn(name = "id_commande")
    private Commande commande;

    /**
     * Le montant du paiement (utilisant la classe BigDecimal pour une meilleure précision décimale).
     */
    @Column(name = "montant")
    private BigDecimal montant;

    /**
     * La date et l'heure du paiement.
     */
    @Column(name = "date_paiement")
    private LocalDateTime datePaiement;

    /**
     * La méthode de paiement utilisée (ex: carte bancaire, PayPal, etc.).
     */
    @Column(name = "methode_paiement")
    private String methodePaiement;

    // Getters and Setters

    /**
     * Obtient l'identifiant du paiement.
     *
     * @return l'identifiant du paiement.
     */
    public Long getId() {
        return id;
    }

    /**
     * Définit l'identifiant du paiement.
     *
     * @param id l'identifiant à définir.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtient le montant du paiement.
     *
     * @return le montant du paiement.
     */
    public BigDecimal getMontant() {
        return montant;
    }

    /**
     * Définit le montant du paiement.
     *
     * @param montant le montant à définir.
     */
    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    /**
     * Obtient la commande associée au paiement.
     *
     * @return la commande associée au paiement.
     */
    public Commande getCommande() {
        return commande;
    }

    /**
     * Définit la commande associée au paiement.
     *
     * @param commande la commande à associer.
     */
    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    /**
     * Obtient la date et l'heure du paiement.
     *
     * @return la date et l'heure du paiement.
     */
    public LocalDateTime getDatePaiement() {
        return datePaiement;
    }

    /**
     * Définit la date et l'heure du paiement.
     *
     * @param datePaiement la date et l'heure à définir.
     */
    public void setDatePaiement(LocalDateTime datePaiement) {
        this.datePaiement = datePaiement;
    }

    /**
     * Obtient la méthode de paiement utilisée.
     *
     * @return la méthode de paiement utilisée.
     */
    public String getMethodePaiement() {
        return methodePaiement;
    }

    /**
     * Définit la méthode de paiement utilisée.
     *
     * @param methodePaiement la méthode de paiement à définir.
     */
    public void setMethodePaiement(String methodePaiement) {
        this.methodePaiement = methodePaiement;
    }

}
