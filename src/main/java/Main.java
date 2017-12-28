import BattleGround.*;
import View.Application;

import java.awt.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        BattleGround battleGround = TwoDimeBattleGround.getInstance();
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                Application ex = new Application();
                ex.setVisible(true);
            }
        });
    }
}
