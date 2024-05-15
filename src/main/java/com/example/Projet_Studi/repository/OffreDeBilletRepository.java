package com.example.Projet_Studi.repository;

import com.example.Projet_Studi.model.OffreDeBillet;
import com.example.Projet_Studi.model.TypeOffre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * Interface Repository pour l'entité OffreDeBillet
 * Elle permet d'effectuer des opérations CRUD sur les offres de billet
 *
 * @author Anthony
 * @version Version initiale
 */
@Repository
public interface OffreDeBilletRepository extends JpaRepository<OffreDeBillet, Long> {

    // Méthode pour rechercher une offre de billet par son type
    List<OffreDeBillet> findByTypeOffre(TypeOffre typeOffre);

    // Méthode pour rechercher des offres de billet par un prix inférieur à une certaine valeur
    List<OffreDeBillet> findByPrixLessThan(BigDecimal prix);

    // Méthode pour rechercher des offres de billet par un prix supérieur à une certaine valeur
    List<OffreDeBillet> findByPrixGreaterThan(BigDecimal prix);

    // Méthode pour rechercher des offres de billet par un prix compris entre deux valeurs
    List<OffreDeBillet> findByPrixBetween(BigDecimal prixMin, BigDecimal prixMax);
}
