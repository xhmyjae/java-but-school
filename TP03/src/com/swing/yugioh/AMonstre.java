package com.swing.yugioh;

import java.io.*;

public abstract class AMonstre {

    public Monstre loadCarteMonstre(String numero) throws FileNotFoundException {
        try {
            FileOutputStream fos = new FileOutputStream(new File("cartes/" + numero + ".txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        FileReader file = new FileReader("cartes/" + numero + ".txt");
        BufferedReader reader = new BufferedReader(file);
        return new Monstre(write, "description", "numero", 1, EnumAttributsMonstre.attribut.EAU, "type", 1, 1);
    }

    public void saveCarteMonstre() {
        try {
            FileOutputStream fos = new FileOutputStream(new File("carte" + numero + ".txt"));
            fos.write(this.toString().getBytes());
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
