package cn.xmh.Position;
import cn.xmh.Holders.Holder;

public interface PositionInterface {
    Holder getHolder();
    void setHolder(Holder holder);
    int[] getValue();
    String toString();
    boolean isNear(PositionInterface other);
}
