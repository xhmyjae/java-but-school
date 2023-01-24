package utils;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class utils {

    /**
     * Cette fonction prend un JButton, un JPanel et deux entiers, et définit la taille, la police, la couleur
     * d'arrière-plan, la couleur de premier plan et la focalisation préférées du JButton, puis ajoute le JButton au JPanel
     *
     * @param button Le bouton que vous souhaitez concevoir.
     * @param panel Le panneau auquel vous souhaitez ajouter le bouton.
     * @param width La largeur du bouton
     * @param height La hauteur du bouton
     */
    public static void buttonDesign(JButton button, JPanel panel, int width, int height) {
        button.setPreferredSize(new Dimension(width, height));
        button.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        button.setBackground(Color.decode("#1C1E26"));
        button.setForeground(Color.decode("#7F9AB3"));
        button.setFocusable(false);
        panel.add(button);
    }

    /**
     * Étant donné un objet, renvoie le nom de la classe de cet objet.
     *
     * @param object Objet dont le type doit être obtenu.
     * @return Le nom de la classe de l'objet.
     */
    public static String getObjectType(Object object) {
        return object.getClass().getSimpleName();
    }

    /**
     * Il lit la première ligne d'un fichier, le divise en un tableau de chaînes et renvoie le troisième élément de ce
     * tableau
     *
     * @param file Le fichier à lire
     * @return Le type de carte est renvoyé.
     */
    public static String cardTypeFromFile(File file) {
        try {
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = bufferedReader.readLine();
            String[] data = line.split(";");
            bufferedReader.close();
            return data[2];
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
