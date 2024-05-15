package com.example.Projet_Studi.repository;

import com.example.Projet_Studi.model.Billet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interface Repository pour l'entité Billet.
 * Elle permet d'effectuer des opérations CRUD sur les billets.
 *
 * @author Anthony
 * @version Version initiale
 */
@Repository
public interface BilletRepository extends JpaRepository<Billet, Long> {

    /**
     * Trouve les billets associés à une commande spécifique.
     *
     * @param commandeId l'identifiant de la commande.
     * @return une liste de billets associés à la commande spécifiée.
     */
    List<Billet> findByCommandeId(Long commandeId);

    /**
     * Trouve les billets associés à un utilisateur spécifique.
     *
     * @param utilisateurId l'identifiant de l'utilisateur.
     * @return une liste de billets associés à l'utilisateur spécifié.
     */
    List<Billet> findByUtilisateurId(Long utilisateurId);
}
