package Position;

import Creatures.Creature;

public class TwoDimePosition implements PositionInterface{
    private int x, y;
    private Creature holder;
    public Creature getHolder() {
        return holder;
    }

    public void setHolder(Creature holder) {
        this.holder=holder;
    }

    public int[] getPosition() {
        int[] pos=new int[2];
        pos[0]=x;
        pos[1]=y;
        return pos;
    }

    public void setPosition(int... pos) {
        if ((pos.length != 2)) throw new AssertionError();
    }
}
