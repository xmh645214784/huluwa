package Holders.Creatures;

import BattleGround.BattleGround;
import BattleGround.TwoDimeBattleGround;
import Holders.Creatures.Bad.Monster;
import Holders.Creatures.Good.Good;
import Holders.Holder;
import Position.PositionInterface;
import Position.TwoDimePositionSet;

import java.awt.*;

abstract public class Creature extends Holder implements Runnable {

    protected int hp = 0;
    protected int damage = 0;


    public void setThread(Thread thread) {
        this.thread = thread;
    }

    public Thread getThread() {

        return thread;
    }

    private Thread thread;

    protected String mName;

    public String getmName() {
        return mName;
    }

    protected Creature(String name, PositionInterface position, Image image) {
        super(image, position);
    }


    public void report() {
        System.out.println(this.toString() + "@" + this.position.toString());
    }


    public void setPosition(PositionInterface position) {
        if (this.position != null)
            this.position.setHolder(null);// set the original position null
        this.position = position;
        position.setHolder(this);
    }


    @Override
    public String toString() {
        return mName;
    }

    abstract public void run();

    public void Die() {
        System.out.println(this.getClass().getSimpleName());
        hp = 0;
        this.getPosition().setHolder(null);
        System.err.println(this.getPosition().toString());
        BattleGround.getCreatures().remove(this);
        if (this instanceof Good)
            BattleGround.getGoods().remove(this);
        else if (this instanceof Monster)
            BattleGround.getMonsters().remove(this);
        else
            assert false;
        this.getThread().interrupt();
    }


    public boolean moveoffset(int offsetx, int offsety) {
        PositionInterface oldPostion = this.getPosition();
        int[] nowPos = oldPostion.getValue();

        nowPos[0] += offsetx;
        nowPos[1] += offsety;
        synchronized (TwoDimePositionSet.class) {
            PositionInterface newpos = TwoDimePositionSet.getPositionInterface(nowPos[0], nowPos[1]);
            if (newpos != null && newpos.getHolder() == null) {
                this.setPosition(newpos);
                TwoDimeBattleGround.getInstance().collisionDetection();
                return true;
            }
        }
        return false;
    }
}