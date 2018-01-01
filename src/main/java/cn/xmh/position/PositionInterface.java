package cn.xmh.position;
import cn.xmh.holders.Holder;

public interface PositionInterface {
    Holder getHolder();
    void setHolder(Holder holder);
    int[] getValue();
    String toString();
    boolean isNear(PositionInterface other);
    int  relativePositionofThis(PositionInterface a);
}
