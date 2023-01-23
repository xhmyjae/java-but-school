package com.swing.etudiants;

import com.swing.etudiants.PEtudiant.Etudiant;
import utils.utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.concurrent.atomic.AtomicReference;

public class EtudiantsPanel extends JPanel {

    public EtudiantsPanel() {
        initialize();
    }

    public void initialize() {
        final int[] indexMatiere = {0};
        JPanel panelLeft = new JPanel();
        JPanel panelRight = new JPanel();

        panelLeft.setLayout(new BoxLayout(panelLeft, BoxLayout.Y_AXIS));
        add(panelLeft);

        JLabel label = new JLabel("Nouveau étudiant :");
        panelLeft.add(label);

        JPanel panelNom = new JPanel();
        panelNom.setLayout(new BoxLayout(panelNom, BoxLayout.X_AXIS));
        panelLeft.add(panelNom);

        JLabel labelNom = new JLabel("Nom :");
        panelNom.add(labelNom);

        JTextField textFieldNom = new JTextField(20);
        panelNom.add(textFieldNom);

        JPanel panelPrenom = new JPanel();
        panelPrenom.setLayout(new BoxLayout(panelPrenom, BoxLayout.X_AXIS));
        panelLeft.add(panelPrenom);

        JLabel labelPrenom = new JLabel("Prénom :");
        panelPrenom.add(labelPrenom);

        JTextField textFieldPrenom = new JTextField(20);
        panelPrenom.add(textFieldPrenom);

        JButton buttonMatiere = new JButton("Ajouter une matière");
        utils.buttonDesign(buttonMatiere, panelLeft, 200, 30);

        buttonMatiere.addActionListener(e -> {
            indexMatiere[0] += 1;
            if (indexMatiere[0] > 2) {
                // disable buttonMatiere
                buttonMatiere.setEnabled(false);
            }
            JPanel panelMatiere = new JPanel();
            panelMatiere.setLayout(new BoxLayout(panelMatiere, BoxLayout.X_AXIS));
            panelLeft.add(panelMatiere);

            JPanel panelMatiereLabel = new JPanel();
            panelMatiereLabel.setLayout(new BoxLayout(panelMatiereLabel, BoxLayout.Y_AXIS));
            panelMatiere.add(panelMatiereLabel);

            JLabel labelMatiere = new JLabel("Matière :");
            panelMatiereLabel.add(labelMatiere);

            JTextField textFieldMatiere = new JTextField(20);
            panelMatiereLabel.add(textFieldMatiere);

            JButton buttonNote = new JButton("+ note");
            utils.buttonDesign(buttonNote, panelMatiere, 100, 30);

            final int[] indexNote = {0};

            buttonNote.addActionListener(e1 -> {
                indexNote[0] += 1;
                if (indexNote[0] > 2) {
                    // disable buttonNote
                    buttonNote.setEnabled(false);
                }
                JPanel panelNote = new JPanel();
                panelNote.setLayout(new BoxLayout(panelNote, BoxLayout.X_AXIS));
                panelMatiere.add(panelNote);

                JPanel panelNoteLabel = new JPanel();
                panelNoteLabel.setLayout(new BoxLayout(panelNoteLabel, BoxLayout.Y_AXIS));
                panelNote.add(panelNoteLabel);

                JLabel labelNote = new JLabel("Note :");
                panelNoteLabel.add(labelNote);

                JTextField textFieldNote = new JTextField(2);
                panelNoteLabel.add(textFieldNote);
                textFieldNote.addKeyListener(new KeyAdapter() {
                    public void keyPressed(KeyEvent ke) {
                        String value = textFieldNote.getText();
                        int l = value.length();
                        if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' && l < 2) {
                            textFieldNote.setEditable(true);
                        } else {
                            textFieldNote.setEditable(false);
                        }
                    }
                });

                JLabel labelCoef = new JLabel("Coef :");
                panelNoteLabel.add(labelCoef);

                JComboBox comboBoxCoef = new JComboBox("123456789".split(""));
                panelNoteLabel.add(comboBoxCoef);

                revalidate();
                repaint();
            });

            revalidate();
            repaint();
        });


        JButton buttonValider = new JButton("Valider");
        utils.buttonDesign(buttonValider, panelLeft, 200, 30);
        buttonValider.addActionListener(e -> {
            // get the notes of the first matiere
            // get all panelMatiere
            Component[] components = panelLeft.getComponents();
            Component[] componentsMatiere = new Component[3];
            for (Component component : components) {
                // if component name is panelMatiere add to array
                if (component.getName() != null && component.getName().equals("panelMatiere")) {
                    componentsMatiere[indexMatiere[0]] = component;
                    indexMatiere[0] += 1;
                    for (Component componentNote : component.getComponents() ) {

                }
            }

            }
            // get the first panelMatiere
            JPanel panelMatiere = (JPanel) components[4];
            // get all panelNote
            Component[] components1 = panelMatiere.getComponents();
            // get the first panelNote
            JPanel panelNote = (JPanel) components1[1];
            // get all panelNoteLabel


            JPanel panelMatiere = (JPanel) panelLeft.getComponent(4);
            JPanel panelNote = (JPanel) panelMatiere.getComponent(1);
            JPanel panelNoteLabel = (JPanel) panelNote.getComponent(0);
            // make matiere class
            for (int i = 0; i < indexMatiere[0]; i++) {
                for (int j = 0; j < indexNote[0]; j++) {
                    // make note class
                }
            }
//            Etudiant etudiant = new Etudiant(textFieldNom.getText(), textFieldPrenom.getText());
//            System.out.println(etudiant);
        });
    }




//
//        panelLeft.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
//        panelLeft.setPreferredSize(new Dimension(680, 720));
//        panelLeft.setBackground(Color.decode("#272640"));
//
//        JLabel label1 = new JLabel("Ajouter un etudiant :");
//        label1.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
//        label1.setForeground(Color.decode("#7F9AB3"));
//        panelLeft.add(label1);
//
//        JPanel panel1 = new JPanel();
//        panel1.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
//        panel1.setPreferredSize(new Dimension(650, 50));
//        panel1.setBackground(Color.decode("#272640"));
//        JLabel label2 = new JLabel("Nom :");
//        label2.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
//        label2.setForeground(Color.decode("#7F9AB3"));
//        JTextField textField1 = new JTextField(20);
//        panel1.add(label2);
//        panel1.add(textField1);
//        panelLeft.add(panel1);
//
//        JPanel panel2 = new JPanel();
//        panel2.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
//        panel2.setPreferredSize(new Dimension(650, 50));
//        panel2.setBackground(Color.decode("#272640"));
//        JLabel label3 = new JLabel("Prenom :");
//        label3.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
//        label3.setForeground(Color.decode("#7F9AB3"));
//        JTextField textField2 = new JTextField(20);
//        panel2.add(label3);
//        panel2.add(textField2);
//        panelLeft.add(panel2);
//
//        JLabel label4 = new JLabel("Notes :");
//        label4.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
//        label4.setForeground(Color.decode("#7F9AB3"));
//        panelLeft.add(label4);
//
//
//
//        Matiere[] matieres = new Matiere[3];
//
//        JPanel panel3 = new JPanel();
//        panel3.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
//        panel3.setBackground(Color.decode("#272640"));
//        panelLeft.add(panel3);
//
//        for (int i = 0; i < matieres.length; i++) {
//            matieres[i] = addMatiere(panel3);
//        }
//
//        JButton button4 = new JButton("Ajouter l'eleve");
//        button4.setPreferredSize(new Dimension(200, 30));
//        panelLeft.add(button4);
//        button4.addActionListener(e -> {
//            Etudiant etudiant = new Etudiant(textField1.getText(), textField2.getText(), matieres);
//            etudiant.saveStudent();
//        });
//
//
//
////      right panel
//
//
//        add(panelLeft);
//        add(panelRight);
//    }
//
//    private Matiere addMatiere(JPanel mainPanel) {
//        Note[] notes = new Note[3];
//        // create panel
//        JPanel panel = new JPanel();
//        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
//        panel.setBackground(Color.decode("#272640"));
//        // create label
//        JLabel label = new JLabel("Matiere :");
//        label.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
//        label.setForeground(Color.decode("#7F9AB3"));
//        // create text field
//        JTextField textField = new JTextField(20);
//        // add label and text field to panel
//        panel.add(label);
//        panel.add(textField);
//
//        // button
//        JPanel notesPanel = new JPanel();
//        notesPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
//
//        for (int i = 0; i < notes.length; i++) {
//            notes[i] = addNote(notesPanel);
//        }
//        mainPanel.add(panel);
//        mainPanel.add(notesPanel);
//        revalidate();
//        repaint();
//        return new Matiere(textField.getText(), notes);
//    }
//
//    private Note addNote(JPanel panel) {
//        AtomicReference<Note> note = new AtomicReference<>();
//        // create label
//        JPanel notePanel = new JPanel();
//        JLabel label = new JLabel("Note :");
//        label.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
//        label.setForeground(Color.decode("#7F9AB3"));
//        // create text field
//        JTextField textField = new JTextField(2);
//        // add coef
//        JLabel label2 = new JLabel("Coef :");
//        label2.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
//        label2.setForeground(Color.decode("#7F9AB3"));
//        // create text field
//        JComboBox comboBox = new JComboBox("123456789".split(""));
//        // add label and text field to panel
//        notePanel.add(label);
//        notePanel.add(textField);
//        notePanel.add(label2);
//        notePanel.add(comboBox);
//        panel.add(notePanel);
//        revalidate();
//        repaint();
//
//        JButton button = new JButton("+");
//        button.setPreferredSize(new Dimension(30, 30));
//        panel.add(button);
//
//        button.addActionListener(e -> {
//            note.set(new Note(Double.parseDouble(textField.getText()), Integer.parseInt(comboBox.getSelectedItem().toString())));
//        });
//
//        return note.get();
//    }
}
