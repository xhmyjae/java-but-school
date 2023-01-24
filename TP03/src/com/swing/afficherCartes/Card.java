package com.swing.afficherCartes;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.Objects;

import utils.Requester;

public class Card {

    /**
     * Il prend l'image du jeu de cartes et la divise en 52 images distinctes, une pour chaque carte
     *
     * @return Un tableau d'images.
     */
    public static Image[] getCardsImages() throws IOException {
        BufferedImage deck = ImageIO.read(Objects.requireNonNull(Card.class.getClassLoader().getResource("resources/cardDeck.png")));
        Image[] cards = new Image[52];
        int x = 0;
        int y = 0;
        int width = 226;
        int height = 314;
        for (int i = 0; i < 52; i++) {
            cards[i] = deck.getSubimage(x, y, width, height);
            x += width;
            if (x >= 226 * 13) {
                x = 0;
                y += height;
            }
        }
        return cards;
    }

    /**
     * Il prend un tableau d'images et un index, et renvoie un nouveau tableau d'images qui est le même que le tableau
     * d'origine, sauf que l'image à l'index donné est supprimée
     *
     * @param arr Le tableau à partir duquel supprimer l'image.
     * @param index L'index de l'image que vous souhaitez supprimer.
     * @return Un nouveau tableau avec l'élément à l'index supprimé.
     */
    public static Image[] removeTheImageFromArray(Image[] arr, int index) {
        return Arrays.stream(arr).filter(val -> val != arr[index]).toArray(Image[]::new);
    }

}
