package com.swing.jbuttons;

import javax.swing.*;

public class JButtonsPanel extends JPanel {

    public JButtonsPanel() {
        initialize();
    }

    public void initialize() {
        JButton button = new JButton("button 1");
        add(button);
    }
}
