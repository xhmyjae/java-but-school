package com.swing.afficherCartes;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
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
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        setPreferredSize(new Dimension(800, 600));

        new Card();
        final String[][] cardsLinks = {Card.getCardsImages()};

        JPanel cardsPanel = new JPanel();
        cardsPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        cardsPanel.setPreferredSize(new Dimension(800, 600));

        JButton button = new JButton("Afficher une carte");
        utils.buttonDesign(button, this, 230, 60);
        button.addActionListener(e -> {
            // add a random card from array
            int random = (int) (Math.random() * cardsLinks[0].length);
            try {
                URL url = null;
                try {
                    url = new URL(cardsLinks[0][random]);
                } catch (MalformedURLException malformedURLException) {
                    malformedURLException.printStackTrace();
                }
                BufferedImage image = ImageIO.read(url);
                System.out.println(cardsLinks[0][random]);
                JLabel label = new JLabel(new ImageIcon(image));
                label.setPreferredSize(new Dimension(100, 150));
                cardsPanel.add(label);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            // remove card from cardsLinks array
            cardsLinks[0] = Card.removeLinkFromArray(cardsLinks[0], random);
        });
        add(cardsPanel);
        add(button);

        JLabel label = new JLabel("Nombre de cartes restantes: " + cardsLinks[0].length);
        label.setForeground(Color.decode("#7F9AB3"));
        label.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        add(label);

//        add(new JLabel(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/icon1.png"))).getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH))));
    }

}
