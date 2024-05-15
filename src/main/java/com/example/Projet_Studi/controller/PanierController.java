package com.example.Projet_Studi.controller;

import com.example.Projet_Studi.model.Panier;
import com.example.Projet_Studi.model.Utilisateur;
import com.example.Projet_Studi.services.PanierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/paniers")
public class PanierController {

    @Autowired
    private PanierService panierService;

    // Méthode pour créer un nouveau panier
    @PostMapping("/creer")
    public Panier creerPanier(@RequestBody Utilisateur utilisateur) {
        return panierService.creerPanier(utilisateur);
    }

    // Méthode pour récupérer un panier par son ID
    @GetMapping("/{id}")
    public Panier getPanierById(@PathVariable Long id) {
        return panierService.getPanierById(id);
    }

    // Méthode pour récupérer tous les paniers
    @GetMapping("/tous")
    public List<Panier> getAllPaniers() {
        return panierService.getAllPaniers();
    }

    // Méthode pour rechercher des paniers par utilisateur
    @GetMapping("/rechercher/utilisateur/{idUtilisateur}")
    public List<Panier> rechercherPaniersParUtilisateur(@PathVariable Long idUtilisateur) {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(idUtilisateur);
        return panierService.rechercherPaniersParUtilisateur(utilisateur);
    }

    // Méthode pour rechercher des paniers par date de création
    @GetMapping("/rechercher/date-creation/{dateCreation}")
    public List<Panier> rechercherPaniersParDateCreation(@PathVariable LocalDateTime dateCreation) {
        return panierService.rechercherPaniersParDateCreation(dateCreation);
    }

    // Méthode pour mettre à jour un panier
    @PutMapping("/mettre-a-jour")
    public Panier mettreAJourPanier(@RequestBody Panier panier) {
        return panierService.mettreAJourPanier(panier);
    }

    // Méthode pour supprimer un panier par son ID
    @DeleteMapping("/supprimer/{id}")
    public void supprimerPanier(@PathVariable Long id) {
        panierService.supprimerPanier(id);
    }
}
