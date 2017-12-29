package View;

import Settings.ImagesSet;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Application extends JFrame {
    public Application() {
        initUI();
    }

    private void initUI() {
        final Board board = new Board();
        add(board);
        setSize(ImagesSet.WINWIDTH, ImagesSet.WINHEIGHT);

        setTitle("Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.pack();
        setVisible(true);

        new Timer(100, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                board.repaint();
            }
        }).start();
    }

}
