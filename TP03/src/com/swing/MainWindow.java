package com.swing;

import javax.swing.*;
import java.awt.*;

import com.swing.etudiants.EtudiantsPanel;
import com.swing.jbuttons.JButtonsPanel;

public class MainWindow {

    private JFrame frame;

    public MainWindow() {
        initialize();
    }

    public void initialize() {
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

    public void menu() {
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
        frame.add(menuPanel, BorderLayout.WEST);

        // Main panel
        CardLayout cardLayout = new CardLayout();
        cardLayout.setHgap(0);
        cardLayout.setVgap(0);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(cardLayout);
        mainPanel.setPreferredSize(new Dimension(1020, 720));
        mainPanel.setBackground(Color.decode("#272640"));
        frame.add(mainPanel);

        EtudiantsPanel etudiantsPanel = new EtudiantsPanel();
        JButtonsPanel jButtonsPanel = new JButtonsPanel();
        etudiantsPanel.setBackground(Color.decode("#272640"));
        jButtonsPanel.setBackground(Color.decode("#272640"));
        mainPanel.add(etudiantsPanel, "etudiantsPanel");
        mainPanel.add(jButtonsPanel, "jButtonsPanel");

        // Change main panel on menu buttons click
        button1.addActionListener(e -> cardLayout.show(mainPanel, "etudiantsPanel"));
        button2.addActionListener(e -> cardLayout.show(mainPanel, "jButtonsPanel"));

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
