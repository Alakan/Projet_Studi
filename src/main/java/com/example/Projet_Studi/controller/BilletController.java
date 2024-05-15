package com.example.Projet_Studi.controller;

import com.example.Projet_Studi.model.Billet;
import com.example.Projet_Studi.model.Commande;
import com.example.Projet_Studi.model.Utilisateur;
import com.example.Projet_Studi.services.BilletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/billets")
public class BilletController {

    @Autowired
    private BilletService billetService;

    // Méthode pour créer un nouveau billet et l'associer à une commande et un utilisateur
    @PostMapping("/creer")
    public Billet creerBillet(@RequestBody Commande commande, @RequestBody Utilisateur utilisateur) {
        return billetService.creerBillet(commande, utilisateur);
    }

    // Méthode pour récupérer un billet par son ID
    @GetMapping("/{id}")
    public Billet getBilletById(@PathVariable Long id) {
        return billetService.getBilletById(id);
    }

    // Méthode pour récupérer tous les billets
    @GetMapping("/tous")
    public List<Billet> getAllBillets() {
        return billetService.getAllBillets();
    }

    // Méthode pour rechercher les billets associés à une commande
    @GetMapping("/rechercher/commande/{idCommande}")
    public List<Billet> rechercherBilletsParCommande(@PathVariable Long idCommande) {
        Commande commande = new Commande();
        commande.setId(idCommande);
        return billetService.rechercherBilletsParCommande(commande);
    }

    // Méthode pour rechercher les billets associés à un utilisateur
    @GetMapping("/rechercher/utilisateur/{idUtilisateur}")
    public List<Billet> rechercherBilletsParUtilisateur(@PathVariable Long idUtilisateur) {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(idUtilisateur);
        return billetService.rechercherBilletsParUtilisateur(utilisateur);
    }

    // Méthode pour mettre à jour un billet existant
    @PutMapping("/mettre-a-jour")
    public Billet mettreAJourBillet(@RequestBody Billet billet) {
        return billetService.mettreAJourBillet(billet);
    }

    // Méthode pour supprimer un billet par son ID
    @DeleteMapping("/supprimer/{id}")
    public void supprimerBillet(@PathVariable Long id) {
        billetService.supprimerBillet(id);
    }
}
