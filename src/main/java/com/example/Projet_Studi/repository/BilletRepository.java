package com.example.Projet_Studi.repository;

import com.example.Projet_Studi.model.Billet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BilletRepository extends JpaRepository<Billet, Long> {

    List<Billet> findByCommandeId(Long commandeId);

    List<Billet> findByUtilisateurId(Long utilisateurId);
}
