package com.swing.yugioh;

import java.io.*;

public abstract class AMonstre {

    public Monstre loadCarte(String numero) throws FileNotFoundException {
        File file = new File("cartes/" + numero + ".txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        try {
            st = br.readLine();
            String[] data = st.split(";");
            return new Monstre(data[0], data[1], data[2], Integer.parseInt(data[3]), EnumAttributsMonstre.attribut.valueOf(data[4]), data[5], Integer.parseInt(data[6]), Integer.parseInt(data[7]));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void saveCarte(String numero) throws FileNotFoundException {
        File file = new File("cartes/" + numero + ".txt");
        FileOutputStream fos = new FileOutputStream(file);
        try {
            fos.write((this.getNom() + ";" + this.getDescription() + ";" + this.getNumero() + ";" + this.getNiveau() + ";" + this.getAttribut() + ";" + this.getType() + ";" + this.getAtk() + ";" + this.getDef()).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
