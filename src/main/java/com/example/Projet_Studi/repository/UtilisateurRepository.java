package com.example.Projet_Studi.repository;

import com.example.Projet_Studi.model.TypeUtilisateur;
import com.example.Projet_Studi.model.Utilisateur;
import jdk.jshell.execution.Util;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/** Interface Repository pour l'entité Utilisateur
* Elle permet d'effectuer des opérations CRUD sur les utilisateurs
*
* @author Anthony
* @version Version initiale
*
**/
@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    // Recherche un utilisateur par email
    Utilisateur findByEmail(String email);
    // Recherche un utilisateur par email et mot de passe
    Utilisateur findByEmailAndMotDePasse(String email, String motDePasse);
    // Recherche des utilisateurs par nom et prénom
    List<Utilisateur> findByNomAndPrenom(String nom, String prenom);
    List<Utilisateur> findByNomContainingIgnoreCaseOrPrenomContainingIgnoreCase(String nom, String prenom);
    // Recherche des utilisateurs par rôle
    List<Utilisateur> findByTypeUtilisateur(TypeUtilisateur type);
    // Recherche des utilisateurs par date de création
    List<Utilisateur> findByDateCreationBetween(LocalDateTime debut, LocalDateTime fin);
    // Compte le nombre total d'utilisateurs
    long count();
    // Vérifie si un utilisateur existe par adresse mail
    boolean existsByEmail (String email);
}
