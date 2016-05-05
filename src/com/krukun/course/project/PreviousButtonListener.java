package com.krukun.course.project;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Eugeniy Krukun on 04.05.2016.
 */
public class PreviousButtonListener implements ButtonListener, Observer {
    private GamePanel panel;
    private GameState state;
    private boolean play;
    private boolean[][] currentMove = new boolean[GameState.height][GameState.width], nextMove = new boolean[GameState.height][GameState.width];
    private int count;
    private CareTaker taker;
    private Originator originator;

    public PreviousButtonListener(GamePanel panel, GameState state) {
        this.panel = panel;
        this.state = state;
        taker = new CareTaker();
        originator = new Originator();
        state.registerObserver(this);
    }

    @Override
    public MouseAdapter getButtonAdapter() {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (taker.getCurrent()-2<0) return;
                originator.getStateFromMemento(taker.get(taker.getCurrent()-2));
                currentMove = originator.getCurrentMove();
                state.setData(currentMove, nextMove, play, count);
                panel.myRepaint(panel.getOffScrGraph());
                int cur  = taker.getCurrent();
                taker.setCurrent(--cur);
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
