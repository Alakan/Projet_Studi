package com.example.Projet_Studi.services;

import com.example.Projet_Studi.model.TypeUtilisateur;
import com.example.Projet_Studi.model.Utilisateur;
import com.example.Projet_Studi.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    public Utilisateur inscrireUtilisateur(Utilisateur utilisateur) {
        if (!validerDonneesUtilisateur(utilisateur)) {
            throw new IllegalArgumentException("Les données utilisateur sont invalides");
        }
        utilisateur.setDateCreation(LocalDateTime.now());
        return utilisateurRepository.save(utilisateur);
    }

    public Utilisateur getUtilisateurById(Long utilisateurId) {
        return utilisateurRepository.findById(utilisateurId)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
    }

    public boolean existeUtilisateurParEmail(String email) {
        return utilisateurRepository.existsByEmail(email);
    }

    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    public void supprimerUtilisateurById(Long utilisateurId) {
        utilisateurRepository.deleteById(utilisateurId);
    }

    public Utilisateur modifierInformationsUtilisateur(Long utilisateurId, String nouveauNom, String nouveauPrenom, String nouvelEmail, String nouveauMotDePasse) {
        Utilisateur utilisateur = utilisateurRepository.findById(utilisateurId)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));

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

        return utilisateurRepository.save(utilisateur);
    }
/*
    public Utilisateur connecterUtilisateur(String email, String motDePasse) {
        Utilisateur utilisateur = utilisateurRepository.findByEmail(email);
        if (utilisateur != null && utilisateur.getMotDePasse().equals(motDePasse)) {
            return utilisateur;
        } else {
            return null;
        }
    }
*/
public Utilisateur connecterUtilisateur(String email, String motDePasse) {
    // Rechercher l'utilisateur dans la base de données par son mail
    Utilisateur utilisateur = utilisateurRepository.findByEmail((email));
    //Vérifier si l'utilisateur existe et si le mot de passe est correct
    if (utilisateur != null && utilisateur.getMotDePasse().equals(motDePasse)) {
        // Créer une instance d'Authentification pour l'utilisateur authentifié
        Authentication authentication = new UsernamePasswordAuthenticationToken(email, motDePasse);
        // Définir l'authentification dans le contexte de sécurité
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Retourner l'utilisateur connecté
        return utilisateur;
    } else {
        // Retourner null si l'authentification a échoué
        return null;
    }
}

    /*public void deconnecterUtilisateur() {
        SecurityContextHolder.clearContext();
    }*/

    public void deconnecterUtilisateur() {
        // Récupérer l'authentification actuelle
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null) {
            // Effacer l'authentification actuelle
            SecurityContextHolder.clearContext();
        }
    }



    public void reinitialiserMotDePasse(Long utilisateurId, String nouveauMotDePasse) {
        Utilisateur utilisateur = utilisateurRepository.findById(utilisateurId)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));

        if (isStrongPassword(nouveauMotDePasse)) {
            utilisateur.setMotDePasse(nouveauMotDePasse);
            utilisateurRepository.save(utilisateur);
        } else {
            throw new IllegalArgumentException("Le nouveau mot de passe ne satisfait pas les exigences minimales.");
        }
    }

    public boolean validerDonneesUtilisateur(Utilisateur utilisateur) {
        return isValidEmail(utilisateur.getEmail()) && isStrongPassword(utilisateur.getMotDePasse());
    }

    boolean isValidEmail(String email) {
        String regex = "^(.+)@(.+)$";
        return email.matches(regex);
    }

    boolean isStrongPassword(String password) {
        return password.length() >= 8 &&
                password.matches(".*[A-Z].*") &&
                password.matches(".*[a-z].*") &&
                password.matches(".*\\d.*") &&
                password.matches(".*[!@#$%^&*()].*");
    }
}
