package Holders.Creatures;

import BattleGround.TwoDimeBattleGround;
import Holders.Holder;
import Position.PositionInterface;
import Position.TwoDimePosition;
import Position.TwoDimePositionSet;

import java.awt.*;

abstract public class Creature extends Holder implements Runnable {


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

    public void moveoffset(int offsetx, int offsety) {
        int[] nowPos = this.getPosition().getValue();

        nowPos[0] += offsetx;
        nowPos[1] += offsety;
        PositionInterface newpos= TwoDimePositionSet.getPositionInterface(nowPos[0], nowPos[1]);
        if (newpos!= null) {
            setPosition(newpos);
        }
    }
}
