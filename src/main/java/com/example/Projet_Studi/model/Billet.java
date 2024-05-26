package com.example.Projet_Studi.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

/**
 * Cette classe représente un billet.
 * Un billet est associé à une commande et à un utilisateur. Il possède une clé unique et un QR code.
 *
 * @author Anthony
 * @version Version initiale
 */
@Entity
@Table(name = "billet")
@Data // Génère getters, setters, toString, equals, et hashCode
@NoArgsConstructor // Génère un constructeur sans arguments
@AllArgsConstructor // Génère un constructeur avec tous les arguments
public class Billet implements Serializable {

    private static final long serialVersionUID = 1L;

    // L'identifiant unique du billet.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // La commande à laquelle est associé le billet.
    @ManyToOne
    @JoinColumn(name = "id_commande")
    private Commande commande;

    // L'utilisateur qui possède le billet.
    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;

    // La clé unique du billet.
    @Column(name = "cle_billet")
    private String cleBillet;

    // Le QR code du billet.
    @Column(name = "qrcode")
    private String qrcode;
}
