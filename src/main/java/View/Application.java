package View;

import Settings.ImagesSet;

import javax.swing.*;

public class Application extends JFrame {
    public Application() {
        initUI();
    }

    private void initUI() {
        add(new Board());
        setFocusable(true);
        setSize(ImagesSet.WINWIDTH, ImagesSet.WINHEIGHT);
        setTitle("Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

}
