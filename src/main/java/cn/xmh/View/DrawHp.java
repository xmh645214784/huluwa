package cn.xmh.View;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class DrawHp {

    static private int width=40;
    static private int height=10;
    static public void draw(Graphics g,int x,int y,int hp){

        Graphics2D g2=(Graphics2D) g;
        //画外圈
        Rectangle2D r2=new Rectangle2D.Double(x, y-height, width, height);
        g2.setColor(Color.RED);
        g2.draw(r2);
        //根据血量比例画血条
        Rectangle2D r=new Rectangle2D.Double(x+1, y-height+1, width*((double) hp /100)-1, height-1);
        g2.setColor(Color.RED);
        g2.fill(r);
    }
}