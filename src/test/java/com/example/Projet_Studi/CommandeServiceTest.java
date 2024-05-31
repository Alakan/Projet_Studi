package com.example.Projet_Studi;

import com.example.Projet_Studi.model.Commande;
import com.example.Projet_Studi.model.Utilisateur;
import com.example.Projet_Studi.repository.CommandeRepository;
import com.example.Projet_Studi.services.CommandeService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CommandeServiceTest {
/*
    @Mock
    private CommandeRepository commandeRepository;

    @InjectMocks
    private CommandeService commandeService;

    @Test
    void testCreerCommande() {
        // Création d'une commande
        Commande commande = new Commande();
        commande.setQuantite(5);
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(1L);
        commande.setUtilisateur(utilisateur);

        // Mock du repository pour retourner la commande sauvegardée
        when(commandeRepository.save(commande)).thenReturn(commande);

        // Appel du service pour créer la commande
        Commande newCommande = commandeService.creerCommande(commande);

        // Vérification que la commande a bien été créée
        assertNotNull(newCommande);
        assertEquals(commande.getQuantite(), newCommande.getQuantite());
        assertEquals(commande.getUtilisateur(), newCommande.getUtilisateur());
    }

    @Test
    void testGetCommandeById() {
        // Création d'une commande factice
        Commande commande = new Commande();
        commande.setId(1L);
        when(commandeRepository.findById(1L)).thenReturn(Optional.of(commande));

        // Appel du service pour récupérer la commande par ID
        Commande retrievedCommande = commandeService.getCommandeById(1L);

        // Vérification que la commande a bien été récupérée
        assertNotNull(retrievedCommande);
        assertEquals(commande.getId(), retrievedCommande.getId());
    }

    @Test
    void testGetCommandesUtilisateur() {
        // Création d'une commande factice
        Commande commande = new Commande();
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(1L);
        commande.setUtilisateur(utilisateur);
        when(commandeRepository.findByUtilisateur(utilisateur)).thenReturn(Collections.singletonList(commande));

        // Appel du service pour récupérer les commandes de l'utilisateur
        List<Commande> commandes = commandeService.getCommandesUtilisateur(utilisateur);

        // Vérification que la liste des commandes a bien été récupérée
        assertNotNull(commandes);
        assertEquals(1, commandes.size());
        assertEquals(commande, commandes.get(0));
    }

    @Test
    void testMettreAJourCommande() {
        // Création d'une commande factice
        Commande commande = new Commande();
        commande.setId(1L);
        commande.setQuantite(5);

        // Mock du repository pour retourner la commande mise à jour
        when(commandeRepository.findById(1L)).thenReturn(Optional.of(commande));
        when(commandeRepository.save(commande)).thenReturn(commande);

        // Mise à jour de la quantité de commande
        Commande updatedCommande = commandeService.mettreAJourCommande(commande);

        // Vérification que la commande a bien été mise à jour
        assertNotNull(updatedCommande);
        assertEquals(commande.getQuantite(), updatedCommande.getQuantite());
    }

    @Test
    void testSupprimerCommande() {
        // Appel du service pour supprimer une commande
        commandeService.supprimerCommande(1L);

        // Vérification que la méthode deleteById a été appelée une fois avec l'ID spécifié
        verify(commandeRepository, times(1)).deleteById(1L);
    }

    // Test pour vérifier que la méthode creerCommande lance une exception si l'utilisateur est null
    @Test
    void testCreerCommandeWithNullUser() {
        // Création d'une commande avec utilisateur null
        Commande commande = new Commande();
        commande.setQuantite(5);

        // Vérification que la méthode creerCommande lance une EntityNotFoundException
        assertThrows(EntityNotFoundException.class, () -> commandeService.creerCommande(commande));
    }

    // Test pour vérifier que la méthode getCommandeById lance une exception si la commande n'existe pas
    @Test
    void testGetCommandeByIdWithNonExistingId() {
        // Mock du repository pour retourner une commande vide
        when(commandeRepository.findById(1L)).thenReturn(Optional.empty());

        // Vérification que la méthode getCommandeById lance une EntityNotFoundException
        assertThrows(EntityNotFoundException.class, () -> commandeService.getCommandeById(1L));
    }*/
}