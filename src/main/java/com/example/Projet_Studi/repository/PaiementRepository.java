package com.example.Projet_Studi.repository;

import com.example.Projet_Studi.model.Commande;
import com.example.Projet_Studi.model.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PaiementRepository extends JpaRepository<Paiement, Long> {

    // Recherche des paiements par commande
    List<Paiement> findByCommande(Commande commande);

    // Recherche des paiements par montant
    List<Paiement> findByMontant(BigDecimal montant);

    // Recherche des paiements par date de paiement
    List<Paiement> findByDatePaiement(LocalDateTime datePaiement);

    // Recherche des paiements par méthode de paiement
    List<Paiement> findByMethodePaiement(String methodePaiement);

    // Recherche des paiements par commande et date de paiement
    List<Paiement> findByCommandeAndDatePaiement(Commande commande, LocalDateTime datePaiement);

    // Autres méthodes de recherche et de filtrage selon vos besoins
}
