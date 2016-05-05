package com.krukun.course.project;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Eugeniy Krukun on 04.05.2016.
 */
public class CareTaker {
    private static LinkedList<GameState> gameStateList = new LinkedList<GameState>();
    private static int current = 0;

    public void add(GameState state) {
        if (current < gameStateList.size()) {
            for (int i = gameStateList.size()-1; i >= current-1; i--) {
                gameStateList.remove(gameStateList.get(i));
            }
        }
        gameStateList.add(state);
    }

    public int getListSize() {
        return gameStateList.size();
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public GameState get(int index) {
        return gameStateList.get(index);
    }

}
