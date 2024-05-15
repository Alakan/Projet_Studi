package com.example.Projet_Studi.services;

import com.example.Projet_Studi.model.Billet;
import com.example.Projet_Studi.model.Commande;
import com.example.Projet_Studi.model.Utilisateur;
import com.example.Projet_Studi.repository.BilletRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class BilletService {

    @Autowired
    private BilletRepository billetRepository;

    @Autowired
    private CommandeService commandeService; // Injectez le service Commande pour la gestion des commandes

    @Autowired
    private UtilisateurService utilisateurService; // Injectez le service Utilisateur pour la gestion des utilisateurs

    // Crée un nouveau billet et l'associe à une commande et un utilisateur.
    @Transactional
    public Billet creerBillet(Commande commande, Utilisateur utilisateur) {
        // Vérifier si la commande et l'utilisateur existent
        Commande commandeExistante = commandeService.getCommandeById(commande.getId());
        Utilisateur utilisateurExistant = utilisateurService.getUtilisateurById(utilisateur.getId());

        // Générer une clé unique pour le billet
        String cleBillet = UUID.randomUUID().toString();

        // Générer un QR code pour le billet (vous pouvez utiliser une bibliothèque de génération de QR code)
        String qrcode = "Exemple de QR code";

        // Créer un nouveau billet
        Billet billet = new Billet();
        billet.setCommande(commandeExistante);
        billet.setUtilisateur(utilisateurExistant);
        billet.setCleBillet(cleBillet);
        billet.setQrcode(qrcode);

        // Enregistrer le billet dans la base de données
        return billetRepository.save(billet);
    }

    // Récupère un billet par son ID.
    public Billet getBilletById(Long idBillet) {
        return billetRepository.findById(idBillet)
                .orElseThrow(() -> new EntityNotFoundException("Billet introuvable avec l'ID : " + idBillet));
    }

    // Récupère tous les billets.
    public List<Billet> getAllBillets() {
        return billetRepository.findAll();
    }

    // Recherche les billets associés à une commande.
    public List<Billet> rechercherBilletsParCommande(Commande commande) {
        return billetRepository.findByCommandeId(commande.getId());
    }

    // Recherche les billets associés à un utilisateur.
    public List<Billet> rechercherBilletsParUtilisateur(Utilisateur utilisateur) {
        return billetRepository.findByUtilisateurId(utilisateur.getId());
    }

    // Met à jour un billet existant.
    public Billet mettreAJourBillet(Billet billet) {
        // Vérifier si le billet existe
        Billet billetExistant = billetRepository.findById(billet.getId())
                .orElseThrow(() -> new EntityNotFoundException("Billet introuvable avec l'ID : " + billet.getId()));

        // Mettre à jour les champs du billet avec les nouvelles valeurs
        billetExistant.setCommande(billet.getCommande());
        billetExistant.setUtilisateur(billet.getUtilisateur());
        billetExistant.setCleBillet(billet.getCleBillet());
        billetExistant.setQrcode(billet.getQrcode());

        // Enregistrer le billet mis à jour dans la base de données
        return billetRepository.save(billetExistant);
    }

    // Supprime un billet par son ID.
    public void supprimerBillet(Long idBillet) {
        billetRepository.deleteById(idBillet);
    }
}
