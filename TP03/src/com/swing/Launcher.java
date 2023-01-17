package com.swing;

import javax.swing.*;
import java.io.IOException;

public class Launcher {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    MainWindow main = new MainWindow();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
