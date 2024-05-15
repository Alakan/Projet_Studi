package com.example.Projet_Studi.controller;

import com.example.Projet_Studi.model.TypeUtilisateur;
import com.example.Projet_Studi.model.Utilisateur;
import com.example.Projet_Studi.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    // Méthode pour inscrire un nouvel utilisateur
    @PostMapping("/inscrire")
    public Utilisateur inscrireUtilisateur(@RequestBody Utilisateur utilisateur) {
        return utilisateurService.inscrireUtilisateur(utilisateur);
    }

    // Méthode pour récupérer un utilisateur par son ID
    @GetMapping("/{id}")
    public Utilisateur getUtilisateurById(@PathVariable Long id) {
        return utilisateurService.getUtilisateurById(id);
    }

    // Méthode pour vérifier l'existence d'un utilisateur par son email
    @GetMapping("/existe/{email}")
    public boolean existeUtilisateurParEmail(@PathVariable String email) {
        return utilisateurService.existeUtilisateurParEmail(email);
    }

    // Méthode pour récupérer tous les utilisateurs
    @GetMapping("/tous")
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurService.getAllUtilisateurs();
    }

    // Méthode pour rechercher des utilisateurs par nom ou prénom
    @GetMapping("/rechercher")
    public List<Utilisateur> rechercherUtilisateurs(@RequestParam String termeRecherche) {
        return utilisateurService.rechercherUtilisateursParNomOuPrenom(termeRecherche);
    }

    // Méthode pour supprimer un utilisateur par son ID
    @DeleteMapping("/{id}")
    public void supprimerUtilisateurById(@PathVariable Long id) {
        utilisateurService.supprimerUtilisateurById(id);
    }

    // Méthode pour connecter un utilisateur
    @PostMapping("/connexion")
    public Utilisateur connecterUtilisateur(@RequestParam String email, @RequestParam String motDePasse) {
        return utilisateurService.connecterUtilisateur(email, motDePasse);
    }

    // Méthode pour déconnecter un utilisateur
    @PostMapping("/deconnexion")
    public void deconnecterUtilisateur() {
        utilisateurService.deconnecterUtilisateur();
    }

    // Méthode pour modifier les informations d'un utilisateur
    @PutMapping("/{id}")
    public Utilisateur modifierInformationsUtilisateur(@PathVariable Long id,
                                                       @RequestParam(required = false) String nouveauNom,
                                                       @RequestParam(required = false) String nouveauPrenom,
                                                       @RequestParam(required = false) String nouvelEmail,
                                                       @RequestParam(required = false) String nouveauMotDePasse) {
        return utilisateurService.modifierInformationsUtilisateur(id, nouveauNom, nouveauPrenom, nouvelEmail, nouveauMotDePasse);
    }

    // Méthode pour réinitialiser le mot de passe d'un utilisateur
    @PostMapping("/reinitialiser-mot-de-passe")
    public void reinitialiserMotDePasse(@RequestParam Long utilisateurId, @RequestParam String nouveauMotDePasse) {
        utilisateurService.reinitialiserMotDePasse(utilisateurId, nouveauMotDePasse);
    }

    // Méthode pour vérifier l'existence d'un utilisateur par son ID
    @GetMapping("/existe/{id}")
    public boolean existeUtilisateurParId(@PathVariable Long id) {
        return utilisateurService.existeUtilisateurParId(id);
    }

    // Méthode pour modifier le type d'un utilisateur
    @PutMapping("/{id}/modifier-type")
    public void modifierTypeUtilisateur(@PathVariable Long id, @RequestParam TypeUtilisateur nouveauType) {
        utilisateurService.modifierTypeUtilisateur(id, nouveauType);
    }
}
