/*
 * Created by JFormDesigner on Fri Jan 05 16:47:22 CST 2018
 */

package cn.xmh.view;

import cn.xmh.battleGround.BattleGround;
import cn.xmh.battleGround.TwoDimeBattleGround;
import cn.xmh.recorder.ScreenPlayer;
import cn.xmh.recorder.ScreenRecorder;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

import static cn.xmh.battleGround.BattleGround.*;

/**
 * @author unknown
 */
public class MainView extends JFrame {
    private class TAdapter extends KeyAdapter {
        void spaceHandle() {
            if (BattleGround.gameIsStart == false) {
                BattleGround.gameIsStart = true;
                MainView.this.startButton.setEnabled(false);
                BattleGround.gameIsPaused = false;
                TwoDimeBattleGround.getInstance();
                //start game
                new ScreenRecorder(
                        MainView.this
                ).start();
                return;
            }
            BattleGround.gameIsPaused = !BattleGround.gameIsPaused;
            if(BattleGround.gameIsPaused==false){
                TwoDimeBattleGround.getInstance().notifyAllCreatures();
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_SPACE) {
                spaceHandle();
            }
            else if(key ==KeyEvent.VK_L){
                lHandle();
            }
        }
    }

    private MainView() {
        initComponents();
        this.pack();
        addKeyListener(new TAdapter());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.textArea.append("Welcome to my hulu world!\n");
        this.show();
        ///add timer
        new Timer(100, q -> {
            board.repaint();

            if (gameIsPaused) {
                this.gameStatusLabel.setText("Pausing");
            } else if (gameIsEnd) {
                this.gameStatusLabel.setText("Ending");
                ScreenRecorder.getScreenRecorder().interrupt();
            } else if (gameIsStart) {
                this.gameStatusLabel.setText("Running");
            } else
                assert false;

        }).start();
    }

    public static MainView getmInstance() {
        if (mInstance == null)
            mInstance = new MainView();
        return mInstance;
    }

    static private MainView mInstance = null;

    private void startButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
        if (BattleGround.gameIsStart == false) {
            BattleGround.gameIsStart = true;
            BattleGround.gameIsPaused = false;
            TwoDimeBattleGround.getInstance();
            //start game
            new ScreenRecorder(
                    MainView.this
            ).start();
        }
    }

        private void pauseContinueButtonActionPerformed (ActionEvent e){
            // TODO add your code here
            BattleGround.gameIsPaused = !BattleGround.gameIsPaused;
            if(BattleGround.gameIsPaused==false){
                TwoDimeBattleGround.getInstance().notifyAllCreatures();
            }
        }

        private void lHandle(){
            JFileChooser jfc=new JFileChooser(".");
            jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY );
            jfc.showDialog(new JLabel(), "选择");
            File file=jfc.getSelectedFile();
            if(file==null)return;
            new ScreenPlayer(file.getPath());
        }

        private void replayButtonActionPerformed (ActionEvent e){
            // TODO add your code here
            lHandle();
        }

        public void addStringInTextBox(String str){
            this.textArea.append(str+'\n');
        }


        private void initComponents () {
            // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
            // Generated using JFormDesigner Evaluation license - Xie Minhui
            panel1 = new JPanel();
            board = new Board();
            label = new JLabel();
            startButton = new JButton();
            pauseContinueButton = new JButton();
            replayButton = new JButton();
            scrollPane1 = new JScrollPane();
            textArea = new JTextArea();
            gameStatusLabel = new JLabel();

            //======== this ========
            setMinimumSize(new Dimension(860, 640));
            setLocationByPlatform(true);
            setMaximizedBounds(new Rectangle(200, 400, 860, 640));
            setResizable(false);
            Container contentPane = getContentPane();
            contentPane.setLayout(null);

            //======== panel1 ========
            {

                // JFormDesigner evaluation mark
                panel1.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                        java.awt.Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

                panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS));
                panel1.add(board);
            }
            contentPane.add(panel1);
            panel1.setBounds(0, 5, 780, 770);

            //---- label ----
            label.setText("Game Status");
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setForeground(Color.darkGray);
            label.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
            contentPane.add(label);
            label.setBounds(880, 10, 135, 45);

            //---- startButton ----
            startButton.setText("\u5f00\u59cb");
            startButton.addActionListener(e -> startButtonActionPerformed(e));
            contentPane.add(startButton);
            startButton.setBounds(new Rectangle(new Point(905, 120), startButton.getPreferredSize()));

            //---- pauseContinueButton ----
            pauseContinueButton.setText("\u6682\u505c/\u7ee7\u7eed");
            pauseContinueButton.addActionListener(e -> pauseContinueButtonActionPerformed(e));
            contentPane.add(pauseContinueButton);
            pauseContinueButton.setBounds(new Rectangle(new Point(890, 170), pauseContinueButton.getPreferredSize()));

            //---- replayButton ----
            replayButton.setText("\u56de\u653e");
            replayButton.addActionListener(e -> replayButtonActionPerformed(e));
            contentPane.add(replayButton);
            replayButton.setBounds(new Rectangle(new Point(905, 220), replayButton.getPreferredSize()));

            //======== scrollPane1 ========
            {

                //---- textArea ----
                textArea.setLineWrap(true);
                textArea.setWrapStyleWord(true);
                scrollPane1.setViewportView(textArea);
            }
            contentPane.add(scrollPane1);
            scrollPane1.setBounds(840, 260, 210, 520);

            //---- gameStatusLabel ----
            gameStatusLabel.setHorizontalAlignment(SwingConstants.CENTER);
            gameStatusLabel.setText("Hello");
            gameStatusLabel.setForeground(Color.red);
            contentPane.add(gameStatusLabel);
            gameStatusLabel.setBounds(895, 55, 85, 32);

            { // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < contentPane.getComponentCount(); i++) {
                    Rectangle bounds = contentPane.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = contentPane.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                contentPane.setMinimumSize(preferredSize);
                contentPane.setPreferredSize(preferredSize);
            }
            pack();
            setLocationRelativeTo(getOwner());
            // JFormDesigner - End of component initialization  //GEN-END:initComponents
        }

        // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
        // Generated using JFormDesigner Evaluation license - Xie Minhui
        private JPanel panel1;
        private Board board;
        private JLabel label;
        private JButton startButton;
        private JButton pauseContinueButton;
        private JButton replayButton;
        private JScrollPane scrollPane1;
        private JTextArea textArea;
        private JLabel gameStatusLabel;
        // JFormDesigner - End of variables declaration  //GEN-END:variables
    }
