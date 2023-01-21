package com.swing.etudiants;

import javax.swing.*;
import java.awt.*;

public class EtudiantsPanel extends JPanel {

    public EtudiantsPanel() {
        initialize();
    }

    public void initialize() {
//        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
//        setBackground(Color.BLACK);
//        setPreferredSize(new Dimension(250, 250));
        JPanel panelLeft = new JPanel();
        JPanel panelRight = new JPanel();

        panelLeft.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
        panelLeft.setPreferredSize(new Dimension(680, 720));
        panelLeft.setBackground(Color.decode("#272640"));

        JLabel label1 = new JLabel("Ajouter un etudiant :");
        label1.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        label1.setForeground(Color.decode("#7F9AB3"));
        panelLeft.add(label1);

        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
        panel1.setPreferredSize(new Dimension(650, 50));
        panel1.setBackground(Color.decode("#272640"));
        JLabel label2 = new JLabel("Nom :");
        label2.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        label2.setForeground(Color.decode("#7F9AB3"));
        JTextField textField1 = new JTextField(20);
        panel1.add(label2);
        panel1.add(textField1);
        panelLeft.add(panel1);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
        panel2.setPreferredSize(new Dimension(650, 50));
        panel2.setBackground(Color.decode("#272640"));
        JLabel label3 = new JLabel("Prenom :");
        label3.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        label3.setForeground(Color.decode("#7F9AB3"));
        JTextField textField2 = new JTextField(20);
        panel2.add(label3);
        panel2.add(textField2);
        panelLeft.add(panel2);

        JLabel label4 = new JLabel("Notes :");
        label4.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        label4.setForeground(Color.decode("#7F9AB3"));
        panelLeft.add(label4);

        JPanel panel3 = new JPanel();
        panel3.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
        panel3.setPreferredSize(new Dimension(650, 50));
        panel3.setBackground(Color.decode("#272640"));
        JLabel label5 = new JLabel("Matiere :");
        label5.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        label5.setForeground(Color.decode("#7F9AB3"));
        JTextField textField3 = new JTextField(20);
        panel3.add(label5);
        panel3.add(textField3);
        JLabel label6 = new JLabel("Note :");
        label6.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        label6.setForeground(Color.decode("#7F9AB3"));
        JTextField textField4 = new JTextField(2);
        panel3.add(label6);
        panel3.add(textField4);
        JLabel label7 = new JLabel("Coef :");
        label7.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        label7.setForeground(Color.decode("#7F9AB3"));
        JTextField textField5 = new JTextField(2);
        panel3.add(label7);
        panel3.add(textField5);
        JButton button1 = new JButton("+");
        button1.setPreferredSize(new Dimension(50, 30));
        panel3.add(button1);
        button1.addActionListener(e -> {
            JLabel label8 = new JLabel("Note :");
            label6.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
            label6.setForeground(Color.decode("#7F9AB3"));
            JTextField textField6 = new JTextField(2);
            panel3.add(label8);
            panel3.add(textField6);
            JLabel label9 = new JLabel("Coef :");
            label7.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
            label7.setForeground(Color.decode("#7F9AB3"));
            JTextField textField7 = new JTextField(2);
            panel3.add(label9);
            panel3.add(textField7);
        });
        panelLeft.add(panel3);




//        // right panel
//        panelRight.setLayout(new GridLayout(5, 1, 10, 10));
//        panelRight.setPreferredSize(new Dimension(330, 720));
//        panelRight.setBackground(Color.decode("#272640"));
//        JLabel label3 = new JLabel("Liste de la classe :");
//        label3.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
//        label3.setForeground(Color.decode("#7F9AB3"));
//        panelRight.add(label3);

        add(panelLeft);
        add(panelRight);
    }
}
