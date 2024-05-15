package com.example.Projet_Studi.services;

import com.example.Projet_Studi.model.OffreDeBillet;
import com.example.Projet_Studi.model.TypeOffre;
import com.example.Projet_Studi.repository.OffreDeBilletRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OffreDeBilletService {

    @Autowired
    private OffreDeBilletRepository offreDeBilletRepository;

    // Crée une nouvelle offre de billet et l'enregistre dans la base de données.
    public OffreDeBillet creerOffreDeBillet(OffreDeBillet offreDeBillet) {
        return offreDeBilletRepository.save(offreDeBillet);
    }

    // Récupère une offre de billet par son ID.
    public OffreDeBillet getOffreDeBilletById(Long idOffre) {
        return offreDeBilletRepository.findById(idOffre)
                .orElseThrow(() -> new EntityNotFoundException("Offre de billet introuvable avec l'ID : " + idOffre));
    }

    // Récupère toutes les offres de billet.
    public List<OffreDeBillet> getAllOffresDeBillet() {
        return offreDeBilletRepository.findAll();
    }

    // Recherche des offres de billet par type.
    public List<OffreDeBillet> rechercherOffresParType(TypeOffre typeOffre) {
        return offreDeBilletRepository.findByTypeOffre(typeOffre);
    }

    // Recherche des offres de billet par prix inférieur à un certain montant.
    public List<OffreDeBillet> rechercherOffresParPrixInferieur(BigDecimal prixMax) {
        return offreDeBilletRepository.findByPrixLessThan(prixMax);
    }

    // Recherche des offres de billet par prix supérieur à un certain montant.
    public List<OffreDeBillet> rechercherOffresParPrixSuperieur(BigDecimal prixMin) {
        return offreDeBilletRepository.findByPrixGreaterThan(prixMin);
    }

    // Recherche des offres de billet par prix compris entre deux valeurs.
    public List<OffreDeBillet> rechercherOffresParPrixIntervalle(BigDecimal prixMin, BigDecimal prixMax) {
        return offreDeBilletRepository.findByPrixBetween(prixMin, prixMax);
    }

    // Met à jour une offre de billet existante.
    public OffreDeBillet mettreAJourOffreDeBillet(OffreDeBillet offreDeBillet) {
        // Vérifier si l'offre de billet existe avant la mise à jour
        OffreDeBillet offreDeBilletExistante = offreDeBilletRepository.findById(offreDeBillet.getId())
                .orElseThrow(() -> new EntityNotFoundException("Offre de billet introuvable avec l'ID : " + offreDeBillet.getId()));

        // Mettre à jour les champs de l'offre de billet avec les nouvelles valeurs
        offreDeBilletExistante.setTypeOffre(offreDeBillet.getTypeOffre());
        offreDeBilletExistante.setPrix(offreDeBillet.getPrix());
        offreDeBilletExistante.setDescription(offreDeBillet.getDescription());

        return offreDeBilletRepository.save(offreDeBilletExistante);
    }

    // Supprime une offre de billet par son ID.
    public void supprimerOffreDeBillet(Long idOffre) {
        offreDeBilletRepository.deleteById(idOffre);
    }
}
