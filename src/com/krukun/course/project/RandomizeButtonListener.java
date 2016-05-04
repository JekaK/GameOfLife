package com.krukun.course.project;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Eugeniy Krukun on 03.05.2016.
 */
public class RandomizeButtonListener implements ButtonListener,Observer {
    private GamePanel panel;
    private GameState state;
    private boolean play;
    private boolean[][] currentMove = new boolean[GameState.height][GameState.width], nextMove = new boolean[GameState.height][GameState.width];
    private int count;

    public RandomizeButtonListener(GamePanel panel,GameState state) {
        this.panel = panel;
        this.state = state;
        state.registerObserver(this);
    }
    @Override
    public MouseAdapter getButtonAdapter() {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                generateRandom();
                panel.myRepaint(panel.getOffScrGraph());
                state.setData(currentMove,nextMove,play,count);
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
