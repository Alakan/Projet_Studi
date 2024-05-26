package com.example.Projet_Studi.services;

import com.example.Projet_Studi.model.TypeUtilisateur;
import com.example.Projet_Studi.model.Utilisateur;
import com.example.Projet_Studi.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public Utilisateur inscrireUtilisateur(Utilisateur utilisateur) {
        // Logique pour vérifier les données de l'utilisateur et l'enregistrer dans la base de données
        return utilisateurRepository.save(utilisateur);
    }

    public Utilisateur getUtilisateurById(Long utilisateurId) {
        return utilisateurRepository.findById(utilisateurId).orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
    }

    public boolean existeUtilisateurParEmail(String email) {
        return utilisateurRepository.existsByEmail(email);
    }

    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    public List<Utilisateur> rechercherUtilisateursParNomOuPrenom(String termeRecherche) {
        return utilisateurRepository.findByNomContainingIgnoreCaseOrPrenomContainingIgnoreCase(termeRecherche, termeRecherche);
    }

    public void supprimerUtilisateurById(Long utilisateurId) {
        utilisateurRepository.deleteById(utilisateurId);
    }

    public Utilisateur connecterUtilisateur(String email, String motDePasse) {
        // Logique pour vérifier les informations de connexion et renvoyer l'utilisateur s'il est validé
        return utilisateurRepository.findByEmailAndMotDePasse(email, motDePasse);
    }

    public void deconnecterUtilisateur() {
        // Logique pour déconnecter l'utilisateur, par exemple, effacer la session
        // Cette méthode dépendra de la manière dont vous gérez l'authentification dans votre application
        // Vous pouvez également utiliser des mécanismes comme Spring Security pour gérer l'authentification et la déconnexion
        // Ici, nous allons simplement vider la session en réinitialisant les informations d'authentification
        // SecurityContextHolder.clearContext();
    }

    public Utilisateur modifierInformationsUtilisateur(Long utilisateurId, String nouveauNom, String nouveauPrenom, String nouvelEmail, String nouveauMotDePasse) {
        Utilisateur utilisateur = utilisateurRepository.findById(utilisateurId).orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));

        // Vérifier quelles informations doivent être mises à jour et les mettre à jour sélectivement
        if (nouveauNom != null) {
            utilisateur.setNom(nouveauNom);
        }
        if (nouveauPrenom != null) {
            utilisateur.setPrenom(nouveauPrenom);
        }
        if (nouvelEmail != null) {
            utilisateur.setEmail(nouvelEmail);
        }
        if (nouveauMotDePasse != null) {
            utilisateur.setMotDePasse(nouveauMotDePasse);
        }

        // Enregistrer les modifications dans la base de données
        return utilisateurRepository.save(utilisateur);
    }

    // Méthode pour réinitialiser le mot de passe d'un utilisateur
    public void reinitialiserMotDePasse(Long utilisateurId, String nouveauMotDePasse) {
        Utilisateur utilisateur = utilisateurRepository.findById(utilisateurId)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
        utilisateur.setMotDePasse(nouveauMotDePasse);
        utilisateurRepository.save(utilisateur);
    }

    // Méthode pour vérifier l'existence d'un utilisateur par son ID
    public boolean existeUtilisateurParId(Long utilisateurId) {
        return utilisateurRepository.existsById(utilisateurId);
    }

    // Méthode pour modifier le type d'un utilisateur
    public void modifierTypeUtilisateur(Long utilisateurId, TypeUtilisateur nouveauType) {
        Utilisateur utilisateur = utilisateurRepository.findById(utilisateurId)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
        utilisateur.setTypeUtilisateur(nouveauType);
        utilisateurRepository.save(utilisateur);
    }


    // Méthode pour valider les données utilisateur lors de l'inscription ou de la modification du profil
    public boolean validerDonneesUtilisateur(Utilisateur utilisateur) {
        // Validation de l'email
        if (!isValidEmail(utilisateur.getEmail())) {
            return false;
        }

        // Validation de la force du mot de passe
        if (!isStrongPassword(utilisateur.getMotDePasse())) {
            return false;
        }

        // Toutes les validations ont réussi
        return true;
    }
    private boolean isValidEmail(String email) {
        // Expression régulière pour valider l'email
        String regex = "^(.+)@(.+)$";

        // Validation de l'email avec l'expression régulière
        return email.matches(regex);
    }

    private boolean isStrongPassword(String password) {
        // Vérifie si le mot de passe contient au moins 8 caractères et au moins une lettre majuscule, une lettre minuscule, un chiffre et un caractère spécial
        return password.length() >= 8 &&
                password.matches(".*[A-Z].*") &&
                password.matches(".*[a-z].*") &&
                password.matches(".*\\d.*") &&
                password.matches(".*[!@#$%^&*()].*");
    }


}
