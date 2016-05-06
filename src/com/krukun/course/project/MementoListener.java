package com.krukun.course.project;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Eugeniy Krukun on 06.05.2016.
 */
public class MementoListener extends KeyAdapter implements Observer {
    private boolean play;
    private boolean[][] currentMove = new boolean[GameState.height][GameState.width], nextMove = new boolean[GameState.height][GameState.width];
    private int count;
    private CareTaker taker;
    private Originator originator;
    private GamePanel panel;

    public MementoListener() {
        this.panel = GamePanel.getInstance();
        taker = new CareTaker();
        originator = new Originator();
        this.panel.getState().registerObserver(this);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_Z) {
            CTRLZ();
        }
        if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_Y) {
            CTRLY();
        }
    }

    @Override
    public void update(boolean[][] current, boolean[][] next, boolean playState, int count) {
        this.currentMove = current;
        this.nextMove = next;
        this.play = playState;
        this.count = count;
    }

    public void CTRLZ() {
        if (taker.getCurrent() - 2 < 0) return;
        originator.getStateFromMemento(taker.get(taker.getCurrent() - 2));
        currentMove = originator.getCurrentMove();
        panel.getState().setData(currentMove, nextMove, play, count);
        panel.myRepaint(panel.getOffScrGraph());
        int cur = taker.getCurrent();
        taker.setCurrent(--cur);
    }

    public void CTRLY() {
        if (taker.getCurrent() <= taker.getListSize() - 1) {
            originator.getStateFromMemento(taker.get(taker.getCurrent()));
            currentMove = originator.getCurrentMove();
            panel.getState().setData(currentMove, nextMove, play, count);
            panel.myRepaint(panel.getOffScrGraph());
            int cur = taker.getCurrent();
            taker.setCurrent(++cur);
        }
    }
}
