package com.swing.yugioh;

import java.io.*;

public class Carte implements ICarteYuGiOh {
//public class Carte {
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

    @Override
    public void saveCarte(String numero, File file) throws FileNotFoundException {
        System.out.println(file);
        try {
            if (file.createNewFile()) {
                try {
                    FileWriter writer = new FileWriter(file, true);
                    writer.write(this.nom + ";" + this.description + ";");
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                throw new FileNotFoundException("Le fichier existe déjà");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loadCarte(String numero) throws FileNotFoundException {

    }


}
