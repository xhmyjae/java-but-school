package com.swing.ex01;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Ex01Panel extends JPanel {

    public Ex01Panel() {
        initialize();
    }

    public void initialize() {
//        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
//        setBackground(Color.BLACK);
//        setPreferredSize(new Dimension(250, 250));
        JPanel panelLeft = new JPanel();
        JPanel panelRight = new JPanel();

        panelLeft.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        panelLeft.setPreferredSize(new Dimension(680, 720));
        panelLeft.setBackground(Color.decode("#272640"));
        JLabel label1 = new JLabel("Ajouter un etudiant :");
        label1.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        label1.setForeground(Color.decode("#7F9AB3"));
        panelLeft.add(label1, gbc);
        JTextField textField1 = new JTextField();
        panelLeft.add(textField1, gbc);
        JLabel label2 = new JLabel("Notes :");
        label2.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        label2.setForeground(Color.decode("#7F9AB3"));
        panelLeft.add(label2, gbc);
        String notes[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"};
        JPanel panelNotes = new JPanel();
        for (int i = 0; i < 5; i++) {
            JComboBox comboBox = new JComboBox(notes);
            comboBox.setPreferredSize(new Dimension(50, 30));
            panelNotes.add(comboBox);
        }
        panelLeft.add(panelNotes, gbc);
        JButton button1 = new JButton("Ajouter");
        button1.setSize(new Dimension(30, 20));
        button1.setMaximumSize(new Dimension(30, 20));
        button1.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        button1.setBackground(Color.decode("#1B3A4B"));
        button1.setForeground(Color.decode("#006466"));
        button1.setFocusable(false);
//        button1.setBorder(BorderFactory.createLineBorder(Color.decode("#212F45")));
        panelLeft.add(button1, gbc);


        // right panel
        panelRight.setLayout(new GridLayout(5, 1, 10, 10));
        panelRight.setPreferredSize(new Dimension(330, 720));
        panelRight.setBackground(Color.decode("#272640"));
        JLabel label3 = new JLabel("Liste de la classe :");
        label3.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        label3.setForeground(Color.decode("#7F9AB3"));
        panelRight.add(label3);

        add(panelLeft);
        add(panelRight);
    }
}
