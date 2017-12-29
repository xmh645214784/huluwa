package cn.xmh.Holders.Creatures.Bad;/*
 * @author Minhui Xie
 * @date 24,10,2017
 * @time 18:25
 */

import cn.xmh.BattleGround.BattleGround;
import cn.xmh.Holders.Creatures.Creature;
import cn.xmh.Position.PositionInterface;

import java.awt.*;
import java.util.Random;

public abstract class Monster extends Creature {
    Monster(String name, PositionInterface position, Image image) {
        super(name, position, image);
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            if (BattleGround.gameIsPaused)
                return;
            Random rand = new Random();
            this.moveoffset(1, 0);
            try {
                Thread.sleep(rand.nextInt(1000) + 1000);
            } catch (Exception e) {

            }
        }
        moveoffset(1, 0);
    }
}
