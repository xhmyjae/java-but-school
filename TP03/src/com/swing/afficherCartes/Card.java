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

    public static URL[] getCardsImages() throws IOException {
//        URL url = new URL("https://deckofcardsapi.com/api/deck/new/shuffle/?deck_count=1");
//        String info = Requester.Requester(url);
//        String deck_id = info.substring(info.indexOf("deck_id") + 10, info.indexOf("remaining") - 3);

        URL url2 = new URL("https://deckofcardsapi.com/api/deck/new/draw/?count=52");
        String info2 = Requester.Requester(url2);
        URL[] links = new URL[52];
        for (int i = 0; i < 52; i++) {
            String link = info2.substring(info2.indexOf("image") + 8, info2.indexOf("images") - 3);
            links[i] = new URL(link);
            info2 = info2.substring(info2.indexOf("images") + 8);
            // convert string to url
            // remove https from link
            System.out.println(links[i]);
        }
        return links;
    }

    public static String[] removeLinkFromArray(String[] links, int index) {
        String[] newLinks = new String[links.length - 1];
        for (int i = 0; i < links.length; i++) {
            if (i < index) {
                newLinks[i] = links[i];
            } else if (i > index) {
                newLinks[i - 1] = links[i];
            }
        }
        return newLinks;
    }

    public static Image[] removeTheImageFromArray(Image[] arr, int index) {
        if (arr == null || index < 0 || index >= arr.length) {
            return arr;
        }
        Image[] anotherArray = new Image[arr.length - 1];
        for (int i = 0, k = 0; i < arr.length; i++) {
            if (i == index) {
                continue;
            }
            anotherArray[k++] = arr[i];
        }
        return anotherArray;
    }
}
