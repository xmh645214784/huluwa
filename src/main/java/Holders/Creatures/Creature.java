package Holders.Creatures;

import Holders.Holder;
import Position.PositionInterface;

import java.awt.*;

abstract public class Creature extends Holder implements Runnable {


    protected String mName;

    public String getmName() {
        return mName;
    }

    protected Creature(String name, PositionInterface position,Image image) {
        super(image,position);
    }


    public void report() {
        System.out.println(this.toString() + "@" + this.position.toString());
    }

    @Override
    public String toString() {
        return mName;
    }

    abstract public void run();
}
