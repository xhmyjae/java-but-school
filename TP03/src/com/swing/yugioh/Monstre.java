package com.swing.yugioh;

import java.io.*;

public class Monstre extends Carte {
    private Integer niveau;
    private EnumAttributsMonstre.attribut attribut;
    private String type;
    private Integer atk;
    private Integer def;

    public Monstre(String nom, String numero, String description, Integer niveau, EnumAttributsMonstre.attribut attribut, String type, Integer atk, Integer def) {
        super(nom, numero, description);
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

    @Override
    public void saveCarte(String numero, File file) throws FileNotFoundException {
        super.saveCarte(numero, file);
        try {
            // append to file
            FileWriter writer = new FileWriter(file, true);
            writer.write(this.niveau + ";" + this.attribut + ";" + this.type + ";" + this.atk + ";" + this.def + ";");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loadCarte(String numero) throws FileNotFoundException {
        super.loadCarte(numero);
        File file = new File("src/com/swing/yugioh/savesCartes/monstres/" + numero + ".txt");
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
}
