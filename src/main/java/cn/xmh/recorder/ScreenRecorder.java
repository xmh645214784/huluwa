package cn.xmh.recorder;

import static org.bytedeco.javacpp.opencv_imgcodecs.cvLoadImage;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.*;

public class ScreenRecorder extends Thread {
    private JFrame jFrame;
    private Robot robot;
    private long i = 0;
    public final String storeDir="records"+File.separator+new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

    public static ScreenRecorder getScreenRecorder() {
        return screenRecorder;
    }
    private static ScreenRecorder screenRecorder=null;

    public ScreenRecorder(JFrame jFrame) {
        this.jFrame = jFrame;
        screenRecorder=this;
        try{
            robot = new Robot();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e);
        }
        new File(storeDir).mkdirs();
    }
    public void run(){
        while (!Thread.interrupted()){
            try{
                BufferedImage image = robot.createScreenCapture(jFrame.getBounds());//捕获制定屏幕矩形区域
                ImageIO.write(image,"png",new File(storeDir+File.separator + i + ".png"));
                i = i + 1;
                TimeUnit.MICROSECONDS.sleep(40);//每秒25帧
            }catch(InterruptedException e){
                    BufferedImage image = robot.createScreenCapture(jFrame.getBounds());//捕获制定屏幕矩形区域
                try {
                    ImageIO.write(image,"png",new File(storeDir+File.separator + i + ".png"));
                } catch (IOException e1) {

                }

                i = i + 1;
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
