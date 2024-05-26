package com.example.Projet_Studi.controller;

import com.example.Projet_Studi.model.Utilisateur;
import com.example.Projet_Studi.services.UtilisateurService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @SneakyThrows
    @PostMapping("/inscrire")
    public ResponseEntity<Utilisateur> inscrireUtilisateur(@RequestBody Utilisateur utilisateur) {
        Utilisateur newUtilisateur = utilisateurService.inscrireUtilisateur(utilisateur);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUtilisateur);
    }

    @SneakyThrows
    @GetMapping("/{id}")
    public ResponseEntity<Utilisateur> getUtilisateurById(@PathVariable Long id) {
        Utilisateur utilisateur = utilisateurService.getUtilisateurById(id);
        return ResponseEntity.of(Optional.ofNullable(utilisateur));
    }

    @SneakyThrows
    @GetMapping("/existe/{email}")
    public ResponseEntity<Boolean> existeUtilisateurParEmail(@PathVariable String email) {
        boolean existe = utilisateurService.existeUtilisateurParEmail(email);
        return ResponseEntity.ok(existe);
    }

    @SneakyThrows
    @GetMapping("/all")
    public ResponseEntity<List<Utilisateur>> getAllUtilisateurs() {
        List<Utilisateur> utilisateurs = utilisateurService.getAllUtilisateurs();
        return ResponseEntity.ok(utilisateurs);
    }

    @SneakyThrows
    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<Void> supprimerUtilisateur(@PathVariable Long id) {
        utilisateurService.supprimerUtilisateurById(id);
        return ResponseEntity.noContent().build();
    }
}
