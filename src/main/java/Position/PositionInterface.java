package Position;
import Holders.Creatures.Creature;
import Holders.Holder;

public interface PositionInterface {
    Holder getHolder();
    void setHolder(Holder holder);
    int[] getPosition();
    void setPosition(int ...pos);
    String toString();
}
