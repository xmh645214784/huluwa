package View;

import BattleGround.BattleGround;
import BattleGround.TwoDimeBattleGround;
import Holders.Creatures.Creature;
import Holders.Holder;
import Position.PositionInterface;
import Settings.ImagesSet;
import Settings.Settings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

public class Board extends JPanel implements View {
    public Board() {
        addKeyListener(new TAdapter());
        setFocusable(true);
        setVisible(true);
        requestFocusInWindow();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (!BattleGround.gameIsStart) {
            g.drawImage(ImagesSet.HelloImage, 0, 0, this.getWidth(), this.getHeight(), this);
        } else {
            show(g, TwoDimeBattleGround.getInstance().getPositionInterfaces());
        }
    }


    public void show(Graphics g, List<PositionInterface> positionInterfaces) {
        int nrx = Settings.getInstance().getNRX();
        int nry = Settings.getInstance().getNRY();
        for (int j = 0; j < nry; j++)
            for (int i = 0; i < nrx; i++) {
                g.drawImage(ImagesSet.GroundImage, 47 * i, 47 * j, this);
                Holder holder = positionInterfaces.get(j * nry + i).getHolder();
                if (holder != null)
                    g.drawImage(holder.getImage(), 47 * i, 47 * j, this);
                
            }
    }

    class TAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_SPACE) {
                if (BattleGround.gameIsStart == false) {
                    BattleGround.gameIsStart = true;
                    BattleGround.gameIsPaused = false;
                    TwoDimeBattleGround.getInstance();
                    return;
                }
                BattleGround.gameIsPaused=!BattleGround.gameIsPaused;
            }
        }
    }
}
