package View;

import BattleGround.*;
import Holders.Creatures.Creature;
import Position.PositionInterface;

import Settings.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Board extends JPanel implements View {
    public Board() {
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        show(g, TwoDimeBattleGround.getInstance().getPositionInterfaces());
    }


    public void show(Graphics g, List<PositionInterface> positionInterfaces) {
        int nrx = Settings.getInstance().getNRX();
        int nry = Settings.getInstance().getNRY();
        for (int i = 0; i < nry; i++)
            for (int j = 0; j < nrx; j++) {
                g.drawImage(ImagesSet.GroundImage, 47 * i, 47 * j, this);
                g.drawImage(positionInterfaces.get(i*nry+j).getHolder().getImage(),47 * i, 47 * j, this);
            }


    }
}
