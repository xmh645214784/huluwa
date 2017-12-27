package Creatures;

import Position.PositionInterface;

import javax.swing.*;
import java.awt.*;

abstract public class Creature extends Thread {

    protected PositionInterface position;
    protected String mName;
    protected Image image;

    public String getmName() {
        return mName;
    }

    protected Creature(String name, PositionInterface position,Image image) {
        this.mName = name;
        this.setPosition(position);
        this.image=image;
    }

    public void setPosition(PositionInterface position) {
        if (this.position != null)
            this.position.setHolder(null);// set the original position null
        this.position = position;
        position.setHolder(this);
    }

    public PositionInterface getPosition() {
        return this.position;
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
