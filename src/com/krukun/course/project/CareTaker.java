package com.krukun.course.project;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eugeniy Krukun on 04.05.2016.
 */
public class CareTaker {
    private static List<boolean[][]> gameStateList = new ArrayList<boolean[][]>();

    public void add(boolean[][] state) {
        gameStateList.add(state);
    }

    public int getListSize() {
        return gameStateList.size();
    }

    public boolean[][] get(int index) {
        return gameStateList.get(index);
    }
}
