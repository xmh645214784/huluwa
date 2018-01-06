package cn.xmh.holders.creatures;

import cn.xmh.holders.creatures.good.Huluwa;
import cn.xmh.position.PositionInterface;
import cn.xmh.position.TwoDimePosition;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreatureTest {

    @Test
    public void moveoffset() {
        PositionInterface A=new TwoDimePosition(1,2,null);
        PositionInterface B=new TwoDimePosition(1,3,null);
        Huluwa hulu=new Huluwa(A);
        hulu.setPosition(B);
        assertEquals(hulu.getPosition(),B);
        assertEquals(null,A.getHolder());
        assertEquals(hulu,B.getHolder());
    }
}