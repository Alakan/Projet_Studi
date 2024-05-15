package com.example.Projet_Studi.repository;

import com.example.Projet_Studi.model.Commande;
import com.example.Projet_Studi.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long> {

    // Recherche des commandes par utilisateur
    List<Commande> findByUtilisateur(Utilisateur utilisateur);

    // Recherche des commandes par quantité
    List<Commande> findByQuantite(int quantite);

    // Recherche des commandes par date de commande
    List<Commande> findByDateCommande(LocalDateTime dateCommande);

    // Recherche des commandes par utilisateur et date de commande
    List<Commande> findByUtilisateurAndDateCommande(Utilisateur utilisateur, LocalDateTime dateCommande);

    // Autres méthodes de recherche et de filtrage selon vos besoins
}
