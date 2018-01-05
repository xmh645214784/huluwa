package cn.xmh.view;

import cn.xmh.battleGround.BattleGround;
import cn.xmh.battleGround.TwoDimeBattleGround;
import cn.xmh.holders.creatures.Creature;
import cn.xmh.holders.Holder;
import cn.xmh.position.PositionInterface;
import cn.xmh.recorder.ScreenRecorder;
import cn.xmh.settings.ImagesSet;
import cn.xmh.settings.Settings;

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
        }
        else {
            show(g, TwoDimeBattleGround.getInstance().getPositionInterfaces());
            if(BattleGround.gameIsEnd){
                g.setFont(new Font("Tahoma", Font.BOLD, 20));
                g.drawString("Game over",this.getWidth()/2,getHeight()/2);
            }
            else if(BattleGround.gameIsPaused){
                g.drawString("Game Pausing",this.getWidth()/2,getHeight()/2);
            }
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
                    //start game
                    new ScreenRecorder(
                            Board.this.getBounds()
                            ).start();
                    return;
                }
                BattleGround.gameIsPaused=!BattleGround.gameIsPaused;
            }
        }
    }
}
