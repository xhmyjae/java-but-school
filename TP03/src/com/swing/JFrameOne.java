package com.swing;

import javax.swing.JFrame;

public class JFrameOne extends JFrame {

    public JFrameOne() {
        initialize();
    }

    public void initialize() {
        setTitle("JFrame one");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1280, 720);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
