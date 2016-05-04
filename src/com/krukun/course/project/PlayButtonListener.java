package com.krukun.course.project;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Eugeniy Krukun on 02.05.2016.
 */
public class PlayButtonListener implements ButtonListener, Observer {
    private GameState state;
    private boolean play;
    private boolean[][] currentMove = new boolean[GameState.height][GameState.width], nextMove = new boolean[GameState.height][GameState.width];
    private int count;

    public PlayButtonListener(GameState state) {
        this.state = state;
        state.registerObserver(this);
    }

    @Override
    public MouseAdapter getButtonAdapter() {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                play = !play;
                JButton button = (JButton) e.getComponent();
                if (play) {
                    button.setText("Pause");
                } else button.setText("Play");
                state.setData(currentMove, nextMove, play, count);
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
}
