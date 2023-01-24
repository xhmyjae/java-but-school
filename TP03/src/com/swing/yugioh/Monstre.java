package com.swing.yugioh;

import java.io.*;

public class Monstre extends Carte {
    private Integer niveau;
    private EnumAttributsMonstre.attribut attribut;
    private String type;
    private Integer atk;
    private Integer def;

    public Monstre(String nom, String numero, String description, String cardType, Integer niveau, EnumAttributsMonstre.attribut attribut, String type, Integer atk, Integer def) {
        super(nom, numero, description, cardType);
        this.niveau = niveau;
        this.attribut = attribut;
        this.type = type;
        this.atk = atk;
        this.def = def;
    }

    public Integer getNiveau() {
        return niveau;
    }

    public EnumAttributsMonstre.attribut getAttribut() {
        return attribut;
    }

    public String getType() {
        return type;
    }

    public Integer getAtk() {
        return atk;
    }

    public Integer getDef() {
        return def;
    }

    /**
     * Il enregistre les attributs de la carte dans un fichier
     *
     * @param numero le numéro de carte
     */
    @Override
    public void saveCarte(String numero) throws FileNotFoundException {
        super.saveCarte(numero);
        File file = new File("src/com/swing/yugioh/savedCartes/" + numero + ".txt");
        try {
            FileWriter writer = new FileWriter(file, true);
            writer.write(this.niveau + ";" + this.attribut + ";" + this.type + ";" + this.atk + ";" + this.def + ";");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Il lit le fichier de la carte et charge les données dans la carte
     *
     * @param numero le numéro de carte
     */
    @Override
    public void loadCarte(String numero) throws FileNotFoundException {
        super.loadCarte(numero);
        File file = new File("src/com/swing/yugioh/savesCartes/" + numero + ".txt");
        if (file.exists()) {
            try {
                FileReader reader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String line = bufferedReader.readLine();
                String[] data = line.split(";");
                this.niveau = Integer.parseInt(data[2]);
                this.attribut = EnumAttributsMonstre.attribut.valueOf(data[3]);
                this.type = data[4];
                this.atk = Integer.parseInt(data[5]);
                this.def = Integer.parseInt(data[6]);
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            return;
        }
    }

    /**
     * Il génère une carte monstre aléatoire
     *
     * @return Une carte monstre aléatoire.
     */
    public static Monstre generateRandomMonsterCard() {
        String nom = "Monstre " + (int) (Math.random() * 100);
        String numero = "M" + (int) (Math.random() * 100);
        String description = "Description " + (int) (Math.random() * 100);
        String cardType = "Monstre";
        Integer niveau = (int) (Math.random() * 10);
        EnumAttributsMonstre.attribut attribut = EnumAttributsMonstre.attribut.values()[(int) (Math.random() * (EnumAttributsMonstre.attribut.values().length))];
        String type = "Type " + (int) (Math.random() * 100);
        Integer atk = (int) (Math.random() * 1000);
        Integer def = (int) (Math.random() * 1000);
        return new Monstre(nom, numero, description, cardType, niveau, attribut, type, atk, def);
    }

}
