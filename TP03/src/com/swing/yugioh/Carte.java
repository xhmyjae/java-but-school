package com.swing.yugioh;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

//public class Carte implements ICarteYuGiOh {
public class Carte {
    private String nom;
    private String numero;
    private String description;

    public Carte(String nom, String numero, String description) {
        this.nom = nom;
        this.numero = numero;
        this.description = description;
    }

    public String getNom() {
        return nom;
    }

    public String getNumero() {
        return numero;
    }

    public String getDescription() {
        return description;
    }
}
