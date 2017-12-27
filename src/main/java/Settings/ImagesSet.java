package Settings;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public interface ImagesSet {
    final int WINWIDTH=500;
    final int WINHEIGHT=500;
    final Image[] HuluwaImage=new Image[]{
        new ImageIcon("1.png").getImage(),
        new ImageIcon("2.png").getImage(),
        new ImageIcon("3.png").getImage(),
        new ImageIcon("4.png").getImage(),
        new ImageIcon("5.png").getImage(),
        new ImageIcon("6.png").getImage(),
        new ImageIcon("7.png").getImage()
    };
    final Image LoloImage= new ImageIcon("lolo.png").getImage();
    final Image SnakeImage= new ImageIcon("snake.png").getImage();
    final Image GrandpaImage= new ImageIcon("grandpa.png").getImage();
    final Image ScorpionImage= new ImageIcon("scorpion.png").getImage();

    final Image GroundImage=new ImageIcon("ground.png").getImage();


}
