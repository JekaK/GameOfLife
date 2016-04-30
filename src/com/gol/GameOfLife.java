package com.gol;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Timer;


/**
 * Created by kruku on 12.04.2016.
 */
public class GameOfLife extends JFrame {
    final int width = 100, height = 50;
    boolean[][] currentMove = new boolean[height][width], nextMove = new boolean[height][width];
    boolean play;
    Image offScrImg;
    Graphics offScrGraph;
    private JPanel mainPanel;
    private JButton playButton;
    private JButton resetButton;
    private JPanel gamePanel;
    private JButton button1;
    private JSlider slider1;
    private int speed = 100;
    Timer time;
    TimerTask timer = new TimerTask() {
        @Override
        public void run() {
            if(play){
                for (int i = 0; i <height ; i++) {
                    for (int j = 0; j <width ; j++) {
                        nextMove[i][j] = decide(i,j);
                    }
                }
                for (int i = 0; i <height ; i++) {
                    for (int j = 0; j <width ; j++) {
                        currentMove[i][j] = nextMove[i][j];
                    }
                }
                myRepaint();
            }

        }
    };
    public GameOfLife() {
        super("GameOfLife");
        setContentPane(mainPanel);
        setSize(400, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        offScrImg = createImage(mainPanel.getWidth(), gamePanel.getHeight());
        offScrGraph = offScrImg.getGraphics();
        myRepaint();
        time = new Timer();
        time.scheduleAtFixedRate(timer,0,speed);
        //TODO
        slider1.setMaximum(1000);
        slider1.setValue(100);
        slider1.setMinorTickSpacing(20);
        slider1.setMajorTickSpacing(100);
        slider1.setPaintTicks(true);
        slider1.setPaintLabels(true);
        slider1.setLabelTable(slider1.createStandardLabels(100));
        slider1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                speed = slider1.getValue();
                reschedule(speed);
                System.out.println(speed);
            }
        });
        gamePanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int j = width * e.getX() / gamePanel.getWidth();
                int i = height * e.getY() / gamePanel.getHeight();
                currentMove[i][j] = !currentMove[i][j];
                myRepaint();
            }
        });
        gamePanel.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                offScrImg = createImage(mainPanel.getWidth(), gamePanel.getHeight());
                offScrGraph = offScrImg.getGraphics();

                myRepaint();
            }
        });

        playButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                play =!play;
                if(play)playButton.setText("Pause");
                else playButton.setText("Play");
            }
        });
        resetButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                currentMove = new boolean[height][width];
            }
        });
        gamePanel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int j = width * e.getX() / gamePanel.getWidth();
                int i = height * e.getY() / gamePanel.getHeight();
                if(SwingUtilities.isLeftMouseButton(e)) {
                    currentMove[i][j] = true;
                }else {
                    currentMove[i][j] = false;
                }
                myRepaint();
            }
        });
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                generateRandom();
                myRepaint();
            }
        });
    }

    public void reschedule(int delay){
        time.cancel();
        timer = new TimerTask() {
            @Override
            public void run() {
                if(play){
                    for (int i = 0; i <height ; i++) {
                        for (int j = 0; j <width ; j++) {
                            nextMove[i][j] = decide(i,j);
                        }
                    }
                    for (int i = 0; i <height ; i++) {
                        for (int j = 0; j <width ; j++) {
                            currentMove[i][j] = nextMove[i][j];
                        }
                    }
                    myRepaint();
                }
            }
        };
        time = new Timer();
        time.schedule(timer,delay);

    }

    public void generateRandom(){
        for (int i = 0; i <height ; i++) {
            for (int j = 0; j <width ; j++) {
                currentMove[i][j] = Math.random()<0.3;
            }
        }
    }

    public boolean decide(int i,int j){
        int neighbors = 0;
        if(j>0){
            if(currentMove[i][j-1])neighbors++;
            if(i>0)if(currentMove[i-1][j-1]) neighbors++;
            if(i<height-1)if(currentMove[i+1][j-1])neighbors++;
        }
        if(j<width-1){
            if(currentMove[i][j+1])neighbors++;
            if(i>0)if(currentMove[i-1][j+1]) neighbors++;
            if(i<height-1)if(currentMove[i+1][j+1])neighbors++;

        }
        if(i>0) if(currentMove[i-1][j])neighbors++;
        if(i<height-1) if(currentMove[i+1][j])neighbors++;
        if(neighbors==3)return true;
        if(currentMove[i][j]&&neighbors==2)return true;
        return false;
    }
    public void myRepaint() {
        offScrGraph.setColor(gamePanel.getBackground());
        offScrGraph.fillRect(0, 0, gamePanel.getWidth(), gamePanel.getHeight());
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (currentMove[i][j]) {
                    offScrGraph.setColor(Color.YELLOW);
                    int x =  j * gamePanel.getWidth()/ width;
                    int y =  i * gamePanel.getHeight()/height;
                    offScrGraph.fillRect(x, y, gamePanel.getWidth() / width, gamePanel.getHeight() / height);
                }
            }
        }
        offScrGraph.setColor(Color.BLACK);
        for (int i = 1; i < height; i++) {
            int y = i * gamePanel.getHeight() / height;
            offScrGraph.drawLine(0, y, gamePanel.getWidth(), y);
        }
        for (int i = 1; i < width; i++) {
            int x = i * gamePanel.getWidth() / width;
            offScrGraph.drawLine(x, 0, x, gamePanel.getHeight());
        }
        gamePanel.getGraphics().drawImage(offScrImg, 0, 0, gamePanel);

    }


}
