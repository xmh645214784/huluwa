package Settings;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public interface Settings {
    final int WIDTH=20;
    final int HEIGHT=20;
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


}
