package com.swing.yugioh;

import java.io.*;

public class Carte implements ICarteYuGiOh {
//public class Carte {
    private String nom;
    private String numero;
    private String description;

    private String cardType;

    public Carte(String nom, String numero, String description, String cardType) {
        this.nom = nom;
        this.numero = numero;
        this.description = description;
        this.cardType = cardType;
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

    public String getCardType() {
        return cardType;
    }

    /**
     * Il crée un fichier avec le nom du numéro de la carte et y écrit le nom, la description et le type de la carte
     *
     * @param numero le numéro de la carte
     */
    @Override
    public void saveCarte(String numero) throws FileNotFoundException {
        File file = new File("src/com/swing/yugioh/savedCartes/" + numero + ".txt");

        try {
            if (file.createNewFile()) {
                try {
                    FileWriter writer = new FileWriter(file, true);
                    writer.write(this.nom + ";" + this.description + ";" + this.cardType + ";");
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

    /**
     * Il lit un fichier et stocke les données dans l'objet
     *
     * @param numero le numéro de la carte
     */
    @Override
    public void loadCarte(String numero) throws FileNotFoundException {
        File file = new File("src/com/swing/yugioh/savesCartes/" + numero + ".txt");
        if (file.exists()) {
            try {
                FileReader reader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String line = bufferedReader.readLine();
                String[] data = line.split(";");
                this.nom = data[0];
                this.description = data[1];
                this.cardType = data[2];
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            throw new FileNotFoundException("Le fichier n'existe pas");
        }
    }

    /**
     * Il vérifie si un fichier existe dans un répertoire spécifique
     *
     * @return Une valeur booléenne.
     */
    public boolean hasBeenSaved() {
        File file = new File("src/com/swing/yugioh/savedCartes/" + this.numero + ".txt");
        return file.exists();
    }
}
