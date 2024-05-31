package com.example.Projet_Studi.controller;

import com.example.Projet_Studi.model.Billet;
import com.example.Projet_Studi.model.Programme;
import com.example.Projet_Studi.model.Utilisateur;
import com.example.Projet_Studi.services.UtilisateurService;
import com.example.Projet_Studi.services.BilletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
public class PageController {

    private final UtilisateurService utilisateurService;

    public PageController(UtilisateurService userService) {
        this.utilisateurService = userService;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<String> sports = Arrays.asList(
                "Athlétisme", "Natation", "Gymnastique", "Basketball", "Football", "Tennis",
                "Volleyball", "Cyclisme", "Boxe", "Escrime", "Judo", "Taekwondo", "Rugby", "Handball", "Badminton"
        );
        model.addAttribute("sports", sports);

        return "index";
    }

    @GetMapping("/sports")
    public String sports(Model model) {
        List<String> sports = Arrays.asList(
                "Athlétisme", "Natation", "Gymnastique", "Basketball", "Football", "Tennis",
                "Volleyball", "Cyclisme", "Boxe", "Escrime", "Judo", "Taekwondo", "Rugby", "Handball", "Badminton"
        );
        model.addAttribute("sports", sports);
        return "sports";
    }

    @GetMapping("/programmes")
    public String programmes(Model model) {
        List<Programme> programmes = Arrays.asList(
                new Programme("Athlétisme", "09:00 - 12:00", "Stade de France"),
                new Programme("Natation", "14:00 - 17:00", "Piscine Aquatique"),
                new Programme("Gymnastique", "10:00 - 13:00", "Palais des Sports"),
                new Programme("Basketball", "16:00 - 19:00", "Stade de Basket"),
                new Programme("Football", "20:00 - 23:00", "Stade de Football"),
                new Programme("Tennis", "12:00 - 15:00", "Centre de Tennis"),
                new Programme("Volleyball", "11:00 - 14:00", "Stade de Volleyball"),
                new Programme("Cyclisme", "08:00 - 11:00", "Parcours de Cyclisme"),
                new Programme("Boxe", "18:00 - 21:00", "Salle de Boxe"),
                new Programme("Escrime", "15:00 - 18:00", "Salle d'Escrime"),
                new Programme("Judo", "13:00 - 16:00", "Dojo Olympique"),
                new Programme("Taekwondo", "17:00 - 20:00", "Salle de Taekwondo"),
                new Programme("Rugby", "19:00 - 22:00", "Stade de Rugby"),
                new Programme("Handball", "21:00 - 00:00", "Stade de Handball"),
                new Programme("Badminton", "14:00 - 17:00", "Terrain de Badminton")
        );

        model.addAttribute("programmes", programmes);
        return "programmes";
    }

    @Autowired
    private BilletService billetService;

    @GetMapping("/billets")
    public String billets(Model model) {
        List<Billet> tickets = billetService.getAllBillets();
        model.addAttribute("tickets", tickets);
        return "billets";
    }


    @GetMapping("/user-login")
    public String login() {
        return "user-login";
    }

    @GetMapping("/user-register")
    public String register(Model model) {
        model.addAttribute("user", new Utilisateur());
        return "user-register";
    }

    @PostMapping("/user-register")
    public String processRegistration(@ModelAttribute @Valid Utilisateur utilisateur, BindingResult result) {
        if (result.hasErrors()) {
            // S'il y a des erreurs de validation, retourne à la page d'inscription avec les erreurs affichées
            return "user-register";
        }

        // Ajoutez ici la logique pour traiter les données du formulaire et ajouter l'utilisateur à la base de données
        // Utilisez le service UserService pour ajouter l'utilisateur
        utilisateurService.inscrireUtilisateur(utilisateur);

        // Redirige vers la page de connexion après l'inscription réussie
        return "redirect:/user-login";
    }

    @GetMapping("/user-profile")
    public String profile(Model model) {
        // Ajouter la logique pour récupérer les informations de l'utilisateur actuel
        return "user-profile";
    }
}
