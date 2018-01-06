package cn.xmh.position;

import cn.xmh.holders.Holder;
import cn.xmh.settings.Settings;

import java.util.Random;

public class TwoDimePosition implements PositionInterface {
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
        return "(" + x + "," + y + ")";
    }

    @Override
    public boolean isNear(PositionInterface other) {
        int[] xy2 = other.getValue();
        int x2 = xy2[0];
        int y2 = xy2[1];
        if (Math.abs(x2 - x) <= Settings.getInstance().getDISTANCE_OF_ENCOUNTER()
                && Math.abs(y2 - y) <= Settings.getInstance().getDISTANCE_OF_ENCOUNTER()) {
            return true;
        }
        return false;
    }


    /**
     * Caculate the relative position with a and this position.
     *
     * @param a another positon
     * @return 1 should move (1,0)
     * 2 should move (-1.0)
     * 3 should move (0,1)
     * 4 should move (0,-1)
     */
    @Override
    public int relativePositionofThis(PositionInterface a) {
        Random rd = new Random();
        int[] xy2 = a.getValue();
        int diffx=0,diffy=0;
        try {
            diffx = (xy2[0] - x) / Math.abs(xy2[0] - x);
            diffy = (xy2[1] - y) / Math.abs(xy2[1] - y);
        }catch (ArithmeticException e){
            ;
        }

        if (diffy == 0) {
            if (rd.nextInt(100) > 50)
                return diffx == 1 ? 1 : 2;
            else
                return rd.nextInt(100)>50?3:4;
        }
        if (diffx == 0) {
            if (rd.nextInt(100) > 50)
                return diffy == 1 ? 3 : 4;
            else
                return rd.nextInt(100)>50?1:2;
        } else if (diffx > 0) {
            if (diffy > 0) {
                return rd.nextInt(100)>50?1:3;
            } else {
                return rd.nextInt(100)>50?1:4;
            }
        } else {
            if (diffy > 0) {
                return rd.nextInt(100)>50?2:3;
            } else {
                return rd.nextInt(100)>50?2:4;
            }
        }


    }

    public void setHolder(Holder holder) {
        this.holder = holder;
    }


    public int[] getValue() {
        int[] pos = new int[2];
        pos[0] = x;
        pos[1] = y;
        return pos;
    }
}
