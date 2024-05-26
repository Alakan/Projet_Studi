package com.example.Projet_Studi.controller;

import com.example.Projet_Studi.model.Commande;
import com.example.Projet_Studi.model.Paiement;
import com.example.Projet_Studi.services.PaiementService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/paiements")
@RequiredArgsConstructor
public class PaiementController {

    private final PaiementService paiementService;

    // Créer un nouveau paiement
    @SneakyThrows
    @PostMapping("/creer")
    public ResponseEntity<Paiement> creerPaiement(@RequestBody Commande commande, @RequestParam BigDecimal montant, @RequestParam String methodePaiement) {
        Paiement newPaiement = paiementService.creerPaiement(commande, montant, methodePaiement);
        return ResponseEntity.status(HttpStatus.CREATED).body(newPaiement);
    }

    // Récupérer un paiement par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Paiement> getPaiementById(@PathVariable Long id) {
        Paiement paiement = paiementService.getPaiementById(id);
        return ResponseEntity.ok(paiement);
    }

    // Récupérer tous les paiements
    @GetMapping("/tous")
    public ResponseEntity<List<Paiement>> getAllPaiements() {
        List<Paiement> paiements = paiementService.getAllPaiements();
        return ResponseEntity.ok(paiements);
    }

    @SneakyThrows
    @GetMapping("/rechercher/commande/{idCommande}")
    public ResponseEntity<List<Paiement>> rechercherPaiementsParCommande(@PathVariable Long idCommande) {
        Commande commande = new Commande();
        commande.setId(idCommande);
        List<Paiement> paiements = paiementService.rechercherPaiementsParCommande(commande);
        return ResponseEntity.ok(paiements);
    }

    @SneakyThrows
    @GetMapping("/rechercher/montant/{montant}")
    public ResponseEntity<List<Paiement>> rechercherPaiementsParMontant(@PathVariable BigDecimal montant) {
        List<Paiement> paiements = paiementService.rechercherPaiementsParMontant(montant);
        return ResponseEntity.ok(paiements);
    }

    @SneakyThrows
    @GetMapping("/rechercher/date-paiement/{datePaiement}")
    public ResponseEntity<List<Paiement>> rechercherPaiementsParDatePaiement(@PathVariable String datePaiement) {
        LocalDateTime date = LocalDateTime.parse(datePaiement);
        List<Paiement> paiements = paiementService.rechercherPaiementsParDatePaiement(date);
        return ResponseEntity.ok(paiements);
    }

    @SneakyThrows
    @GetMapping("/rechercher/methode-paiement/{methodePaiement}")
    public ResponseEntity<List<Paiement>> rechercherPaiementsParMethodePaiement(@PathVariable String methodePaiement) {
        List<Paiement> paiements = paiementService.rechercherPaiementsParMethodePaiement(methodePaiement);
        return ResponseEntity.ok(paiements);
    }

    @SneakyThrows
    @GetMapping("/rechercher/commande-date-paiement/{idCommande}/{datePaiement}")
    public ResponseEntity<List<Paiement>> rechercherPaiementsParCommandeEtDatePaiement(@PathVariable Long idCommande, @PathVariable String datePaiement) {
        LocalDateTime date = LocalDateTime.parse(datePaiement);
        Commande commande = new Commande();
        commande.setId(idCommande);
        List<Paiement> paiements = paiementService.rechercherPaiementsParCommandeEtDatePaiement(commande, date);
        return ResponseEntity.ok(paiements);
    }

    @SneakyThrows
    @PutMapping("/mettre-a-jour")
    public ResponseEntity<Paiement> mettreAJourPaiement(@RequestBody Paiement paiement) {
        Paiement updatedPaiement = paiementService.mettreAJourPaiement(paiement);
        return ResponseEntity.ok(updatedPaiement);
    }

    @SneakyThrows
    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<Void> supprimerPaiement(@PathVariable Long id) {
        paiementService.supprimerPaiement(id);
        return ResponseEntity.noContent().build();
    }
}
