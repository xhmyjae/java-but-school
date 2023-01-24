package com.swing;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import com.swing.afficherCartes.AfficherCartesPanel;
import com.swing.boxlayout.BoxLayoutPanel;
import com.swing.carteMagie.CarteMagiePanel;
import com.swing.carteMonstre.CarteMonstrePanel;
import com.swing.etudiants.EtudiantsPanel;
import com.swing.jbuttons.JButtonsPanel;

public class MainWindow {

    private JFrame frame;

    public MainWindow() throws IOException {
        initialize();
    }

    public void initialize() throws IOException {
        frame = new JFrame();
        frame.setTitle("TP 03");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(1280, 720);
        frame.setResizable(false);
        frame.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setBackground(Color.decode("#272640"));
        menu();
    }

    public void menu() throws IOException {
        // Menu panel
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        menuPanel.setBackground(Color.decode("#212F45"));
        menuPanel.setPreferredSize(new Dimension(240,720));
        // Menu buttons
        JButton button1 = new JButton("Etudiants");
        menuButtonDesign(menuPanel, button1);
        JButton button2 = new JButton("JButtons");
        menuButtonDesign(menuPanel, button2);
        JButton button3 = new JButton("BoxLayout");
        menuButtonDesign(menuPanel, button3);
        JButton button4 = new JButton("Afficher cartes");
        menuButtonDesign(menuPanel, button4);
        JButton button5 = new JButton("Cartes monstre");
        menuButtonDesign(menuPanel, button5);
        JButton button6 = new JButton("Cartes magie piege");
        menuButtonDesign(menuPanel, button6);
        frame.add(menuPanel, BorderLayout.WEST);

        // Main panel
        CardLayout cardLayout = new CardLayout();
        cardLayout.setHgap(0);
        cardLayout.setVgap(0);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(cardLayout);
        mainPanel.setPreferredSize(new Dimension(1024, 720));
        mainPanel.setBackground(Color.decode("#272640"));
        frame.add(mainPanel);

        EtudiantsPanel etudiantsPanel = new EtudiantsPanel();
        JButtonsPanel jButtonsPanel = new JButtonsPanel();
        BoxLayoutPanel boxLayoutPanel = new BoxLayoutPanel();
        AfficherCartesPanel afficherCartesPanel = new AfficherCartesPanel();
        CarteMonstrePanel carteMonstrePanel = new CarteMonstrePanel();
        CarteMagiePanel carteMagiePanel = new CarteMagiePanel();
        etudiantsPanel.setBackground(Color.decode("#272640"));
        jButtonsPanel.setBackground(Color.decode("#272640"));
        boxLayoutPanel.setBackground(Color.decode("#272640"));
        afficherCartesPanel.setBackground(Color.decode("#272640"));
        carteMonstrePanel.setBackground(Color.decode("#272640"));
        carteMagiePanel.setBackground(Color.decode("#272640"));
        mainPanel.add(etudiantsPanel, "etudiantsPanel");
        mainPanel.add(jButtonsPanel, "jButtonsPanel");
        mainPanel.add(boxLayoutPanel, "boxLayoutPanel");
        mainPanel.add(afficherCartesPanel, "afficherCartesPanel");
        mainPanel.add(carteMonstrePanel, "carteMonstrePanel");
        mainPanel.add(carteMagiePanel, "carteMagiePanel");

        button1.addActionListener(e -> cardLayout.show(mainPanel, "etudiantsPanel"));
        button2.addActionListener(e -> cardLayout.show(mainPanel, "jButtonsPanel"));
        button3.addActionListener(e -> cardLayout.show(mainPanel, "boxLayoutPanel"));
        button4.addActionListener(e -> cardLayout.show(mainPanel, "afficherCartesPanel"));
        button5.addActionListener(e -> cardLayout.show(mainPanel, "carteMonstrePanel"));
        button6.addActionListener(e -> cardLayout.show(mainPanel, "carteMagiePanel"));
    }

    private void menuButtonDesign(JPanel menuPanel, JButton button) {
        button.setPreferredSize(new Dimension(240, 60));
        button.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        button.setBackground(Color.decode("#212F45"));
        button.setForeground(Color.decode("#7F9AB3"));
        button.setFocusable(false);
        button.setBorder(BorderFactory.createLineBorder(Color.decode("#212F45")));
        menuPanel.add(button);
    }
}
