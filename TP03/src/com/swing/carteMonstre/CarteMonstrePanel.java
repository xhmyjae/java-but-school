package com.swing.carteMonstre;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

import com.swing.yugioh.*;
import utils.utils;

public class CarteMonstrePanel extends JPanel {

    public CarteMonstrePanel() {
        initialize();
    }

    public void initialize() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        setBackground(Color.decode("#272640"));
        setPreferredSize(new Dimension(1024, 720));

        Monstre monstre = Monstre.generateRandomMonsterCard();

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
        JLabel nom = new JLabel(monstre.getNom());
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
        JLabel numero = new JLabel(monstre.getNumero());
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
        JLabel description = new JLabel(monstre.getDescription());
        description.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        description.setForeground(Color.decode("#7F9AB3"));
        descriptionPanel.add(description);
        leftPanel.add(descriptionPanel);

        JPanel niveauPanel = new JPanel();
        niveauPanel.setLayout(new BoxLayout(niveauPanel, BoxLayout.X_AXIS));
        JLabel niveauLabel = new JLabel("Niveau : ");
        niveauLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        niveauLabel.setForeground(Color.decode("#7F9AB3"));
        niveauPanel.add(niveauLabel);
        JLabel niveau = new JLabel(monstre.getNiveau().toString());
        niveau.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        niveau.setForeground(Color.decode("#7F9AB3"));
        niveauPanel.add(niveau);
        leftPanel.add(niveauPanel);

        JPanel attributPanel = new JPanel();
        attributPanel.setLayout(new BoxLayout(attributPanel, BoxLayout.X_AXIS));
        JLabel attributLabel = new JLabel("Attribut : ");
        attributLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        attributLabel.setForeground(Color.decode("#7F9AB3"));
        attributPanel.add(attributLabel);
        JLabel attribut = new JLabel(monstre.getAttribut().toString());
        attribut.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        attribut.setForeground(Color.decode("#7F9AB3"));
        attributPanel.add(attribut);
        leftPanel.add(attributPanel);

        JPanel typePanel = new JPanel();
        typePanel.setLayout(new BoxLayout(typePanel, BoxLayout.X_AXIS));
        JLabel typeLabel = new JLabel("Type : ");
        typeLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        typeLabel.setForeground(Color.decode("#7F9AB3"));
        typePanel.add(typeLabel);
        JLabel type = new JLabel(monstre.getType());
        type.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        type.setForeground(Color.decode("#7F9AB3"));
        typePanel.add(type);
        leftPanel.add(typePanel);

        JPanel attaquePanel = new JPanel();
        attaquePanel.setLayout(new BoxLayout(attaquePanel, BoxLayout.X_AXIS));
        JLabel attaqueLabel = new JLabel("Attaque : ");
        attaqueLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        attaqueLabel.setForeground(Color.decode("#7F9AB3"));
        attaquePanel.add(attaqueLabel);
        JLabel attaque = new JLabel(monstre.getAtk().toString());
        attaque.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        attaque.setForeground(Color.decode("#7F9AB3"));
        attaquePanel.add(attaque);
        leftPanel.add(attaquePanel);

        JPanel defensePanel = new JPanel();
        defensePanel.setLayout(new BoxLayout(defensePanel, BoxLayout.X_AXIS));
        JLabel defenseLabel = new JLabel("Défense : ");
        defenseLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        defenseLabel.setForeground(Color.decode("#7F9AB3"));
        defensePanel.add(defenseLabel);
        JLabel defense = new JLabel(monstre.getDef().toString());
        defense.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        defense.setForeground(Color.decode("#7F9AB3"));
        defensePanel.add(defense);
        leftPanel.add(defensePanel);

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
        System.out.println(monstre.hasBeenSaved());
        if (monstre.hasBeenSaved()) {
            save.setEnabled(false);
        } else {
            save.addActionListener(e -> {
                try {
                    monstre.saveCarte(monstre.getNumero());
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
            if (Objects.equals(utils.cardTypeFromFile(file), "Monstre")) {
                comboBox.addItem(file.getName());
            }
        }
        rightPanel.add(comboBox);
    }
}
