package Snake;

import javax.swing.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new Snake("Snake");
                frame.setSize(510, 510);
                frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                frame.setResizable(false);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                frame.revalidate();
                frame.repaint();
            }
        });
    }
}