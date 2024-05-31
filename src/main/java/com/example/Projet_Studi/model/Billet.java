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
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Billet implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_commande", nullable = false) // Assure que la commande est obligatoire
    private Commande commande;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur", nullable = false) // Assure que l'utilisateur est obligatoire
    private Utilisateur utilisateur;

    @Column(name = "cle_billet")
    private String cleBillet;

    @Column(name = "qrcode")
    private String qrcode;
}
