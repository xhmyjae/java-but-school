import javax.swing.*;
import com.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainWindow main = new MainWindow();
//                JFrameOne frame1 = new JFrameOne();
//
//                JFrameTwo frame2 = new JFrameTwo();
            }
        });
    }
}