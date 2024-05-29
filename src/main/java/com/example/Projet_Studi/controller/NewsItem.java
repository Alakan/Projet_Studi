package com.example.Projet_Studi.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsItem {
    private String titre;
    private String resume;
    private String url;
}
