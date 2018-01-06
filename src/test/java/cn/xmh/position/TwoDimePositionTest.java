package cn.xmh.position;

import cn.xmh.holders.creatures.good.Huluwa;
import org.junit.Test;

import static org.junit.Assert.*;

public class TwoDimePositionTest {

    @Test
    public void getHolder() {
        assertEquals(null,new TwoDimePosition(1,2,null).getHolder());
    }

    @Test
    public void setHolder() {
        PositionInterface a=new TwoDimePosition(1,2,null);
        Huluwa b=new Huluwa(a);
        a.setHolder(b);
        assertEquals(a.getHolder(),b);
        assertEquals(b.getPosition(),a);
    }
}