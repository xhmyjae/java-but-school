package com.swing.carteMagie;

import com.swing.yugioh.MagiePiege;
import utils.utils;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class CarteMagiePanel extends JPanel {
    public CarteMagiePanel() {
        initialize();
    }

    public void initialize() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        setBackground(Color.decode("#272640"));
        setPreferredSize(new Dimension(1024, 720));

        MagiePiege magiePiege = MagiePiege.generateRandomMagiePiegeCard();

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBackground(Color.decode("#272640"));
        leftPanel.setBounds(10, 10, 700, 600);
        add(leftPanel);

        JPanel nomPanel = new JPanel();
        nomPanel.setLayout(new BoxLayout(nomPanel, BoxLayout.X_AXIS));
        JLabel nomLabel = new JLabel("Nom : ");
        nomLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        nomLabel.setForeground(Color.decode("#7F9AB3"));
        nomPanel.add(nomLabel);
        JLabel nom = new JLabel(magiePiege.getNom());
        nom.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        nom.setForeground(Color.decode("#7F9AB3"));
        nomPanel.add(nom);
        leftPanel.add(nomPanel);

        JPanel numeroPanel = new JPanel();
        numeroPanel.setLayout(new BoxLayout(numeroPanel, BoxLayout.X_AXIS));
        JLabel numeroLabel = new JLabel("Numéro : ");
        numeroLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        numeroLabel.setForeground(Color.decode("#7F9AB3"));
        numeroPanel.add(numeroLabel);
        JLabel numero = new JLabel(magiePiege.getNumero());
        numero.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        numero.setForeground(Color.decode("#7F9AB3"));
        numeroPanel.add(numero);
        leftPanel.add(numeroPanel);

        JPanel descriptionPanel = new JPanel();
        descriptionPanel.setLayout(new BoxLayout(descriptionPanel, BoxLayout.X_AXIS));
        JLabel descriptionLabel = new JLabel("Description : ");
        descriptionLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        descriptionLabel.setForeground(Color.decode("#7F9AB3"));
        descriptionPanel.add(descriptionLabel);
        JLabel description = new JLabel(magiePiege.getDescription());
        description.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        description.setForeground(Color.decode("#7F9AB3"));
        descriptionPanel.add(description);
        leftPanel.add(descriptionPanel);

        JPanel typePanel = new JPanel();
        typePanel.setLayout(new BoxLayout(typePanel, BoxLayout.X_AXIS));
        JLabel typeLabel = new JLabel("Type : ");
        typeLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        typeLabel.setForeground(Color.decode("#7F9AB3"));
        typePanel.add(typeLabel);
        JLabel type = new JLabel(String.valueOf(magiePiege.getType()));
        type.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        type.setForeground(Color.decode("#7F9AB3"));
        typePanel.add(type);
        leftPanel.add(typePanel);

        JPanel iconePanel = new JPanel();
        iconePanel.setLayout(new BoxLayout(iconePanel, BoxLayout.X_AXIS));
        JLabel iconeLabel = new JLabel("Icone : ");
        iconeLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        iconeLabel.setForeground(Color.decode("#7F9AB3"));
        iconePanel.add(iconeLabel);
        JLabel icone = new JLabel();
        icone.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        icone.setForeground(Color.decode("#7F9AB3"));
        iconePanel.add(icone);
        leftPanel.add(iconePanel);



        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new FlowLayout());
        rightPanel.setBackground(Color.decode("#272640"));
        rightPanel.setBounds(520, 10, 700, 60);
        add(rightPanel);

        JButton changeCarte = new JButton("Changer de carte");
        utils.buttonDesign(changeCarte, rightPanel, 200, 50);
        changeCarte.addActionListener(e -> {
            removeAll();
            initialize();
            revalidate();
            repaint();
        });

        JButton save = new JButton("Sauvegarder");
        utils.buttonDesign(save, rightPanel, 200, 50);
        System.out.println(magiePiege.hasBeenSaved());
        if (magiePiege.hasBeenSaved()) {
            save.setEnabled(false);
        } else {
            save.addActionListener(e -> {
                try {
                    magiePiege.saveCarte(magiePiege.getNumero());
                    save.setEnabled(false);
                    removeAll();
                    initialize();
                    revalidate();
                    repaint();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            });
        }

        JComboBox<String> comboBox = new JComboBox<String>();
        for (File file : new File("src/com/swing/yugioh/savedCartes/").listFiles()) {
            if (Objects.equals(utils.cardTypeFromFile(file), "MagiePiege")) {
                comboBox.addItem(file.getName());
            }
        }
        rightPanel.add(comboBox);
    }
}
