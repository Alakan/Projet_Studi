package com.example.Projet_Studi.controller;

import com.example.Projet_Studi.model.Programme;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.Projet_Studi.controller.NewsItem;

import java.util.Arrays;
import java.util.List;

@Controller
public class PageController {

    @GetMapping("/")
    public String index(Model model) {
        List<String> sports = Arrays.asList(
                "Athlétisme", "Natation", "Gymnastique", "Basketball", "Football", "Tennis",
                "Volleyball", "Cyclisme", "Boxe", "Escrime", "Judo", "Taekwondo", "Rugby", "Handball", "Badminton"
        );
        model.addAttribute("sports", sports);

        List<NewsItem> newsItems = Arrays.asList(
                new NewsItem("Nouvelles disciplines ajoutées", "Le Comité Olympique a annoncé l'ajout de nouvelles disciplines pour les JO 2024, incluant le breakdance et l'escalade sportive.", "/actualites/nouvelles-disciplines"),
                new NewsItem("Billetterie ouverte", "La billetterie pour les Jeux Olympiques 2024 est maintenant ouverte. Ne manquez pas votre chance d'assister à cet événement historique.", "/actualites/billetterie-ouverte"),
                new NewsItem("Annonce des mascottes", "Découvrez les mascottes officielles des JO 2024, symboles de l'esprit olympique et de l'hospitalité parisienne.", "/actualites/annonce-mascottes")
        );
        model.addAttribute("newsItems", newsItems);

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

    @GetMapping("/billets")
    public String billets() {
        return "billets";
    }

    @GetMapping("/user-login")
    public String login() {
        return "user-login";
    }

    @GetMapping("/user-register")
    public String register() {
        return "user-register";
    }

    @GetMapping("/user-profile")
    public String profile(Model model) {
        // Ajouter la logique pour récupérer les informations de l'utilisateur actuel
        return "user-profile";
    }
}
