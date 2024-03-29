package cn.xmh.battleGround;

import cn.xmh.holders.creatures.bad.Monster;
import cn.xmh.holders.creatures.Creature;
import cn.xmh.holders.creatures.good.Good;
import cn.xmh.holders.Holder;
import cn.xmh.position.PositionInterface;
import cn.xmh.position.TwoDimePositionSet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

abstract public class BattleGround {
    public static volatile boolean gameIsPaused = false;
    public static volatile boolean gameIsStart = false;
    public static volatile boolean gameIsEnd = false;
    protected static List<PositionInterface> positionInterfaces = TwoDimePositionSet.getPositionInterfaces();

    public static List<Good> getGoods() {
        return goods;
    }

    public static List<Monster> getMonsters() {
        return monsters;
    }

    static protected List<Creature> creatures = Collections.synchronizedList(new ArrayList<Creature>());
    static  List<Good> goods = Collections.synchronizedList(new ArrayList<Good>());
    static protected List<Monster> monsters = Collections.synchronizedList(new ArrayList<Monster>());

    static public List<PositionInterface> getPositionInterfaces() {
        return positionInterfaces;
    }

    static public List<Creature> getCreatures() {
        return creatures;
    }

    public void addCreatures(Creature... creatures) {
        for (Creature each : creatures) {
            this.creatures.add(each);
            if (each instanceof Good)
                goods.add((Good) each);
            else if (each instanceof Monster)
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

    public abstract void collisionDetection();

}
