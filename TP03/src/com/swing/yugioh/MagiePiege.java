package com.swing.yugioh;

import java.io.*;

public class MagiePiege extends Carte {
    private EnumTypeMagiePiege.type type;
    private EnumIcones.icone icone;

    public MagiePiege(String nom, String numero, String description, String cardType, EnumTypeMagiePiege.type type, EnumIcones.icone icone) {
        super(nom, numero, description, cardType);
        this.type = type;
        this.icone = icone;
    }

    public EnumTypeMagiePiege.type getType() {
        return type;
    }

    public EnumIcones.icone getIcone() {
        return icone;
    }

    /**
     * Il enregistre le type et l'icône de la carte dans un fichier
     *
     * @param numero le numéro de carte
     */
    @Override
    public void saveCarte(String numero) throws FileNotFoundException {
        super.saveCarte(numero);
        File file = new File("src/com/swing/yugioh/savedCartes/" + numero + ".txt");
        try {
            FileWriter writer = new FileWriter(file, true);
            writer.write(this.type + ";" + this.icone + ";");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Il charge la carte à partir d'un fichier
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
                this.type = EnumTypeMagiePiege.type.valueOf(data[0]);
                this.icone = EnumIcones.icone.valueOf(data[1]);
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            return;
        }
    }

    /**
     * Il génère une carte MagiePiege aléatoire
     *
     * @return Un nouvel objet MagiePiege.
     */
    public static MagiePiege generateRandomMagiePiegeCard() {
        String nom = "MagiePiege" + (int) (Math.random() * 100);
        String numero = "MP" + (int) (Math.random() * 100);
        String description = "Description " + (int) (Math.random() * 100);
        String cardType = "MagiePiege";
        EnumTypeMagiePiege.type type = EnumTypeMagiePiege.type.valueOf(EnumTypeMagiePiege.type.values()[(int) (Math.random() * EnumTypeMagiePiege.type.values().length)].toString());
        EnumIcones.icone icone = EnumIcones.icone.valueOf(EnumIcones.icone.values()[(int) (Math.random() * EnumIcones.icone.values().length)].toString());

        return new MagiePiege(nom, numero, description, cardType, type, icone);
    }
}
