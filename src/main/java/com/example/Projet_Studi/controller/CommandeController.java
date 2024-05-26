package com.example.Projet_Studi.controller;

import com.example.Projet_Studi.model.Commande;
import com.example.Projet_Studi.model.Utilisateur;
import com.example.Projet_Studi.services.CommandeService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/commandes")
public class CommandeController {

    @Autowired
    private CommandeService commandeService;

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    @SneakyThrows
    @PostMapping("/creer")
    public ResponseEntity<Commande> creerCommande(@RequestBody Commande commande) {
        Commande newCommande = commandeService.creerCommande(commande);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCommande);
    }

    @SneakyThrows
    @GetMapping("/{id}")
    public ResponseEntity<Commande> getCommandeById(@PathVariable Long id) {
        Commande commande = commandeService.getCommandeById(id);
        return ResponseEntity.of(Optional.ofNullable(commande));
    }

    @SneakyThrows
    @GetMapping("/utilisateur/{idUtilisateur}")
    public ResponseEntity<List<Commande>> getCommandesUtilisateur(@PathVariable Long idUtilisateur) {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(idUtilisateur);
        List<Commande> commandes = commandeService.getCommandesUtilisateur(utilisateur);
        return ResponseEntity.ok(commandes);
    }

    @SneakyThrows
    @GetMapping("/date/{dateCommande}")
    public ResponseEntity<List<Commande>> getCommandesParDate(@PathVariable String dateCommande) {
        LocalDateTime date = LocalDateTime.parse(dateCommande, formatter);
        List<Commande> commandes = commandeService.getCommandesParDate(date);
        return ResponseEntity.ok(commandes);
    }

    @SneakyThrows
    @GetMapping("/utilisateur/{idUtilisateur}/date/{dateCommande}")
    public ResponseEntity<List<Commande>> getCommandesUtilisateurParDate(@PathVariable Long idUtilisateur, @PathVariable String dateCommande) {
        LocalDateTime date = LocalDateTime.parse(dateCommande, formatter);
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(idUtilisateur);
        List<Commande> commandes = commandeService.getCommandesUtilisateurParDate(utilisateur, date);
        return ResponseEntity.ok(commandes);
    }

    @SneakyThrows
    @PutMapping("/mettre-a-jour")
    public ResponseEntity<Commande> mettreAJourCommande(@RequestBody Commande commande) {
        Commande updatedCommande = commandeService.mettreAJourCommande(commande);
        return ResponseEntity.ok(updatedCommande);
    }

    @SneakyThrows
    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<Void> supprimerCommande(@PathVariable Long id) {
        commandeService.supprimerCommande(id);
        return ResponseEntity.noContent().build();
    }
}
