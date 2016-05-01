package com.krukun.course.project;

/**
 * Created by Eugeniy Krukun on 01.05.2016.
 */
public class GameState {
    private final static int width = 100, height = 50;
    private static boolean[][] currentMove = new boolean[height][width], nextMove = new boolean[height][width];

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean[][] getCurrentMove() {
        return currentMove;
    }

    public boolean[][] getNextMove() {
        return nextMove;
    }

    public void setCurrentMove(boolean[][] currentMove) {
        this.currentMove = currentMove;
    }

    public void setNextMove(boolean[][] nextMove) {
        this.nextMove = nextMove;
    }
}
