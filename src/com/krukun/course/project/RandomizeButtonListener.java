package com.krukun.course.project;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Eugeniy Krukun on 03.05.2016.
 */
public class RandomizeButtonListener extends ButtonListener implements Observer {
    private GamePanel panel;
    private boolean play;
    private boolean[][] currentMove = new boolean[GameState.height][GameState.width], nextMove = new boolean[GameState.height][GameState.width];
    private int count;

    public RandomizeButtonListener() {
        this.panel = GamePanel.getInstance();
        this.panel.getState().registerObserver(this);
    }
    @Override
    public MouseListener getButtonAdapter() {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                generateRandom();
                panel.getState().setData(currentMove, nextMove, play,count);
                panel.myRepaint(panel.getOffScrGraph());
            }
        };
    }
    public void generateRandom(){
        for (int i = 0; i <GameState.height ; i++) {
            for (int j = 0; j <GameState.width ; j++) {
                currentMove[i][j] = Math.random()<0.3;
            }
        }
    }

    @Override
    public void update(boolean[][] current, boolean[][] next, boolean playState, int count) {
        this.currentMove = current;
        this.nextMove = next;
        this.play = playState;
        this.count = count;
    }
}
