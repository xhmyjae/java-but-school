package com.swing.jbuttons;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Ex02Panel extends JPanel {

    public Ex02Panel() {
        initialize();
    }

    public void initialize() {
        JButton button = new JButton("button 2");
        add(button);
    }
}