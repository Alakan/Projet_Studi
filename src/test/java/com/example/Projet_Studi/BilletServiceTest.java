package com.example.Projet_Studi;

import com.example.Projet_Studi.model.Billet;
import com.example.Projet_Studi.model.Commande;
import com.example.Projet_Studi.model.Utilisateur;
import com.example.Projet_Studi.repository.BilletRepository;
import com.example.Projet_Studi.services.BilletService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@Transactional
public class BilletServiceTest {

    @Mock
    private BilletRepository billetRepository;

    @InjectMocks
    private BilletService billetService;

    @Test
    public void testCreerBillet() {
        // Création d'une commande et d'un utilisateur
        Commande commande = new Commande();
        commande.setId(1L);
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(1L);

        // Définition du comportement du repository mocké
        when(billetRepository.save(new Billet()))
                .thenReturn(new Billet(1L, commande, utilisateur, UUID.randomUUID().toString(), "QRCode"));

        // Appel de la méthode à tester
        Billet billet = billetService.creerBillet(commande, utilisateur);

        // Assertions
        assertEquals(commande.getId(), billet.getCommande().getId());
        assertEquals(utilisateur.getId(), billet.getUtilisateur().getId());
        // Ajoutez d'autres assertions selon les champs que vous voulez tester
    }

    // Test de recherche de billets par commande
    @Test
    public void testRechercherBilletsParCommande() {
        // Création d'une commande et d'un billet associé
        Commande commande = new Commande();
        Utilisateur utilisateur = new Utilisateur();
        Billet billet = billetService.creerBillet(commande, utilisateur);

        // Recherche des billets par commande
        List<Billet> billets = billetService.rechercherBilletsParCommande(commande);
        assertNotNull(billets);
        assertEquals(1, billets.size());
        assertEquals(billet.getId(), billets.get(0).getId());
    }

    // Test de recherche de billets par utilisateur
    @Test
    public void testRechercherBilletsParUtilisateur() {
        // Création d'un utilisateur et d'un billet associé
        Commande commande = new Commande();
        Utilisateur utilisateur = new Utilisateur();
        Billet billet = billetService.creerBillet(commande, utilisateur);

        // Recherche des billets par utilisateur
        List<Billet> billets = billetService.rechercherBilletsParUtilisateur(utilisateur);
        assertNotNull(billets);
        assertEquals(1, billets.size());
        assertEquals(billet.getId(), billets.get(0).getId());
    }

    // Test de mise à jour d'un billet
    @Test
    public void testMettreAJourBillet() {
        // Création d'un billet
        Commande commande = new Commande();
        Utilisateur utilisateur = new Utilisateur();
        Billet billet = billetService.creerBillet(commande, utilisateur);

        // Modification des données du billet
        billet.setCleBillet("Nouvelle cle");
        billet.setQrcode("Nouveau QR code");

        // Mise à jour du billet
        Billet updatedBillet = billetService.mettreAJourBillet(billet);
        assertNotNull(updatedBillet);
        assertEquals(billet.getId(), updatedBillet.getId());
        assertEquals("Nouvelle cle", updatedBillet.getCleBillet());
        assertEquals("Nouveau QR code", updatedBillet.getQrcode());
    }

    // Test de suppression d'un billet
    @Test
    public void testSupprimerBillet() {
        // Création d'un billet
        Commande commande = new Commande();
        Utilisateur utilisateur = new Utilisateur();
        Billet billet = billetService.creerBillet(commande, utilisateur);

        // Suppression du billet
        billetService.supprimerBillet(billet.getId());

        // Vérification que le billet a été supprimé
        assertThrows(Exception.class, () -> {
            billetService.getBilletById(billet.getId());
        });
    }
}
