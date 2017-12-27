import BattleGround.*;
public class Main {
    public static void main(String[] args) {
        BattleGround battleGround = TwoDimeBattleGround.getInstance();
        battleGround.initCreature();
        battleGround.battle();
    }
}
