package com.swing.jbuttons;

import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.*;

import utils.utils;

public class JButtonsPanel extends JPanel {

    public JButtonsPanel() {
        initialize();
    }

    public void initialize() {
        // center buttons in panel
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

//    private void buttonDesign(JButton button) {
//        button.setPreferredSize(new Dimension(230, 60));
//        button.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
//        button.setBackground(Color.decode("#1C1E26"));
//        button.setForeground(Color.decode("#7F9AB3"));
//        button.setFocusable(false);
//        add(button);
//    }

    protected ImageIcon createImageIcon(String path, String description) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

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
