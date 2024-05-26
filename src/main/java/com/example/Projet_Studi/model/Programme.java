package com.example.Projet_Studi.model;
import lombok.Data;

@Data
public class Programme {
    private String sport;
    private String horaires;
    private String lieu;

    public Programme(String sport, String horaires, String lieu) {
        this.sport = sport;
        this.horaires = horaires;
        this.lieu = lieu;
    }
}