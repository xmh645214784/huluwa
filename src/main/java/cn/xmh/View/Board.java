package cn.xmh.View;

import cn.xmh.BattleGround.BattleGround;
import cn.xmh.BattleGround.TwoDimeBattleGround;
import cn.xmh.Holders.Creatures.Creature;
import cn.xmh.Holders.Holder;
import cn.xmh.Position.PositionInterface;
import cn.xmh.Settings.ImagesSet;
import cn.xmh.Settings.Settings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

public class Board extends JPanel implements View {
    final int OFFSET=50;
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
                g.drawImage(ImagesSet.GroundImage, OFFSET+46 * i, OFFSET+46 * j, this);
                Holder holder = positionInterfaces.get(j * nry + i).getHolder();
                if (holder != null)
                    g.drawImage(holder.getImage(), OFFSET+46 * i, OFFSET+46 * j, this);
                if(holder instanceof Creature)
                    DrawHp.draw(g,OFFSET+46*i,OFFSET+46*j,((Creature) holder).getHp());
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
