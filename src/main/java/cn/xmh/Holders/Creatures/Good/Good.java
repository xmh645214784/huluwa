package cn.xmh.Holders.Creatures.Good;

import cn.xmh.BattleGround.BattleGround;
import cn.xmh.Holders.Creatures.Bad.Monster;
import cn.xmh.Holders.Creatures.Creature;
import cn.xmh.Position.PositionInterface;

import java.awt.*;
import java.util.List;
import java.util.Random;

public abstract class Good extends Creature {
    @Override
    public void run() {
        while (!Thread.interrupted()){
            if(BattleGround.gameIsPaused||BattleGround.gameIsEnd)
                continue;
            Random rand = new Random();
            final List<Monster>  monsters = BattleGround.getMonsters();
            int reP=position.relativePositionofThis(
                    monsters.get(rand.nextInt(monsters.size())).getPosition());
            switch (reP){
                case 1:this.moveoffset(1,0);break;
                case 2:this.moveoffset(-1,0);break;
                case 3:this.moveoffset(0,1);break;
                case 4:this.moveoffset(0,-1);break;
            }

            try {
                Thread.sleep(rand.nextInt(1000) + 1000);
            } catch (Exception e) {

            }
        }
    }

    Good(String name, PositionInterface position, Image image) {
        super(name, position,image);
    }
}
