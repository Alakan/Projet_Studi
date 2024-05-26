package com.example.Projet_Studi.controller;

import com.example.Projet_Studi.model.Programme;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PageController {

    @GetMapping("/")
    public String index(Model model) {
        List<String> sports = new ArrayList<>();
        sports.add("Athlétisme");
        sports.add("Natation");
        sports.add("Gymnastique");
        sports.add("Basketball");
        sports.add("Football (Soccer)");
        sports.add("Tennis");
        sports.add("Volleyball");
        sports.add("Cyclisme");
        sports.add("Boxe");
        sports.add("Escrime");
        sports.add("Judo");
        sports.add("Taekwondo");
        sports.add("Rugby à sept");
        sports.add("Handball");
        sports.add("Badminton");

        model.addAttribute("sports", sports);
        return "index";
    }

    @GetMapping("/sports")
    public String sports(Model model) {
        List<String> sports = new ArrayList<>();
        sports.add("Athlétisme");
        sports.add("Natation");
        sports.add("Gymnastique");
        sports.add("Basketball");
        sports.add("Football");
        sports.add("Tennis");
        sports.add("Volleyball");
        sports.add("Cyclisme");
        sports.add("Boxe");
        sports.add("Escrime");
        sports.add("Judo");
        sports.add("Taekwondo");
        sports.add("Rugby");
        sports.add("Handball");
        sports.add("Badminton");

        model.addAttribute("sports", sports);
        return "sports";
    }

    @GetMapping("/programmes")
    public String programmes(Model model) {
        List<Programme> programmes = new ArrayList<>();

        // Ajoutez des programmes pour différents sports avec horaires et lieux
        programmes.add(new Programme("Athlétisme", "09:00 - 12:00", "Stade de France"));
        programmes.add(new Programme("Natation", "14:00 - 17:00", "Piscine Aquatique"));
        programmes.add(new Programme("Gymnastique", "10:00 - 13:00", "Palais des Sports"));
        programmes.add(new Programme("Basketball", "16:00 - 19:00", "Stade de Basket"));
        programmes.add(new Programme("Football", "20:00 - 23:00", "Stade de Football"));
        programmes.add(new Programme("Tennis", "12:00 - 15:00", "Centre de Tennis"));
        programmes.add(new Programme("Volleyball", "11:00 - 14:00", "Stade de Volleyball"));
        programmes.add(new Programme("Cyclisme", "08:00 - 11:00", "Parcours de Cyclisme"));
        programmes.add(new Programme("Boxe", "18:00 - 21:00", "Salle de Boxe"));
        programmes.add(new Programme("Escrime", "15:00 - 18:00", "Salle d'Escrime"));
        programmes.add(new Programme("Judo", "13:00 - 16:00", "Dojo Olympique"));
        programmes.add(new Programme("Taekwondo", "17:00 - 20:00", "Salle de Taekwondo"));
        programmes.add(new Programme("Rugby", "19:00 - 22:00", "Stade de Rugby"));
        programmes.add(new Programme("Handball", "21:00 - 00:00", "Stade de Handball"));
        programmes.add(new Programme("Badminton", "14:00 - 17:00", "Terrain de Badminton"));

        model.addAttribute("programmes", programmes);
        return "programmes";
    }

    @GetMapping("/billets")
    public String billets() {
        return "billets";
    }
}
