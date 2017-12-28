package Position;

import Holders.Creatures.Creature;
import Holders.Holder;

public class TwoDimePosition implements PositionInterface{
    private int x, y;
    private Holder holder;

    public TwoDimePosition(int x, int y, Holder holder) {
        this.x = x;
        this.y = y;
        this.holder = holder;
    }

    public Holder getHolder() {
        return holder;
    }

    public void setHolder(Holder holder) {
        this.holder=holder;
    }


    public int[] getValue() {
        int[] pos=new int[2];
        pos[0]=x;
        pos[1]=y;
        return pos;
    }
}
