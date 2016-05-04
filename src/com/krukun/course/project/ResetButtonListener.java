package com.krukun.course.project;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Eugeniy Krukun on 02.05.2016.
 */
public class ResetButtonListener implements ButtonListener,Observer {
    private GamePanel panel;
    private GameState state;
    private boolean play;
    private boolean[][] currentMove = new boolean[GameState.height][GameState.width], nextMove = new boolean[GameState.height][GameState.width];
    private int count;

    public ResetButtonListener(GamePanel panel, GameState state) {
        this.panel = panel;
        this.state = state;
        state.registerObserver(this);
    }

    @Override
    public MouseAdapter getButtonAdapter() {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                currentMove = new boolean[GameState.height][GameState.width];

                state.setData(currentMove, nextMove, play, count);
                panel.myRepaint(panel.getOffScrGraph());
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
