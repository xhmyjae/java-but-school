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

        JButton button = new JButton("button 1");
        add(button);
    }
}
