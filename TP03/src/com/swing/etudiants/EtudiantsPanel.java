package com.swing.etudiants;

import com.swing.etudiants.PEtudiant.Etudiant;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

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

        Matiere[] matieres = new Matiere[3];

        // button
        JButton button = new JButton("+ matiere");
        button.setPreferredSize(new Dimension(100, 30));
        panelLeft.add(button);
        button.addActionListener(e -> {
            matieres[matieres.length - 1] = addMatiere(panelLeft);
        });
        matieres[0] = addMatiere(panelLeft);

        JButton button4 = new JButton("Ajouter l'eleve");
        button4.setPreferredSize(new Dimension(200, 30));
        panelLeft.add(button4);
        button4.addActionListener(e -> {
            Etudiant etudiant = new Etudiant(textField1.getText(), textField2.getText(), matieres);
//            etudiant.setNote(null);
        });


//      right panel


        add(panelLeft);
        add(panelRight);
    }

    private Matiere addMatiere(JPanel mainPanel) {
        Note[] notes = new Note[3];
        Note[] newNote;
        // create panel
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
//        panel.setPreferredSize(new Dimension(650));
        panel.setBackground(Color.decode("#272640"));
        // create label
        JLabel label = new JLabel("Matiere :");
        label.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        label.setForeground(Color.decode("#7F9AB3"));
        // create text field
        JTextField textField = new JTextField(20);
        // add label and text field to panel
        panel.add(label);
        panel.add(textField);
        // button
        JPanel notesPanel = new JPanel();
        notesPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
        JButton button = new JButton("+");
        button.setPreferredSize(new Dimension(50, 30));
        panel.add(button);
        button.addActionListener(e -> {
            // add addNote to notes
            notes[notes.length - 1] = addNote(notesPanel);
        });
        notes[0] = addNote(notesPanel);
        mainPanel.add(panel);
        mainPanel.add(notesPanel);
        revalidate();
        repaint();
        return new Matiere(textField.getText(), notes);
    }

    private Note addNote(JPanel panel) {
        // create label
        JPanel notePanel = new JPanel();
        JLabel label = new JLabel("Note :");
        label.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        label.setForeground(Color.decode("#7F9AB3"));
        // create text field
        JTextField textField = new JTextField(2);
        // add coef
        JLabel label2 = new JLabel("Coef :");
        label2.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        label2.setForeground(Color.decode("#7F9AB3"));
        // create text field
        JTextField textField2 = new JTextField(2);
        // add label and text field to panel
        notePanel.add(label);
        notePanel.add(textField);
        notePanel.add(label2);
        notePanel.add(textField2);
        panel.add(notePanel);
        revalidate();
        repaint();

        return null;
//        return new Note(Double.parseDouble(textField.getText()), Integer.parseInt(textField2.getText()));
    }
}
