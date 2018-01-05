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

import static cn.xmh.battleGround.BattleGround.gameIsEnd;
import static cn.xmh.battleGround.BattleGround.getGoods;
import static cn.xmh.battleGround.BattleGround.getMonsters;

public class Board extends JPanel implements View {
    final int OFFSET=50;
    public Board() {
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
        }
    }


    public void show(Graphics g, List<PositionInterface> positionInterfaces) {
        int nrx = Settings.getInstance().getNRX();
        int nry = Settings.getInstance().getNRY();
        for (int j = 0; j < nry; j++)
            for (int i = 0; i < nrx; i++) {
                g.drawImage(ImagesSet.GroundImage, OFFSET+46 * i, OFFSET+46 * j, 46,46,this);
                Holder holder = positionInterfaces.get(j * nrx + i).getHolder();
                if (holder != null)
                    g.drawImage(holder.getImage(), OFFSET+46 * i, OFFSET+46 * j, 46,46,this);
                if(holder instanceof Creature)
                    DrawHp.draw(g,OFFSET+46*i,OFFSET+46*j,((Creature) holder).getHp());
            }
    }

}
