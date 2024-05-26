package com.example.Projet_Studi.controller;

import com.example.Projet_Studi.model.Panier;
import com.example.Projet_Studi.model.Utilisateur;
import com.example.Projet_Studi.services.PanierService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/paniers")
public class PanierController {

    @Autowired
    private PanierService panierService;

    // Méthode pour créer un nouveau panier
    @SneakyThrows
    @PostMapping("/creer")
    public ResponseEntity<Panier> creerPanier(@RequestBody Utilisateur utilisateur) {
        Panier newPanier = panierService.creerPanier(utilisateur);
        return new ResponseEntity<>(newPanier, HttpStatus.CREATED);
    }

    // Méthode pour récupérer un panier par son ID
    @SneakyThrows
    @GetMapping("/{id}")
    public ResponseEntity<Panier> getPanierById(@PathVariable Long id) {
        Panier panier = panierService.getPanierById(id);
        return new ResponseEntity<>(panier, HttpStatus.OK);
    }

    // Méthode pour récupérer tous les paniers
    @SneakyThrows
    @GetMapping("/tous")
    public ResponseEntity<List<Panier>> getAllPaniers() {
        List<Panier> paniers = panierService.getAllPaniers();
        return new ResponseEntity<>(paniers, HttpStatus.OK);
    }

    // Méthode pour rechercher des paniers par utilisateur
    @SneakyThrows
    @GetMapping("/utilisateur/{idUtilisateur}")
    public ResponseEntity<List<Panier>> rechercherPaniersParUtilisateur(@PathVariable Long idUtilisateur) {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(idUtilisateur);
        List<Panier> paniers = panierService.rechercherPaniersParUtilisateur(utilisateur);
        return new ResponseEntity<>(paniers, HttpStatus.OK);
    }

    // Méthode pour rechercher des paniers par date de création
    @SneakyThrows
    @GetMapping("/date-creation/{dateCreation}")
    public ResponseEntity<List<Panier>> rechercherPaniersParDateCreation(@PathVariable String dateCreation) {
        LocalDateTime date = LocalDateTime.parse(dateCreation);
        List<Panier> paniers = panierService.rechercherPaniersParDateCreation(date);
        return new ResponseEntity<>(paniers, HttpStatus.OK);
    }

    // Méthode pour mettre à jour un panier
    @SneakyThrows
    @PutMapping("/mettre-a-jour")
    public ResponseEntity<Panier> mettreAJourPanier(@RequestBody Panier panier) {
        Panier updatedPanier = panierService.mettreAJourPanier(panier);
        return new ResponseEntity<>(updatedPanier, HttpStatus.OK);
    }

    // Méthode pour supprimer un panier par son ID
    @SneakyThrows
    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<HttpStatus> supprimerPanier(@PathVariable Long id) {
        panierService.supprimerPanier(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
