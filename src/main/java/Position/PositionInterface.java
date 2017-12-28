package Position;
import Holders.Creatures.Creature;
import Holders.Holder;

public interface PositionInterface {
    Holder getHolder();
    void setHolder(Holder holder);
    int[] getValue();
    String toString();
}
