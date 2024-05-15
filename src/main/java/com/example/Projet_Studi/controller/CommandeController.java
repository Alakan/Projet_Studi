package com.example.Projet_Studi.controller;

import com.example.Projet_Studi.model.Commande;
import com.example.Projet_Studi.model.Utilisateur;
import com.example.Projet_Studi.services.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/commandes")
public class CommandeController {

    @Autowired
    private CommandeService commandeService;

    // Méthode pour créer une nouvelle commande
    @PostMapping("/creer")
    public Commande creerCommande(@RequestBody Commande commande) {
        return commandeService.creerCommande(commande);
    }

    // Méthode pour récupérer une commande par son ID
    @GetMapping("/{id}")
    public Commande getCommandeById(@PathVariable Long id) {
        return commandeService.getCommandeById(id);
    }

    // Méthode pour récupérer toutes les commandes d'un utilisateur
    @GetMapping("/utilisateur/{idUtilisateur}")
    public List<Commande> getCommandesUtilisateur(@PathVariable Long idUtilisateur) {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(idUtilisateur);
        return commandeService.getCommandesUtilisateur(utilisateur);
    }

    // Méthode pour récupérer toutes les commandes passées à une date spécifique
    @GetMapping("/date/{dateCommande}")
    public List<Commande> getCommandesParDate(@PathVariable LocalDateTime dateCommande) {
        return commandeService.getCommandesParDate(dateCommande);
    }

    // Méthode pour récupérer toutes les commandes d'un utilisateur à une date spécifique
    @GetMapping("/utilisateur/{idUtilisateur}/date/{dateCommande}")
    public List<Commande> getCommandesUtilisateurParDate(@PathVariable Long idUtilisateur, @PathVariable LocalDateTime dateCommande) {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(idUtilisateur);
        return commandeService.getCommandesUtilisateurParDate(utilisateur, dateCommande);
    }

    // Méthode pour mettre à jour une commande existante
    @PutMapping("/mettre-a-jour")
    public Commande mettreAJourCommande(@RequestBody Commande commande) {
        return commandeService.mettreAJourCommande(commande);
    }

    // Méthode pour supprimer une commande par son ID
    @DeleteMapping("/supprimer/{id}")
    public void supprimerCommande(@PathVariable Long id) {
        commandeService.supprimerCommande(id);
    }
}
