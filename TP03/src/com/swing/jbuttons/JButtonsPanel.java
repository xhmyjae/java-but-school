package com.swing.jbuttons;

import javax.swing.*;
import javax.swing.ImageIcon;

public class JButtonsPanel extends JPanel {

    public JButtonsPanel() {
        initialize();
    }

    public void initialize() {
        JButton button1 = new JButton("Button simple");
        add(button1);

        JButton button2 = new JButton("Button fantaisie", new ImageIcon("resources/icon1.png"));
        add(button2);
    }
}
