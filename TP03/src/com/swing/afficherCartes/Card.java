package com.swing.afficherCartes;

import java.awt.*;

public class Card {

    public Image[] getImages() {
        Image[] images = new Image[52];
        // cut deck image in 52 pieces (13 columns and 4 rows)
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                images[i * 13 + j] = Toolkit.getDefaultToolkit().createImage("src/resources/deck.png").getScaledInstance(100, 150, Image.SCALE_SMOOTH);
            }
        }
        return images;
    }

    public Image getRandomCard(Image[] images) {
        int random = (int) (Math.random() * images.length);
        return images[random];
    }

    public Image[] removeCard(Image card, Image[] images) {
        Image[] newImages = new Image[images.length - 1];
        int index = 0;
        for (Image image : images) {
            if (image != card) {
                newImages[index] = image;
                index++;
            }
        }
        return newImages;
    }
}
