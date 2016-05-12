package com.krukun.course.project;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Eugeniy Krukun on 02.05.2016.
 */
public class GameLogic implements Observer {
    private GamePanel panel;
    private GameState state;
    private boolean play;
    private boolean[][] currentMove = new boolean[GameState.height][GameState.width], nextMove = new boolean[GameState.height][GameState.width];
    private int count;

    private Originator originator;
    private CareTaker taker;

    public GameLogic( GameState state) {
        this.panel = GamePanel.getInstance();
        this.state = state;
        originator = new Originator();
        taker = new CareTaker();
        state.registerObserver(this);
    }

    public void startThinking() {
        time = new Timer();
        time.scheduleAtFixedRate(timer, 0, 100);
    }

    Timer time;
    TimerTask timer = new TimerTask() {
        @Override
        public void run() {
            if (play) {
                for (int i = 0; i < GameState.height; i++) {
                    for (int j = 0; j < GameState.width; j++) {
                        nextMove[i][j] = decide(i, j);
                    }
                }
                boolean mod = isModified();
                for (int i = 0; i < GameState.height; i++) {
                    for (int j = 0; j < GameState.width; j++) {
                        currentMove[i][j] = nextMove[i][j];
                    }
                }
                if (isHaveAlive() && mod) {
                    originator.setCurrentMove(copy());
                    taker.add(originator.saveToMemento());
                    taker.setCurrent(taker.getListSize());
                }
                panel.myRepaint(panel.getOffScrGraph());
            }
        }
    };

    public boolean decide(int i, int j) {
        int neighbors = 0;
        if (j > 0) {
            if (currentMove[i][j - 1]) neighbors++;
            if (i > 0) if (currentMove[i - 1][j - 1]) neighbors++;
            if (i < GameState.height - 1) if (currentMove[i + 1][j - 1]) neighbors++;
        }
        if (j < GameState.width - 1) {
            if (currentMove[i][j + 1]) neighbors++;
            if (i > 0) if (currentMove[i - 1][j + 1]) neighbors++;
            if (i < GameState.height - 1) if (currentMove[i + 1][j + 1]) neighbors++;

        }
        if (i > 0) if (currentMove[i - 1][j]) neighbors++;
        if (i < GameState.height - 1) if (currentMove[i + 1][j]) neighbors++;
        if (neighbors == 3) return true;
        if (currentMove[i][j] && neighbors == 2) return true;
        return false;
    }

    @Override
    public void update(boolean[][] current, boolean[][] next, boolean playState, int count) {
        this.currentMove = current;
        this.nextMove = next;
        this.play = playState;
        this.count = count;
    }

    private boolean isHaveAlive() {
        for (int i = 0; i < GameState.height; i++) {
            for (int j = 0; j < GameState.width; j++) {
                if (currentMove[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isModified() {
        int count = 0;
        for (int i = 0; i < GameState.height; i++) {
            for (int j = 0; j < GameState.width; j++) {
                if (currentMove[i][j] == nextMove[i][j]) {
                    count++;
                }
            }
        }
        if (count == (GameState.height * GameState.width)) {
            return false;
        }
        return true;
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
