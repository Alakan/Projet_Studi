package com.example.Projet_Studi.repository;

import com.example.Projet_Studi.model.Panier;
import com.example.Projet_Studi.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PanierRepository extends JpaRepository<Panier, Long> {

    // Recherche des paniers par utilisateur
    List<Panier> findByUtilisateur(Utilisateur utilisateur);

    // Recherche des paniers par date de création
    List<Panier> findByDateCreation(LocalDateTime dateCreation);

    // Autres méthodes de recherche et de filtrage selon vos besoins
}
