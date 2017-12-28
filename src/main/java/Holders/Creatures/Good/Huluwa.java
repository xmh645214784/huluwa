package Holders.Creatures.Good;

import Position.PositionInterface;
import Settings.ImagesSet;

import java.util.Random;

public class Huluwa extends Good {

    private COLOR color;
    private SENIORITY seniority;
    static int count = 0;

    public COLOR getColor() {
        return color;
    }

    public SENIORITY getSeniority() {
        return seniority;
    }

    public Huluwa(PositionInterface positionInterface) {
        super(SENIORITY.getSENIORITY(count).toString(), positionInterface, ImagesSet.HuluwaImage[count]);
        this.color = COLOR.getCOLOR(count);
        this.seniority = SENIORITY.getSENIORITY(count);
        count++;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()){
            Random rand = new Random();
            this.moveoffset(1,0);
            try {
                Thread.sleep(rand.nextInt(1000) + 1000);
            } catch (Exception e) {

            }
        }
        moveoffset(1,0);
    }

    public enum COLOR {
        RED("赤", 0), ORGANGE("橙", 1), YELLOW("黄", 2),
        GREEN("绿", 3), CYAN("青", 4), BLUE("蓝", 5), VIOLET("紫", 6);
        private String name;
        private int index;

        // 构造方法
        private COLOR(String name, int index) {
            this.name = name;
            this.index = index;
        }

        static COLOR getCOLOR(int index) {
            for (COLOR c : COLOR.values()) {
                if (c.index == index) {
                    return c;
                }
            }
            assert false;
            return null;
        }
    }

    public enum SENIORITY {
        大(0), 二(1), 三(2), 四(3), 五(4), 六(5), 七(6);
        private int index;

        // 构造方法
        private SENIORITY(int index) {
            this.index = index;
        }

        static SENIORITY getSENIORITY(int index) {
            for (SENIORITY c : SENIORITY.values()) {
                if (c.index == index) {
                    return c;
                }
            }
            assert false;
            return null;
        }
    }
}

