package cn.xmh.recorder;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class ScreenPlayer extends JFrame {

    public ScreenPlayer() throws HeadlessException {
        super();
        ImageIcon temp = new ImageIcon(ScreenRecorder.storeDir+ File.separator+"1.png");
        this.setSize(temp.getIconWidth(), temp.getIconHeight());
        Screen p = new Screen();
        Container c = this.getContentPane();
        c.setLayout(new BorderLayout());
        c.add(p,"Center");
        new Thread(p).start();
//        this.pack();
        this.show();
    }

    public static void main(String[] args) {
        new ScreenPlayer();
    }
}

class Screen extends JPanel implements Runnable {
    private BorderLayout borderLayout1 = new BorderLayout();
    private Image cimage;

    public void run() {
        int i = 0;
        while (true) {
            try {
                cimage = loadImage(i + ".png");
                i = i + 1;
                repaint();
                Thread.sleep(40);//与录像时每秒帧数一致

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e);
            }
        }
    }

    public Image loadImage(String name) {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Image image = null;
        image = tk.getImage(ScreenRecorder.storeDir + File.separator + name);
        MediaTracker mt = new MediaTracker(this);
        mt.addImage(image, 0);
        try {
            mt.waitForID(0);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return image;
    }

    public Screen() {
        super();
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(cimage, 0, 0, null);
    }
}
