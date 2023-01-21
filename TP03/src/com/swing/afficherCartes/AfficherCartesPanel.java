package com.swing.afficherCartes;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLOutput;
import java.util.Objects;

import utils.utils;

public class AfficherCartesPanel extends JPanel {

    public AfficherCartesPanel() throws IOException {
        initialize();
    }

    public void initialize() throws IOException {
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(800, 600));

//        new Card();
//        final String[][] cardsLinks = {Card.getCardsImages()};
        final Image[][] cardsImages = {Card.getCardsImages()};


        JLabel labelLength = new JLabel("Nombre de cartes restantes: " + cardsImages[0].length);
        labelLength.setForeground(Color.decode("#7F9AB3"));
        labelLength.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        add(labelLength);

        JPanel cardsPanel = new JPanel();
        cardsPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        cardsPanel.setPreferredSize(new Dimension(780, 585));

        JButton button = new JButton("Afficher une carte");
        utils.buttonDesign(button, this, 230, 60);
        button.addActionListener(e -> {
            // add a random card from array
            int randomIndex = (int) (Math.random() * cardsImages[0].length);
            // add image and resize it to 70x31
            JLabel label = new JLabel(new ImageIcon(cardsImages[0][randomIndex].getScaledInstance(65, 110, Image.SCALE_SMOOTH)));
            cardsPanel.add(label);
            cardsPanel.revalidate();
            cardsPanel.repaint();
            // remove the card from array
            cardsImages[0] = Card.removeTheImageFromArray(cardsImages[0], randomIndex);
            if (cardsImages[0].length == 0) {
                button.setEnabled(false);
            }
            labelLength.setText("Nombre de cartes restantes: " + cardsImages[0].length);
        });
        add(cardsPanel);
        add(button);

        // number of cards not null in array cardsImages

//        JLabel label = new JLabel("Nombre de cartes restantes: " + cardsImages[0].length);
//        label.setForeground(Color.decode("#7F9AB3"));
//        label.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
//        add(label);

//        add(new JLabel(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/icon1.png"))).getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH))));
    }

}
