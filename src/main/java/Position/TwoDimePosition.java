package Position;

import Holders.Creatures.Creature;
import Holders.Holder;
import Settings.Settings;

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

    @Override
    public String toString() {
        return "("+x+","+y+")";
    }

    @Override
    public boolean isNear(PositionInterface other) {
        int[] xy2=other.getValue();
        int x2=xy2[0];
        int y2=xy2[1];
        if(Math.abs(x2-x)<=Settings.getInstance().getDISTANCE_OF_ENCOUNTER()
                &&Math.abs(y2-y)<=Settings.getInstance().getDISTANCE_OF_ENCOUNTER()){
            return true;
        }
        return false;
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
