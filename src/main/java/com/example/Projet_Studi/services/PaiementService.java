package com.example.Projet_Studi.services;

import com.example.Projet_Studi.model.Commande;
import com.example.Projet_Studi.model.Paiement;
import com.example.Projet_Studi.repository.PaiementRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PaiementService {

    @Autowired
    private PaiementRepository paiementRepository;

    @Autowired
    private CommandeService commandeService; // Injectez le service Commande pour la gestion des commandes

    // Crée un nouveau paiement et l'associe à une commande existante.
    @Transactional
    public Paiement creerPaiement(Commande commande, BigDecimal montant, String methodePaiement) {
        // Vérifier si la commande existe
        Commande commandeExistante = commandeService.getCommandeById(commande.getId());

        // Créer un nouveau paiement
        Paiement paiement = new Paiement();
        paiement.setCommande(commandeExistante);
        paiement.setMontant(montant);
        paiement.setDatePaiement(LocalDateTime.now());
        paiement.setMethodePaiement(methodePaiement);

        // Enregistrer le paiement dans la base de données
        return paiementRepository.save(paiement);
    }

    // Récupère un paiement par son ID.
    public Paiement getPaiementById(Long idPaiement) {
        return paiementRepository.findById(idPaiement)
                .orElseThrow(() -> new EntityNotFoundException("Paiement introuvable avec l'ID : " + idPaiement));
    }

    // Récupère tous les paiements.
    public List<Paiement> getAllPaiements() {
        return paiementRepository.findAll();
    }

    // Recherche les paiements par commande.
    public List<Paiement> rechercherPaiementsParCommande(Commande commande) {
        return paiementRepository.findByCommande(commande);
    }

    // Recherche les paiements par montant.
    public List<Paiement> rechercherPaiementsParMontant(BigDecimal montant) {
        return paiementRepository.findByMontant(montant);
    }

    // Recherche les paiements par date de paiement.
    public List<Paiement> rechercherPaiementsParDatePaiement(LocalDateTime datePaiement) {
        return paiementRepository.findByDatePaiement(datePaiement);
    }

    // Recherche les paiements par méthode de paiement.
    public List<Paiement> rechercherPaiementsParMethodePaiement(String methodePaiement) {
        return paiementRepository.findByMethodePaiement(methodePaiement);
    }

    // Recherche les paiements par commande et date de paiement.
    public List<Paiement> rechercherPaiementsParCommandeEtDatePaiement(Commande commande, LocalDateTime datePaiement) {
        return paiementRepository.findByCommandeAndDatePaiement(commande, datePaiement);
    }

    // Met à jour un paiement existant.
    public Paiement mettreAJourPaiement(Paiement paiement) {
        // Vérifier si le paiement existe
        Paiement paiementExistant = paiementRepository.findById(paiement.getId())
                .orElseThrow(() -> new EntityNotFoundException("Paiement introuvable avec l'ID : " + paiement.getId()));

        // Mettre à jour les champs du paiement avec les nouvelles valeurs
        paiementExistant.setMontant(paiement.getMontant());
        paiementExistant.setDatePaiement(paiement.getDatePaiement());
        paiementExistant.setMethodePaiement(paiement.getMethodePaiement());

        // Enregistrer le paiement mis à jour dans la base de données
        return paiementRepository.save(paiementExistant);
    }

    // Supprime un paiement par son ID.
    public void supprimerPaiement(Long idPaiement) {
        paiementRepository.deleteById(idPaiement);
    }
}
