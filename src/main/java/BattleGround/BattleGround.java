package BattleGround;

import Holders.Creatures.Bad.Monster;
import Holders.Creatures.Creature;
import Holders.Creatures.Good.Good;
import Holders.Holder;
import Position.PositionInterface;
import Position.TwoDimePositionSet;

import java.util.ArrayList;
import java.util.List;

abstract public class BattleGround {
    public static volatile boolean gameIsPaused = false;
    public static boolean gameIsStart =false;
    static protected List<PositionInterface> positionInterfaces = TwoDimePositionSet.getPositionInterfaces();

    public static List<Good> getGoods() {
        return goods;
    }

    public static List<Monster> getMonsters() {
        return monsters;
    }

    static protected List<Creature> creatures = new ArrayList<Creature>();
    static protected List<Good> goods = new ArrayList<Good>();
    static protected List<Monster> monsters = new ArrayList<Monster>();

    static public List<PositionInterface> getPositionInterfaces() {
        return positionInterfaces;
    }

    static public List<Creature> getCreatures() {
        return creatures;
    }

    public void addCreatures(Creature... creatures) {
        for (Creature each : creatures) {
            this.creatures.add(each);
            if(each instanceof Good)
                goods.add((Good) each);
            else if(each instanceof Monster)
                monsters.add((Monster) each);
            else
                throw new RuntimeException("You add what?");
        }
    }

    public boolean deleteCreature(Creature target) {
        return creatures.remove(target);
    }

    public Holder getHolderInPosition(PositionInterface pos) {
        return pos.getHolder();
    }


    //the battle processing
    protected abstract void battle();

    public abstract boolean collisionDetection();

}
