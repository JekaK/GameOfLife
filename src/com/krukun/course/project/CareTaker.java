package com.krukun.course.project;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eugeniy Krukun on 04.05.2016.
 */
public class CareTaker {
    private List<GameState> gameStateList = new ArrayList<GameState>();

    public void add(GameState state){
        gameStateList.add(state);
    }
    public GameState get(int index){
        return gameStateList.get(index);
    }
}
