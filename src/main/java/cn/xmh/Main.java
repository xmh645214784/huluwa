package cn.xmh;

import cn.xmh.view.Application;

import java.awt.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                Application ex = new Application();
                ex.setSize(700,700);
                ex.setVisible(true);
            }
        });
    }
}
