package Creatures;

import Position.PositionInterface;

abstract public class Creature extends Thread {

    protected PositionInterface position;
    protected String mName;

    public String getmName() {
        return mName;
    }

    protected Creature(String name, PositionInterface position) {
        this.mName = name;
        this.setPosition(position);
    }

    public void setPosition(PositionInterface position) {
        if (this.position != null)
            this.position.setHolder(null);
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
