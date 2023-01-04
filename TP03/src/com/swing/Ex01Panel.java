package com.swing;

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

        panelLeft.setLayout(new GridLayout(5, 1, 5, 5));
        panelLeft.setPreferredSize(new Dimension(700, 720));
        panelLeft.setBackground(Color.decode("#272640"));
        JLabel label1 = new JLabel("Ajouter un etudiant :");
        label1.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        panelLeft.add(label1);
        JTextField textField1 = new JTextField();
        panelLeft.add(textField1);

        add(panelLeft);
//        add(panelRight);
    }
}
