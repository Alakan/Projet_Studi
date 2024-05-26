package com.example.Projet_Studi.controller;

import com.example.Projet_Studi.model.OffreDeBillet;
import com.example.Projet_Studi.model.TypeOffre;
import com.example.Projet_Studi.services.OffreDeBilletService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/offres-de-billet")
public class OffreDeBilletController {

    @Autowired
    private OffreDeBilletService offreDeBilletService;

    @SneakyThrows
    @PostMapping("/creer")
    public ResponseEntity<OffreDeBillet> creerOffreDeBillet(@RequestBody OffreDeBillet offreDeBillet) {
        OffreDeBillet newOffreDeBillet = offreDeBilletService.creerOffreDeBillet(offreDeBillet);
        return ResponseEntity.status(HttpStatus.CREATED).body(newOffreDeBillet);
    }

    @SneakyThrows
    @GetMapping("/{id}")
    public ResponseEntity<OffreDeBillet> getOffreDeBilletById(@PathVariable Long id) {
        OffreDeBillet offreDeBillet = offreDeBilletService.getOffreDeBilletById(id);
        return ResponseEntity.of(Optional.ofNullable(offreDeBillet));
    }

    @SneakyThrows
    @GetMapping("/toutes")
    public ResponseEntity<List<OffreDeBillet>> getAllOffresDeBillet() {
        List<OffreDeBillet> offresDeBillet = offreDeBilletService.getAllOffresDeBillet();
        return ResponseEntity.ok(offresDeBillet);
    }

    @SneakyThrows
    @GetMapping("/rechercher/type/{type}")
    public ResponseEntity<List<OffreDeBillet>> rechercherOffresParType(@PathVariable TypeOffre type) {
        List<OffreDeBillet> offresDeBillet = offreDeBilletService.rechercherOffresParType(type);
        return ResponseEntity.ok(offresDeBillet);
    }

    @SneakyThrows
    @GetMapping("/rechercher/prix/inferieur/{prix}")
    public ResponseEntity<List<OffreDeBillet>> rechercherOffresParPrixInferieur(@PathVariable BigDecimal prix) {
        List<OffreDeBillet> offresDeBillet = offreDeBilletService.rechercherOffresParPrixInferieur(prix);
        return ResponseEntity.ok(offresDeBillet);
    }

    @SneakyThrows
    @GetMapping("/rechercher/prix/superieur/{prix}")
    public ResponseEntity<List<OffreDeBillet>> rechercherOffresParPrixSuperieur(@PathVariable BigDecimal prix) {
        List<OffreDeBillet> offresDeBillet = offreDeBilletService.rechercherOffresParPrixSuperieur(prix);
        return ResponseEntity.ok(offresDeBillet);
    }

    @SneakyThrows
    @GetMapping("/rechercher/prix/intervalle/{prixMin}/{prixMax}")
    public ResponseEntity<List<OffreDeBillet>> rechercherOffresParPrixIntervalle(@PathVariable BigDecimal prixMin, @PathVariable BigDecimal prixMax) {
        List<OffreDeBillet> offresDeBillet = offreDeBilletService.rechercherOffresParPrixIntervalle(prixMin, prixMax);
        return ResponseEntity.ok(offresDeBillet);
    }

    @SneakyThrows
    @PutMapping("/mettre-a-jour")
    public ResponseEntity<OffreDeBillet> mettreAJourOffreDeBillet(@RequestBody OffreDeBillet offreDeBillet) {
        OffreDeBillet updatedOffreDeBillet = offreDeBilletService.mettreAJourOffreDeBillet(offreDeBillet);
        return ResponseEntity.ok(updatedOffreDeBillet);
    }

    @SneakyThrows
    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<Void> supprimerOffreDeBillet(@PathVariable Long id) {
        offreDeBilletService.supprimerOffreDeBillet(id);
        return ResponseEntity.noContent().build();
    }
}
