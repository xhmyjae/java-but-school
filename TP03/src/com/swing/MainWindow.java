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
        button1.setPreferredSize(new Dimension(240, 60));
        button1.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        button1.setBackground(Color.decode("#212F45"));
        button1.setForeground(Color.decode("#7F9AB3"));
        button1.setFocusable(false);
        button1.setBorder(BorderFactory.createLineBorder(Color.decode("#212F45")));
        menuPanel.add(button1);
        JButton button2 = new JButton("JButtons");
        button2.setPreferredSize(new Dimension(240, 60));
        button2.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        button2.setBackground(Color.decode("#212F45"));
        button2.setForeground(Color.decode("#7F9AB3"));
        button2.setFocusable(false);
        button2.setBorder(BorderFactory.createLineBorder(Color.decode("#212F45")));
        menuPanel.add(button2);
//        for (int i = 1; i <= 5; i++) {
//            JButton button = new JButton("Button " + i);
//            button.setPreferredSize(new Dimension(240, 50));
//            button.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
//            button.setBackground(Color.decode("#212F45"));
//            button.setForeground(Color.decode("#7F9AB3"));
//            button.setFocusable(false);
//            button.setBorder(BorderFactory.createLineBorder(Color.decode("#212F45")));
//            menuPanel.add(button);
//        }
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
        mainPanel.add(etudiantsPanel, "etudiantsPanel");
        mainPanel.add(jButtonsPanel, "jButtonsPanel");
//        mainPanel.add(ex02Panel, "ex02Panel");

        // Change main panel on menu buttons click
        button1.addActionListener(e -> cardLayout.show(mainPanel, "etudiantsPanel"));
        button2.addActionListener(e -> cardLayout.show(mainPanel, "jButtonsPanel"));

    }
}
