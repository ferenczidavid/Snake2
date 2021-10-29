package Snake;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.Timer;


public class Snake extends JFrame {

    public Board board;
    public Container c = getContentPane();
    public Timer timer;
    public int counter;

    public Snake(String title) {
        super(title);

        JMenuBar mb = new JMenuBar();
        JMenu mNewGame = new JMenu("New Game");
        JMenuItem mi500x500 = new JMenuItem("500 x 500");

        JLabel TimeDisplay = new JLabel("    0");
        TimeDisplay.setFont(new Font("Serif", Font.BOLD, 16));
        mNewGame.setFont(new Font("Serif", Font.BOLD, 16));
        setJMenuBar(mb);
        if(!board.getActiveGame()){
            mb.add(mNewGame);
        }

        mNewGame.add(mi500x500);

        mi500x500.addActionListener((ActionEvent e) -> {
            board = new Board();
            c.add(board);
            c.revalidate();
            c.repaint();
            board.requestFocusInWindow();

            counter = 0;

            timer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (!board.isAlive) {
                        counter = 0;
                    } else {
                        counter++;
                    }
                    TimeDisplay.setText("    " + String.valueOf(counter));

                }
            });
            timer.start();
        });
        mb.add(TimeDisplay);

    }

}