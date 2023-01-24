package com.swing.jbuttons;

import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.*;

import utils.utils;

public class JButtonsPanel extends JPanel {

    public JButtonsPanel() {
        initialize();
    }

    /**
     * Il crée deux boutons, l'un avec un texte simple et l'autre avec une icône et un texte
     */
    public void initialize() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        setPreferredSize(new Dimension(1020, 720));
        JButton button1 = new JButton("Button simple");
        utils.buttonDesign(button1, this, 230, 60);
        ImageIcon icon = new ImageIcon(createImageIcon("/resources/icon1.png", "icon1").getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));
        JButton button2 = new JButton("Button fantaisie", icon);
        utils.buttonDesign(button2, this, 230, 60);

        button1.addActionListener(e -> {
            showMessage(this, button1);
        });
        button2.addActionListener(e -> {
            showMessage(this, button2);
        });
    }

    /**
     * Si le chemin n'est pas nul, renvoie l'icône de l'image, sinon imprime un message d'erreur
     *
     * @param path Le chemin d'accès au fichier image.
     * @param description La description de l'image.
     * @return Un objet ImageIcon.
     */
    protected ImageIcon createImageIcon(String path, String description) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    /**
     * Il affiche une boîte de dialogue de message avec le texte du bouton qui a été cliqué
     *
     * @param panel Le panneau sur lequel se trouve le bouton.
     * @param button le bouton qui a été cliqué
     */
    private void showMessage(JPanel panel, JButton button) {
        if (button.getText().equals("Button fantaisie")) {
            button.setIcon(new ImageIcon(createImageIcon("/resources/icon2.png", "icon2").getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH)));
            JOptionPane.showMessageDialog(panel, "Vous avez cliqué sur : " + button.getText());
            button.setIcon(new ImageIcon(createImageIcon("/resources/icon1.png", "icon1").getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH)));
        } else {
            JOptionPane.showMessageDialog(panel, "Vous avez cliqué sur : " + button.getText());
        }
    }

}
