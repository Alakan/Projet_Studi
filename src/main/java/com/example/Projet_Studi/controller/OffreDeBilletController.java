package com.example.Projet_Studi.controller;
import com.example.Projet_Studi.model.OffreDeBillet;
import com.example.Projet_Studi.model.TypeOffre;
import com.example.Projet_Studi.services.OffreDeBilletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/offres-de-billet")
public class OffreDeBilletController {

    @Autowired
    private OffreDeBilletService offreDeBilletService;

    // Méthode pour créer une nouvelle offre de billet
    @PostMapping("/creer")
    public OffreDeBillet creerOffreDeBillet(@RequestBody OffreDeBillet offreDeBillet) {
        return offreDeBilletService.creerOffreDeBillet(offreDeBillet);
    }

    // Méthode pour récupérer une offre de billet par son ID
    @GetMapping("/{id}")
    public OffreDeBillet getOffreDeBilletById(@PathVariable Long id) {
        return offreDeBilletService.getOffreDeBilletById(id);
    }

    // Méthode pour récupérer toutes les offres de billet
    @GetMapping("/toutes")
    public List<OffreDeBillet> getAllOffresDeBillet() {
        return offreDeBilletService.getAllOffresDeBillet();
    }

    // Méthode pour rechercher des offres de billet par type
    @GetMapping("/rechercher/type/{type}")
    public List<OffreDeBillet> rechercherOffresParType(@PathVariable TypeOffre type) {
        return offreDeBilletService.rechercherOffresParType(type);
    }

    // Méthode pour rechercher des offres de billet par prix inférieur à un certain montant
    @GetMapping("/rechercher/prix/inferieur/{prix}")
    public List<OffreDeBillet> rechercherOffresParPrixInferieur(@PathVariable BigDecimal prix) {
        return offreDeBilletService.rechercherOffresParPrixInferieur(prix);
    }

    // Méthode pour rechercher des offres de billet par prix supérieur à un certain montant
    @GetMapping("/rechercher/prix/superieur/{prix}")
    public List<OffreDeBillet> rechercherOffresParPrixSuperieur(@PathVariable BigDecimal prix) {
        return offreDeBilletService.rechercherOffresParPrixSuperieur(prix);
    }

    // Méthode pour rechercher des offres de billet par prix compris entre deux valeurs
    @GetMapping("/rechercher/prix/intervalle/{prixMin}/{prixMax}")
    public List<OffreDeBillet> rechercherOffresParPrixIntervalle(@PathVariable BigDecimal prixMin, @PathVariable BigDecimal prixMax) {
        return offreDeBilletService.rechercherOffresParPrixIntervalle(prixMin, prixMax);
    }

    // Méthode pour mettre à jour une offre de billet existante
    @PutMapping("/mettre-a-jour")
    public OffreDeBillet mettreAJourOffreDeBillet(@RequestBody OffreDeBillet offreDeBillet) {
        return offreDeBilletService.mettreAJourOffreDeBillet(offreDeBillet);
    }

    // Méthode pour supprimer une offre de billet par son ID
    @DeleteMapping("/supprimer/{id}")
    public void supprimerOffreDeBillet(@PathVariable Long id) {
        offreDeBilletService.supprimerOffreDeBillet(id);
    }
}
