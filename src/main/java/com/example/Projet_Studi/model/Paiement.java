package com.example.Projet_Studi.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Cette classe représente un paiement.
 * Un paiement a un identifiant unique, un montant (en BigDecimal), une date de paiement (en LocalDateTime), une méthode de paiement (ex: carte bancaire, PayPal, etc.) et est associé à une commande.
 *
 * @author Anthony
 * @version Version initiale
 */
@Entity
@Table(name = "paiement")
@Data // Génère getters, setters, toString, equals, et hashCode
@NoArgsConstructor // Génère un constructeur sans arguments
@AllArgsConstructor // Génère un constructeur avec tous les arguments
public class Paiement implements Serializable {

    private static final long serialVersionUID = 1L;

    // L'identifiant unique du paiement.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // La commande associée au paiement.
    @ManyToOne
    @JoinColumn(name = "id_commande", nullable = false)
    private Commande commande;

    // Le montant du paiement (utilisant la classe BigDecimal pour une meilleure précision décimale).
    @Column(name = "montant", nullable = false)
    private BigDecimal montant;

    // La date et l'heure du paiement.
    @Column(name = "date_paiement", nullable = false)
    private LocalDateTime datePaiement;

    // La méthode de paiement utilisée (ex: carte bancaire, PayPal, etc.).
    @Column(name = "methode_paiement", nullable = false)
    private String methodePaiement;
}
