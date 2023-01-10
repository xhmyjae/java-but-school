package utils;

import javax.swing.*;
import java.awt.*;

public class utils {

    public static void buttonDesign(JButton button, JPanel panel, int width, int height) {
        button.setPreferredSize(new Dimension(width, height));
        button.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        button.setBackground(Color.decode("#1C1E26"));
        button.setForeground(Color.decode("#7F9AB3"));
        button.setFocusable(false);
        panel.add(button);
    }

}
