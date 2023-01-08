package com.swing.afficherCartes;

import java.awt.*;

public class Card {

    private Image[] getImages() {
        Image[] images = new Image[52];
        // cut deck image in 52 pieces (13 columns and 4 rows)
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                images[i * 13 + j] = Toolkit.getDefaultToolkit().createImage("src/resources/deck.png").getScaledInstance(100, 150, Image.SCALE_SMOOTH);
            }
        }
        return images;
    }

    public Image getRandomCard() {
        Image[] images = getImages();
        return images[(int) (Math.random() * 52)];
    }
}
