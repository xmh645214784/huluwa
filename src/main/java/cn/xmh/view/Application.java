package cn.xmh.view;

import cn.xmh.recorder.ScreenRecorder;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import static cn.xmh.battleGround.BattleGround.*;

public class Application extends JFrame {
    public Application() {
        initUI();
    }

    private void initUI() {
        final Board board = new Board();
        add(board);
        setSize(1080,720);
        setTitle("Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.pack();
        setVisible(true);

        new Timer(100, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                board.repaint();
                System.err.println(gameIsEnd);
                System.err.println(""+getGoods().size()+"   "+getMonsters().size());
                if(gameIsEnd){
                    ScreenRecorder.getScreenRecorder().interrupt();
                }
            }
        }).start();
    }

}
