import javax.swing.*;
import com.swing.*;

import java.io.IOException;

public class Main {
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