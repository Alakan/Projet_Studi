package com.example.Projet_Studi.controller;

import com.example.Projet_Studi.model.Billet;
import com.example.Projet_Studi.model.Commande;
import com.example.Projet_Studi.model.Utilisateur;
import com.example.Projet_Studi.services.BilletService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/billets")
public class BilletController {

    @Autowired
    private BilletService billetService;

    @SneakyThrows
    @PostMapping("/creer")
    public ResponseEntity<Billet> creerBillet(@RequestBody Commande commande, @RequestBody Utilisateur utilisateur) {
        Billet newBillet = billetService.creerBillet(commande, utilisateur);
        return ResponseEntity.status(HttpStatus.CREATED).body(newBillet);
    }

    @SneakyThrows
    @GetMapping("/{id}")
    public ResponseEntity<Billet> getBilletById(@PathVariable Long id) {
        Billet billet = billetService.getBilletById(id);
        return ResponseEntity.of(Optional.ofNullable(billet));
    }

    @SneakyThrows
    @GetMapping("/tous")
    public ResponseEntity<List<Billet>> getAllBillets() {
        List<Billet> billets = billetService.getAllBillets();
        return ResponseEntity.ok(billets);
    }

    @SneakyThrows
    @GetMapping("/rechercher/commande/{idCommande}")
    public ResponseEntity<List<Billet>> rechercherBilletsParCommande(@PathVariable Long idCommande) {
        Commande commande = new Commande();
        commande.setId(idCommande);
        List<Billet> billets = billetService.rechercherBilletsParCommande(commande);
        return ResponseEntity.ok(billets);
    }

    @SneakyThrows
    @GetMapping("/rechercher/utilisateur/{idUtilisateur}")
    public ResponseEntity<List<Billet>> rechercherBilletsParUtilisateur(@PathVariable Long idUtilisateur) {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(idUtilisateur);
        List<Billet> billets = billetService.rechercherBilletsParUtilisateur(utilisateur);
        return ResponseEntity.ok(billets);
    }

    @SneakyThrows
    @PutMapping("/mettre-a-jour")
    public ResponseEntity<Billet> mettreAJourBillet(@RequestBody Billet billet) {
        Billet updatedBillet = billetService.mettreAJourBillet(billet);
        return ResponseEntity.ok(updatedBillet);
    }

    @SneakyThrows
    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<Void> supprimerBillet(@PathVariable Long id) {
        billetService.supprimerBillet(id);
        return ResponseEntity.noContent().build();
    }
}
