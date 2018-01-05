package cn.xmh.settings;

import javax.swing.*;
import java.awt.*;

public interface ImagesSet {
    final int WINWIDTH=50*Settings.getInstance().getNRX();
    final int WINHEIGHT=50*Settings.getInstance().getNRY();
    final Image[] HuluwaImage=new Image[]{
        new ImageIcon(ImagesSet.class.getClassLoader().getResource("1.png")).getImage(),
        new ImageIcon(ImagesSet.class.getClassLoader().getResource("2.png")).getImage(),
        new ImageIcon(ImagesSet.class.getClassLoader().getResource("3.png")).getImage(),
        new ImageIcon(ImagesSet.class.getClassLoader().getResource("4.png")).getImage(),
        new ImageIcon(ImagesSet.class.getClassLoader().getResource("5.png")).getImage(),
        new ImageIcon(ImagesSet.class.getClassLoader().getResource("6.png")).getImage(),
        new ImageIcon(ImagesSet.class.getClassLoader().getResource("7.png")).getImage()
    };
    final Image LoloImage= new ImageIcon(ImagesSet.class.getClassLoader().getResource("lolo.png")).getImage();
    final Image SnakeImage= new ImageIcon(ImagesSet.class.getClassLoader().getResource("snake.png")).getImage();
    final Image GrandpaImage= new ImageIcon(ImagesSet.class.getClassLoader().getResource("grandpa.png")).getImage();
    final Image ScorpionImage= new ImageIcon(ImagesSet.class.getClassLoader().getResource("scorpion.png")).getImage();

    final Image GroundImage=new ImageIcon(ImagesSet.class.getClassLoader().getResource("ground.png")).getImage();

    final Image HelloImage=new ImageIcon(ImagesSet.class.getClassLoader().getResource("hello.png")).getImage();

    final Image MountainImage=new ImageIcon(ImagesSet.class.getClassLoader().getResource("mountain.png")).getImage();

}
