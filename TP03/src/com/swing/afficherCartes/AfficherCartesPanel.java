package com.swing.afficherCartes;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

import utils.utils;

public class AfficherCartesPanel extends JPanel {

    public AfficherCartesPanel() {
        initialize();
    }

    public void initialize() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        setPreferredSize(new Dimension(800, 600));

        final List cards;

        final Image[][] allCards = {new Card().getImages()};

        JPanel cardsPanel = new JPanel();
        cardsPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        cardsPanel.setPreferredSize(new Dimension(800, 600));

        JButton button = new JButton("Afficher une carte");
        utils.buttonDesign(button, this, 230, 60);
        button.addActionListener(e -> {
            // add a random card to the panel
            Image card = new Card().getRandomCard(allCards[0]);
            // display it in cardsPanel
            JLabel label = new JLabel();
            label.setIcon(new ImageIcon(card));
            label.setPreferredSize(new Dimension(100, 150));
            // remove it from allCards
            allCards[0] = new Card().removeCard(card, allCards[0]);

//            add(new JLabel(new ImageIcon(randomCard == null ? null : randomCard.getScaledInstance(100, 150, Image.SCALE_SMOOTH))));
//            allCards[0] = new Card().removeCard(randomCard, allCards[0]);
        });
        add(cardsPanel);
        add(button);

        JLabel label = new JLabel("Nombre de cartes restantes: " + allCards[0].length);
        label.setForeground(Color.decode("#7F9AB3"));
        label.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        add(label);

//        add(new JLabel(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/icon1.png"))).getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH))));
    }

}
