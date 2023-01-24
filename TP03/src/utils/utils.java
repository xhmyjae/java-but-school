package utils;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class utils {

    public static void buttonDesign(JButton button, JPanel panel, int width, int height) {
        button.setPreferredSize(new Dimension(width, height));
        button.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        button.setBackground(Color.decode("#1C1E26"));
        button.setForeground(Color.decode("#7F9AB3"));
        button.setFocusable(false);
        panel.add(button);
    }

    public static String getObjectType(Object object) {
        return object.getClass().getSimpleName();
    }

    public static String cardTypeFromFile(File file) {
        try {
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = bufferedReader.readLine();
            String[] data = line.split(";");
            bufferedReader.close();
            return data[2];
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
//
//    public static class MyComboBoxRenderer extends JLabel implements ListCellRenderer {
//        private String _title;
//
//        public MyComboBoxRenderer(String title)
//        {
//            _title = title;
//        }
//
//        @Override
//        public Component getListCellRendererComponent(JList list, Object value,
//                                                      int index, boolean isSelected, boolean hasFocus)
//        {
//            if (index == -1 && value == null) setText(_title);
//            else setText(value.toString());
//            return this;
//        }
//    }
}
