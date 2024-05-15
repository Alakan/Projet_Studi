package com.example.Projet_Studi.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

/**
 * Cette classe représente une offre de billet.
 * Une offre de billet a un identifiant unique, un type d'offre (défini par l'enum TypeOffre), un prix (en BigDecimal pour une meilleure gestion des décimales), et une description.
 *
 *  @author Anthony
 *  @version Version initiale
 *
 */
@Entity
@Table(name = "offre_de_billet")
public class OffreDeBillet {

    /**
     * L'identifiant unique de l'offre de billet.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Le type d'offre de billet (SOLO, DUO, FAMILIALE).
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "type_offre")
    private TypeOffre typeOffre;

    /**
     * Le prix de l'offre de billet (utilisant la classe BigDecimal pour une meilleure précision décimale).
     */
    @Column(name = "prix")
    private BigDecimal prix;

    /**
     * La description de l'offre de billet.
     */
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    // Getters and Setters

    /**
     * Obtient l'identifiant de l'offre de billet.
     *
     * @return l'identifiant de l'offre de billet.
     */
    public Long getId() {
        return id;
    }

    /**
     * Définit l'identifiant de l'offre de billet.
     *
     * @param id l'identifiant à définir.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtient le type d'offre de billet.
     *
     * @return le type d'offre de billet.
     */
    public TypeOffre getTypeOffre() {
        return typeOffre;
    }

    /**
     * Définit le type d'offre de billet.
     *
     * @param typeOffre le type d'offre à définir.
     */
    public void setTypeOffre(TypeOffre typeOffre) {
        this.typeOffre = typeOffre;
    }

    /**
     * Obtient le prix de l'offre de billet.
     *
     * @return le prix de l'offre de billet.
     */
    public BigDecimal getPrix() {
        return prix;
    }

    /**
     * Définit le prix de l'offre de billet.
     *
     * @param prix le prix à définir.
     */
    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    /**
     * Obtient la description de l'offre de billet.
     *
     * @return la description de l'offre de billet.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Définit la description de l'offre de billet.
     *
     * @param description la description à définir.
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
