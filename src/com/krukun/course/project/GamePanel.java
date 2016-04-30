package com.krukun.course.project;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Eugeniy Krukun on 30.04.2016.
 */
public class GamePanel extends JPanel {
    final int width = 100, height = 50;
    boolean[][] currentMove = new boolean[height][width];
    Image offScrImg;
    Graphics offScrGraph;

    public GamePanel() {
        setLayout(new GridLayout());
        setBackground(Color.DARK_GRAY);
        setSize(400, 400);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        myRepaint(g);
    }

    public void myRepaint(Graphics g) {
        offScrGraph = g;
        offScrGraph.setColor(getBackground());
        offScrGraph.fillRect(0, 0, getWidth(), getHeight());
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (currentMove[i][j]) {
                    offScrGraph.setColor(Color.YELLOW);
                    int x = j * getWidth() / width;
                    int y = i * getHeight() / height;
                    offScrGraph.fillRect(x, y, getWidth() / width, getHeight() / height);
                }
            }
        }
        offScrGraph.setColor(Color.BLACK);
        for (int i = 1; i < height; i++) {
            int y = i * getHeight() / height;
            offScrGraph.drawLine(0, y, getWidth(), y);
        }
        for (int i = 1; i < width; i++) {
            int x = i * getWidth() / width;
            offScrGraph.drawLine(x, 0, x, getHeight());
        }
        getGraphics().drawImage(offScrImg, 0, 0, this);
    }
}
