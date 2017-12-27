package Creatures;

import Position.PositionInterface;
public class Huluwa extends Creature {

    private COLOR color;
    private SENIORITY seniority;

    public COLOR getColor() {
        return color;
    }
    public SENIORITY getSeniority() {
        return seniority;
    }

    public Huluwa(COLOR color, SENIORITY seniority, PositionInterface positionInterface) {
        super(seniority.toString(),positionInterface);
        this.color      = color;
        this.seniority  = seniority;
    }

    @Override
    public void act(){}
    public enum COLOR {
        赤, 橙, 黄, 绿, 青, 蓝, 紫
    }

    public enum SENIORITY {
        大, 二, 三, 四, 五, 六, 七
    }
}

