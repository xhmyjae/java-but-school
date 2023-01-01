package com.swing;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Flow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.swing.Ex01Panel;

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
        frame.setLayout(new BorderLayout(5, 5));
//        frame.add(new JButton("NORTH"), BorderLayout.NORTH);
//        frame.add(new JButton("SOUTH"), BorderLayout.SOUTH);
//        frame.add(new JButton("EAST"), BorderLayout.EAST);
//        frame.add(new JButton("WEST"), BorderLayout.WEST);
//        frame.add(new JButton("CENTER"), BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        menu();
    }

    public void menu() {
        // Menu panel
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
        menuPanel.setBackground(Color.decode("#212F45"));
        menuPanel.setPreferredSize(new Dimension(300,250));
        // Menu buttons
        JButton ex01Button = new JButton("Exercise 1");
        menuPanel.add(ex01Button);
        JButton ex02Button = new JButton("Exercise 2");
        menuPanel.add(ex02Button);
        JButton ex03Button = new JButton("Exercise 3");
        menuPanel.add(ex03Button);
        frame.add(menuPanel, BorderLayout.WEST);

        // Main panel
        CardLayout cardLayout = new CardLayout();

        JPanel mainPanel = new JPanel(cardLayout);
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
        mainPanel.setBackground(Color.decode("#272640"));
        frame.add(mainPanel);

        Ex01Panel ex01Panel = new Ex01Panel();
        Ex02Panel ex02Panel = new Ex02Panel();
        mainPanel.add(ex01Panel, "ex01Panel");
        mainPanel.add(ex02Panel, "ex02Panel");

        // Change main panel on menu buttons click
        ex01Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // switch cardLayout to ex01Panel


                cardLayout.show(mainPanel, "ex01Panel");
            }
        });
        ex02Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "ex02Panel");
            }
        });


//        frame.add(panel1);
//        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
//        panel.setBackground(Color.BLACK);
//        panel.setPreferredSize(new Dimension(250, 250));
//
//        Button button = new Button("button");
//        panel.add(button);
//
    }
}
