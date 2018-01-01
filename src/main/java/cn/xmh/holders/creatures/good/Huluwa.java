package cn.xmh.holders.creatures.good;

import cn.xmh.position.PositionInterface;
import cn.xmh.settings.ImagesSet;
import cn.xmh.settings.Settings;

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
        this.hp= Settings.getInstance().getHP_OF_HULUWA();
        this.damage=Settings.getInstance().getDMG_OF_HULUWA();
        count++;
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

