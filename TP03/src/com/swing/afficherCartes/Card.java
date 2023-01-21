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

    public static Image[] removeTheImageFromArray(Image[] arr, int index) {
        // return array without the image at index
        return Arrays.stream(arr).filter(val -> val != arr[index]).toArray(Image[]::new);

//        // make new array
//        Image[] newArr = new Image[arr.length - 1];
//        // copy all elements before index
//        if (index >= 0) System.arraycopy(arr, 0, newArr, 0, index);
//        // copy all elements after index
//        if (arr.length - (index + 1) >= 0)
//            System.arraycopy(arr, index + 1, newArr, index + 1 - 1, arr.length - (index + 1));
//        return newArr;

//        if (arr == null || index < 0 || index >= arr.length) {
//            return arr;
//        }
//        Image[] anotherArray = new Image[arr.length - 1];
//        for (int i = 0, k = 0; i < arr.length; i++) {
//            if (i == index) {
//                continue;
//            }
//            anotherArray[k++] = arr[i];
//        }
//        return anotherArray;
    }

}
