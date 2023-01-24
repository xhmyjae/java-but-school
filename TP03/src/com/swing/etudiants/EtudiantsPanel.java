package com.swing.etudiants;

import com.swing.etudiants.PEtudiant.Etudiant;
import utils.utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public class EtudiantsPanel extends JPanel {

    public EtudiantsPanel() {
        initialize();
    }

    public void initialize() {
        final int[] indexMatiere = {0};
        Map<JTextField, Map<JTextField, JComboBox>> map = new HashMap();

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

            map.put(textFieldMatiere, new HashMap<>());

            JButton buttonNote = new JButton("+ note");
            utils.buttonDesign(buttonNote, panelMatiere, 95, 30);

            final int[] indexNote = {0};

            buttonNote.addActionListener(e1 -> {
                textFieldMatiere.setEnabled(false);
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
                        if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' && l < 2 || ke.getKeyChar() == KeyEvent.VK_BACK_SPACE || ke.getKeyChar() == KeyEvent.VK_DELETE) {
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

                map.get(textFieldMatiere).put(textFieldNote, comboBoxCoef);

                revalidate();
                repaint();
             });

            revalidate();
            repaint();
        });


        JButton buttonValider = new JButton("Valider");
        utils.buttonDesign(buttonValider, panelLeft, 200, 30);
        buttonValider.addActionListener(e -> {
            String nom = textFieldNom.getText();
            String prenom = textFieldPrenom.getText();
            if (Objects.equals(nom, "") || Objects.equals(prenom, "")) {
                JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs", "Erreur", JOptionPane.ERROR_MESSAGE);
            } else {
                Matiere[] matieres = new Matiere[map.size()];
                final int[] i = {0};
                map.forEach((k, v) -> {
                    i[0] += 1;
                    String matiere = k.getText();
                    if (Objects.equals(matiere, "")) {
                        JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs", "Erreur", JOptionPane.ERROR_MESSAGE);
                    } else {
                        Note[] notes = new Note[v.size()];
                        v.forEach((k1, v1) -> {
                            String note = k1.getText();
                            String coef = v1.getSelectedItem().toString();
                            Note note1 = new Note(Double.parseDouble(note), Integer.parseInt(coef));
                            notes[v1.getSelectedIndex()] = note1;

                            if (Objects.equals(note, "")) {
                                JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs", "Erreur", JOptionPane.ERROR_MESSAGE);
                            }
                        });
                        Matiere matiere1 = new Matiere(matiere, notes);
                        matieres[i[0] - 1] = matiere1;
                    }
                });
                Etudiant etudiant = new Etudiant(nom, prenom, matieres);
                // reload page window
                revalidate();
                repaint();
            }
        });

        // right panel
        panelRight.setLayout(new BoxLayout(panelRight, BoxLayout.Y_AXIS));
        panelRight.setBackground(Color.decode("#212F45"));
//        panelRight.setPreferredSize(new Dimension(250, 600));

        JLabel labelEtudiant = new JLabel("Etudiants :");
        labelEtudiant.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        labelEtudiant.setForeground(Color.WHITE);
        panelRight.add(labelEtudiant);


    }
}

