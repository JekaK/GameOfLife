package com.krukun.course.project;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Eugeniy Krukun on 02.05.2016.
 */
public class PlayButtonListener implements ButtonListener, Observer {
    private GamePanel panel;
    private boolean play;
    private boolean[][] currentMove = new boolean[GameState.height][GameState.width], nextMove = new boolean[GameState.height][GameState.width];
    private int count;
    private Originator originator;
    private CareTaker taker;

    public PlayButtonListener() {
        originator = new Originator();
        taker = new CareTaker();
        panel = GamePanel.getInstance();
        panel.getState().registerObserver(this);
    }

    @Override
    public MouseListener getButtonAdapter() {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                play = !play;
                JButton button = (JButton) e.getComponent();
                if (play) {
                    button.setText("Pause");
                    originator.setCurrentMove(copy());
                    taker.add(originator.saveToMemento());
                    taker.setCurrent(taker.getListSize());
                } else button.setText("Play");
                panel.getState().setData(currentMove, nextMove, play, count);
            }
        };
    }

    @Override
    public void update(boolean[][] current, boolean[][] next, boolean playState, int count) {
        this.currentMove = current;
        this.nextMove = next;
        this.play = playState;
        this.count = count;
    }
    private boolean[][] copy() {
        boolean state[][] = new boolean[GameState.height][GameState.width];
        for (int i = 0; i < GameState.height; i++) {
            for (int j = 0; j < GameState.width; j++) {
                state[i][j] = currentMove[i][j];
            }
        }
        return state;
    }
}
