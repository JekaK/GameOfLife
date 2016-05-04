package com.krukun.course.project;

/**
 * Created by Eugeniy Krukun on 04.05.2016.
 */
public class Originator {
    private boolean currentMove[][];

    public boolean[][] getCurrentMove() {
        return currentMove;
    }

    public void setCurrentMove(boolean[][] currentMove) {
        this.currentMove = currentMove;
    }

    public void getStateFromMemento(boolean [][] state) {
        this.currentMove = state;
    }
}
