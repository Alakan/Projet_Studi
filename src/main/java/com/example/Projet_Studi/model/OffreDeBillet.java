package com.example.Projet_Studi.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Cette classe représente une offre de billet.
 * Une offre de billet a un identifiant unique, un type d'offre (défini par l'enum TypeOffre), un prix (en BigDecimal pour une meilleure gestion des décimales), et une description.
 *
 * @author Anthony
 * @version Version initiale
 */
@Entity
@Table(name = "offre_de_billet")
@Data // Génère getters, setters, toString, equals, et hashCode
@NoArgsConstructor // Génère un constructeur sans arguments
@AllArgsConstructor // Génère un constructeur avec tous les arguments
public class OffreDeBillet implements Serializable {

    private static final long serialVersionUID = 1L;

    // L'identifiant unique de l'offre de billet.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Le type d'offre de billet (SOLO, DUO, FAMILIALE).
    @Enumerated(EnumType.STRING)
    @Column(name = "type_offre", nullable = false)
    private TypeOffre typeOffre;

    // Le prix de l'offre de billet (utilisant la classe BigDecimal pour une meilleure précision décimale).
    @Column(name = "prix", nullable = false)
    private BigDecimal prix;

    // La description de l'offre de billet.
    @Column(name = "description", columnDefinition = "TEXT", nullable = false)
    private String description;
}
