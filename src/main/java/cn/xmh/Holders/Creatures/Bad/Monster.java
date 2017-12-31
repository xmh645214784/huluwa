package cn.xmh.Holders.Creatures.Bad;/*
 * @author Minhui Xie
 * @date 24,10,2017
 * @time 18:25
 */

import cn.xmh.BattleGround.BattleGround;
import cn.xmh.Holders.Creatures.Creature;
import cn.xmh.Holders.Creatures.Good.Good;
import cn.xmh.Position.PositionInterface;

import java.awt.*;
import java.util.List;
import java.util.Random;

public abstract class Monster extends Creature {
    Monster(String name, PositionInterface position, Image image) {
        super(name, position, image);
    }

    @Override
    public void run() {
        while (!Thread.interrupted()){
            if(BattleGround.gameIsPaused||BattleGround.gameIsEnd)
                continue;
            Random rand = new Random();
            final List<Good> goods = BattleGround.getGoods();
            synchronized (goods) {
                int reP = position.relativePositionofThis(
                        goods.get(rand.nextInt(goods.size())).getPosition());
                switch (reP) {
                    case 1:
                        this.moveoffset(1, 0);
                        break;
                    case 2:
                        this.moveoffset(-1, 0);
                        break;
                    case 3:
                        this.moveoffset(0, 1);
                        break;
                    case 4:
                        this.moveoffset(0, -1);
                        break;
                }
            }
            try {
                Thread.sleep(rand.nextInt(1000) + 1000);
            } catch (Exception e) {

            }
        }
    }
}
