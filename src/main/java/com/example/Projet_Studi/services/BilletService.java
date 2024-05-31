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
    private CommandeService commandeService;

    @Autowired
    private UtilisateurService utilisateurService;

    @Transactional
    public Billet creerBillet(Commande commande, Utilisateur utilisateur) {
        String cleBillet = UUID.randomUUID().toString();
        String qrcode = "Exemple de QR code";

        Billet billet = new Billet();
        billet.setCommande(commande);
        billet.setUtilisateur(utilisateur);
        billet.setCleBillet(cleBillet);
        billet.setQrcode(qrcode);

        return billetRepository.save(billet);
    }

    public Billet getBilletById(Long idBillet) {
        return billetRepository.findById(idBillet)
                .orElseThrow(() -> new EntityNotFoundException("Billet introuvable avec l'ID : " + idBillet));
    }

    public List<Billet> getAllBillets() {
        return billetRepository.findAll();
    }

    public List<Billet> rechercherBilletsParCommande(Commande commande) {
        return billetRepository.findByCommandeId(commande.getId());
    }

    public List<Billet> rechercherBilletsParUtilisateur(Utilisateur utilisateur) {
        return billetRepository.findByUtilisateurId(utilisateur.getId());
    }

    public Billet mettreAJourBillet(Billet billet) {
        Billet billetExistant = billetRepository.findById(billet.getId())
                .orElseThrow(() -> new EntityNotFoundException("Billet introuvable avec l'ID : " + billet.getId()));

        billetExistant.setCommande(billet.getCommande());
        billetExistant.setUtilisateur(billet.getUtilisateur());
        billetExistant.setCleBillet(billet.getCleBillet());
        billetExistant.setQrcode(billet.getQrcode());

        return billetRepository.save(billetExistant);
    }

    public void supprimerBillet(Long idBillet) {
        billetRepository.deleteById(idBillet);
    }
}
