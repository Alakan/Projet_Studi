package com.example.Projet_Studi;

import com.example.Projet_Studi.model.TypeUtilisateur;
import com.example.Projet_Studi.model.Utilisateur;
import com.example.Projet_Studi.repository.UtilisateurRepository;
import com.example.Projet_Studi.services.UtilisateurService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class UtilisateurServiceTest {

    @Autowired
    private UtilisateurService utilisateurService;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @BeforeEach
    public void setUp() {
        utilisateurRepository.deleteAll();
    }

    @Test
    public void testInscrireUtilisateurAvecDonneesValides() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom("John");
        utilisateur.setPrenom("Doe");
        utilisateur.setEmail("john.doe@example.com");
        utilisateur.setMotDePasse("MotDePasse!123");
        utilisateur.setTypeUtilisateur(TypeUtilisateur.client);
        utilisateur.setDateCreation(LocalDateTime.now());

        Utilisateur nouvelUtilisateur = utilisateurService.inscrireUtilisateur(utilisateur);

        assertNotNull(nouvelUtilisateur);
        assertEquals("John", nouvelUtilisateur.getNom());
    }

    @Test
    public void testInscrireUtilisateurAvecDonneesInvalides() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom("John");
        utilisateur.setPrenom("Doe");
        utilisateur.setEmail("john.doe@example");
        utilisateur.setMotDePasse("123");
        utilisateur.setTypeUtilisateur(TypeUtilisateur.client);
        utilisateur.setDateCreation(LocalDateTime.now());

        assertThrows(IllegalArgumentException.class, () -> utilisateurService.inscrireUtilisateur(utilisateur));
    }

    @Test
    public void testGetUtilisateurById() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom("John");
        utilisateur.setPrenom("Doe");
        utilisateur.setEmail("john.doe@example.com");
        utilisateur.setMotDePasse("MotDePasse!123");
        utilisateur.setTypeUtilisateur(TypeUtilisateur.client);
        utilisateur.setDateCreation(LocalDateTime.now());

        utilisateurRepository.save(utilisateur);

        Utilisateur foundUtilisateur = utilisateurService.getUtilisateurById(utilisateur.getId());

        assertNotNull(foundUtilisateur);
        assertEquals("John", foundUtilisateur.getNom());
    }

    @Test
    public void testExisteUtilisateurParEmail() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom("John");
        utilisateur.setPrenom("Doe");
        utilisateur.setEmail("john.doe@example.com");
        utilisateur.setMotDePasse("MotDePasse!123");
        utilisateur.setTypeUtilisateur(TypeUtilisateur.client);
        utilisateur.setDateCreation(LocalDateTime.now());

        utilisateurRepository.save(utilisateur);

        boolean exists = utilisateurService.existeUtilisateurParEmail("john.doe@example.com");

        assertTrue(exists);
    }

    @Test
    public void testSupprimerUtilisateur() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom("John");
        utilisateur.setPrenom("Doe");
        utilisateur.setEmail("john.doe@example.com");
        utilisateur.setMotDePasse("MotDePasse!123");
        utilisateur.setTypeUtilisateur(TypeUtilisateur.client);
        utilisateur.setDateCreation(LocalDateTime.now());

        utilisateurRepository.save(utilisateur);

        utilisateurService.supprimerUtilisateurById(utilisateur.getId());

        assertFalse(utilisateurRepository.existsById(utilisateur.getId()));
    }

    @Test
    public void testModifierInformationsUtilisateur() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom("John");
        utilisateur.setPrenom("Doe");
        utilisateur.setEmail("john.doe@example.com");
        utilisateur.setMotDePasse("MotDePasse!123");
        utilisateur.setTypeUtilisateur(TypeUtilisateur.client);
        utilisateur.setDateCreation(LocalDateTime.now());

        utilisateurRepository.save(utilisateur);

        Utilisateur modifiedUtilisateur = utilisateurService.modifierInformationsUtilisateur(
                utilisateur.getId(), "Johnny", "Doey", "johnny.doey@example.com", "NewMotDePasse!123");

        assertNotNull(modifiedUtilisateur);
        assertEquals("Johnny", modifiedUtilisateur.getNom());
        assertEquals("Doey", modifiedUtilisateur.getPrenom());
        assertEquals("johnny.doey@example.com", modifiedUtilisateur.getEmail());
        assertEquals("NewMotDePasse!123", modifiedUtilisateur.getMotDePasse());
    }

    @Test
    public void testReinitialisationMotDePasse() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom("John");
        utilisateur.setPrenom("Doe");
        utilisateur.setEmail("john.doe@example.com");
        utilisateur.setMotDePasse("MotDePasse!123");
        utilisateur.setTypeUtilisateur(TypeUtilisateur.client);
        utilisateur.setDateCreation(LocalDateTime.now());

        utilisateurRepository.save(utilisateur);

        utilisateurService.reinitialiserMotDePasse(utilisateur.getId(), "NewMotDePasse!123");
        Utilisateur updatedUtilisateur = utilisateurService.getUtilisateurById(utilisateur.getId());

        assertEquals("NewMotDePasse!123", updatedUtilisateur.getMotDePasse());
    }

    @Test
    public void testConnecterUtilisateurAvecInformationsValides() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom("John");
        utilisateur.setPrenom("Doe");
        utilisateur.setEmail("john.doe@example.com");
        utilisateur.setMotDePasse("MotDePasse!123");
        utilisateur.setTypeUtilisateur(TypeUtilisateur.client);
        utilisateur.setDateCreation(LocalDateTime.now());

        utilisateurRepository.save(utilisateur);

        Utilisateur connectedUtilisateur = utilisateurService.connecterUtilisateur("john.doe@example.com", "MotDePasse!123");

        assertNotNull(connectedUtilisateur);
    }

    @Test
    public void testConnecterUtilisateurAvecInformationsInvalides() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom("John");
        utilisateur.setPrenom("Doe");
        utilisateur.setEmail("john.doe@example.com");
        utilisateur.setMotDePasse("MotDePasse!123");
        utilisateur.setTypeUtilisateur(TypeUtilisateur.client);
        utilisateur.setDateCreation(LocalDateTime.now());

        utilisateurRepository.save(utilisateur);

        Utilisateur connectedUtilisateur = utilisateurService.connecterUtilisateur("john.doe@example.com", "WrongPassword");

        assertNull(connectedUtilisateur);
    }

    @Test
    public void testDeconnexionUtilisateur() {
        // Création d'un utilisateur
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom("John");
        utilisateur.setPrenom("Doe");
        utilisateur.setEmail("john.doe@example.com");
        utilisateur.setMotDePasse("MotDePasse!123");
        utilisateur.setTypeUtilisateur(TypeUtilisateur.client);
        utilisateur.setDateCreation(LocalDateTime.now());
        utilisateurRepository.save(utilisateur);

        // Simuler une connexion de l'utilisateur
        Utilisateur utilisateurConnecte = utilisateurService.connecterUtilisateur("john.doe@example.com", "MotDePasse!123");
        assertNotNull(utilisateurConnecte);

        // Vérifier que l'utilisateur est connecté
        assertEquals(utilisateur.getId(), utilisateurConnecte.getId());

        // Déconnecter l'utilisateur
        utilisateurService.deconnecterUtilisateur();

        // Vérifier que l'utilisateur est déconnecté
        assertThrows(NullPointerException.class, () -> {
            utilisateurService.getUtilisateurById(utilisateur.getId());
        });
    }
/*
    @Test
    public void testDeconnexionUtilisateur() {
        // Vérifier si l'authentification est initialement présente
        assertNotNull(SecurityContextHolder.getContext().getAuthentication());

        // Appeler la fonction de déconnexion de l'utilisateur
        utilisateurService.deconnecterUtilisateur();

        // Vérifier si l'authentification a été effacée après la déconnexion
        assertNull(SecurityContextHolder.getContext().getAuthentication());
    }
*/
}
