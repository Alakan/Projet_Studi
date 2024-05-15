package com.example.Projet_Studi.services;

import com.example.Projet_Studi.model.Commande;
import com.example.Projet_Studi.model.Utilisateur;
import com.example.Projet_Studi.repository.CommandeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommandeService {

    @Autowired
    private CommandeRepository commandeRepository;

    // Crée une nouvelle commande et l'enregistre dans la base de données.
    public Commande creerCommande(Commande commande) {
        // Vérifier si l'utilisateur existe avant de créer la commande
        Utilisateur utilisateur = commande.getUtilisateur();
        if (utilisateur == null || utilisateur.getId() == null) {
            throw new EntityNotFoundException("Utilisateur introuvable pour la commande");
        }

        // Générer la date de commande actuelle
        commande.setDateCommande(LocalDateTime.now());

        return commandeRepository.save(commande);
    }

    // Récupère une commande par son ID.
    public Commande getCommandeById(Long idCommande) {
        return commandeRepository.findById(idCommande)
                .orElseThrow(() -> new EntityNotFoundException("Commande introuvable avec l'ID : " + idCommande));
    }

    // Récupère toutes les commandes d'un utilisateur.
    public List<Commande> getCommandesUtilisateur(Utilisateur utilisateur) {
        return commandeRepository.findByUtilisateur(utilisateur);
    }

    // Récupère toutes les commandes passées à une date spécifique.
    public List<Commande> getCommandesParDate(LocalDateTime dateCommande) {
        return commandeRepository.findByDateCommande(dateCommande);
    }

    // Récupère toutes les commandes d'un utilisateur à une date spécifique.
    public List<Commande> getCommandesUtilisateurParDate(Utilisateur utilisateur, LocalDateTime dateCommande) {
        return commandeRepository.findByUtilisateurAndDateCommande(utilisateur, dateCommande);
    }

    // Met à jour une commande existante.
    public Commande mettreAJourCommande(Commande commande) {
        // Vérifier si la commande existe avant la mise à jour
        Commande commandeExistante = commandeRepository.findById(commande.getId())
                .orElseThrow(() -> new EntityNotFoundException("Commande introuvable avec l'ID : " + commande.getId()));

        // Mettre à jour les champs de la commande avec les nouvelles valeurs
        commandeExistante.setQuantite(commande.getQuantite());

        return commandeRepository.save(commandeExistante);
    }

    // Supprime une commande par son ID.
    public void supprimerCommande(Long idCommande) {
        commandeRepository.deleteById(idCommande);
    }
}
