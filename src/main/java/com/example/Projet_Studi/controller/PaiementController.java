package com.example.Projet_Studi.controller;
import com.example.Projet_Studi.model.Commande;
import com.example.Projet_Studi.model.Paiement;
import com.example.Projet_Studi.services.PaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/paiements")
public class PaiementController {

    @Autowired
    private PaiementService paiementService;

    // Méthode pour créer un nouveau paiement
    @PostMapping("/creer")
    public Paiement creerPaiement(@RequestBody Paiement paiement) {
        return paiementService.creerPaiement(paiement.getCommande(), paiement.getMontant(), paiement.getMethodePaiement());
    }

    // Méthode pour récupérer un paiement par son ID
    @GetMapping("/{id}")
    public Paiement getPaiementById(@PathVariable Long id) {
        return paiementService.getPaiementById(id);
    }

    // Méthode pour récupérer tous les paiements
    @GetMapping("/tous")
    public List<Paiement> getAllPaiements() {
        return paiementService.getAllPaiements();
    }

    // Méthode pour rechercher des paiements par commande
    @GetMapping("/rechercher/commande/{idCommande}")
    public List<Paiement> rechercherPaiementsParCommande(@PathVariable Long idCommande) {
        Commande commande = new Commande();
        commande.setId(idCommande);
        return paiementService.rechercherPaiementsParCommande(commande);
    }

    // Méthode pour rechercher des paiements par montant
    @GetMapping("/rechercher/montant/{montant}")
    public List<Paiement> rechercherPaiementsParMontant(@PathVariable BigDecimal montant) {
        return paiementService.rechercherPaiementsParMontant(montant);
    }

    // Méthode pour rechercher des paiements par date de paiement
    @GetMapping("/rechercher/date-paiement/{datePaiement}")
    public List<Paiement> rechercherPaiementsParDatePaiement(@PathVariable LocalDateTime datePaiement) {
        return paiementService.rechercherPaiementsParDatePaiement(datePaiement);
    }

    // Méthode pour rechercher des paiements par méthode de paiement
    @GetMapping("/rechercher/methode-paiement/{methodePaiement}")
    public List<Paiement> rechercherPaiementsParMethodePaiement(@PathVariable String methodePaiement) {
        return paiementService.rechercherPaiementsParMethodePaiement(methodePaiement);
    }

    // Méthode pour rechercher des paiements par commande et date de paiement
    @GetMapping("/rechercher/commande-date-paiement/{idCommande}/{datePaiement}")
    public List<Paiement> rechercherPaiementsParCommandeEtDatePaiement(@PathVariable Long idCommande, @PathVariable LocalDateTime datePaiement) {
        Commande commande = new Commande();
        commande.setId(idCommande);
        return paiementService.rechercherPaiementsParCommandeEtDatePaiement(commande, datePaiement);
    }

    // Méthode pour mettre à jour un paiement
    @PutMapping("/mettre-a-jour")
    public Paiement mettreAJourPaiement(@RequestBody Paiement paiement) {
        return paiementService.mettreAJourPaiement(paiement);
    }

    // Méthode pour supprimer un paiement par son ID
    @DeleteMapping("/supprimer/{id}")
    public void supprimerPaiement(@PathVariable Long id) {
        paiementService.supprimerPaiement(id);
    }
}
