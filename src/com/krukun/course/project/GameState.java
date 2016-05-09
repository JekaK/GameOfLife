package com.krukun.course.project;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eugeniy Krukun on 01.05.2016.
 */
public class GameState implements Observable {
    private static List<Observer> observers;
    private boolean play = false;
    public final static int width = 100, height = 50;
    private boolean[][] currentMove = new boolean[height][width], nextMove = new boolean[height][width];
    private int count = 0;

    public GameState() {
        observers = new ArrayList<Observer>();
    }
    public GameState(boolean[][] state){
        this.currentMove = state;
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyAllObservers() {
        for (Observer i : observers) {
            i.update(currentMove, nextMove, play, count);
        }
    }

    public void setData(boolean[][] currentMove, boolean[][] nextMove, boolean play, int count) {
        this.currentMove = currentMove;
        this.nextMove = nextMove;
        this.play = play;
        this.count = count;
        notifyAllObservers();
    }
    public boolean[][] getState(){
        return currentMove;
    }

}
