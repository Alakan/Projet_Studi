package com.example.Projet_Studi.services;

import com.example.Projet_Studi.model.Panier;
import com.example.Projet_Studi.model.Utilisateur;
import com.example.Projet_Studi.repository.PanierRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PanierService {

    @Autowired
    private PanierRepository panierRepository;

    @Autowired
    private UtilisateurService utilisateurService; // Injectez le service Utilisateur pour la gestion des utilisateurs

    // Crée un nouveau panier et l'associe à un utilisateur.
    @Transactional
    public Panier creerPanier(Utilisateur utilisateur) {
        // Vérifier si l'utilisateur existe
        Utilisateur utilisateurExistant = utilisateurService.getUtilisateurById(utilisateur.getId());

        // Créer un nouveau panier
        Panier panier = new Panier();
        panier.setUtilisateur(utilisateurExistant);
        panier.setDateCreation(LocalDateTime.now());

        // Enregistrer le panier dans la base de données
        return panierRepository.save(panier);
    }

    // Récupère un panier par son ID.
    public Panier getPanierById(Long idPanier) {
        return panierRepository.findById(idPanier)
                .orElseThrow(() -> new EntityNotFoundException("Panier introuvable avec l'ID : " + idPanier));
    }

    // Récupère tous les paniers.
    public List<Panier> getAllPaniers() {
        return panierRepository.findAll();
    }

    // Recherche les paniers par utilisateur.
    public List<Panier> rechercherPaniersParUtilisateur(Utilisateur utilisateur) {
        return panierRepository.findByUtilisateur(utilisateur);
    }

    // Recherche les paniers par date de création.
    public List<Panier> rechercherPaniersParDateCreation(LocalDateTime dateCreation) {
        return panierRepository.findByDateCreation(dateCreation);
    }

    // Met à jour un panier existant.
    public Panier mettreAJourPanier(Panier panier) {
        // Vérifier si le panier existe
        Panier panierExistant = panierRepository.findById(panier.getId())
                .orElseThrow(() -> new EntityNotFoundException("Panier introuvable avec l'ID : " + panier.getId()));

        // Mettre à jour les champs du panier avec les nouvelles valeurs
        panierExistant.setUtilisateur(panier.getUtilisateur());
        panierExistant.setDateCreation(panier.getDateCreation());

        // Enregistrer le panier mis à jour dans la base de données
        return panierRepository.save(panierExistant);
    }

    // Supprime un panier par son ID.
    public void supprimerPanier(Long idPanier) {
        panierRepository.deleteById(idPanier);
    }
}
