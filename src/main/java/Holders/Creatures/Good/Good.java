package Holders.Creatures.Good;

import BattleGround.BattleGround;
import Holders.Creatures.Creature;
import Position.PositionInterface;

import java.awt.*;
import java.util.Random;

public abstract class Good extends Creature {
    @Override
    public void run() {
        while (!Thread.interrupted()){
            if(BattleGround.gameIsPaused)
                continue;
            Random rand = new Random();
            this.moveoffset(1,0);
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
