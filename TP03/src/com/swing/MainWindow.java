package com.swing;

import javax.swing.*;
import java.awt.*;

import com.swing.ex01.Ex01Panel;

public class MainWindow {

    private JFrame frame;

    public MainWindow() {
        initialize();
    }

    public void initialize() {
        frame = new JFrame();
        frame.setTitle("TP 03");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(1280, 720);
        frame.setResizable(false);
        frame.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setBackground(Color.decode("#272640"));
        menu();
    }

    public void menu() {
        // Menu panel
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        menuPanel.setBackground(Color.decode("#212F45"));
        menuPanel.setPreferredSize(new Dimension(240,720));
        // Menu buttons
        for (int i = 1; i <= 5; i++) {
            JButton button = new JButton("Button " + i);
            button.setPreferredSize(new Dimension(240, 50));
            button.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
            button.setBackground(Color.decode("#212F45"));
            button.setForeground(Color.decode("#7F9AB3"));
            button.setFocusable(false);
            button.setBorder(BorderFactory.createLineBorder(Color.decode("#212F45")));
            menuPanel.add(button);
        }
        frame.add(menuPanel, BorderLayout.WEST);

        // Main panel
        CardLayout cardLayout = new CardLayout();
        cardLayout.setHgap(0);
        cardLayout.setVgap(0);

        JPanel mainPanel = new JPanel(cardLayout);
        mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        mainPanel.setPreferredSize(new Dimension(1020, 720));
        mainPanel.setBackground(Color.decode("#272640"));
        frame.add(mainPanel);

        Ex01Panel ex01Panel = new Ex01Panel();
//        Ex02Panel ex02Panel = new Ex02Panel();
        mainPanel.add(ex01Panel, "ex01Panel");
//        mainPanel.add(ex02Panel, "ex02Panel");

        // Change main panel on menu buttons click
//        ex01Button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // switch cardLayout to ex01Panel
//
//
//                cardLayout.show(mainPanel, "ex01Panel");
//            }
//        });
    }
}
