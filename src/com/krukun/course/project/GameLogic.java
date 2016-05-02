package com.krukun.course.project;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Eugeniy Krukun on 02.05.2016.
 */
public class GameLogic {
    private GamePanel panel;

    public GameLogic(GamePanel panel) {
        this.panel = panel;
        time = new Timer();
        time.scheduleAtFixedRate(timer,0,100);
    }

    Timer time;
    TimerTask timer = new TimerTask() {
        @Override
        public void run() {
            if( GameState.play){
                for (int i = 0; i < GameState.height ; i++) {
                    for (int j = 0; j < GameState.width ; j++) {
                        GameState.nextMove[i][j] = decide(i,j);
                    }
                }
                for (int i = 0; i < GameState.height ; i++) {
                    for (int j = 0; j < GameState.width ; j++) {
                        GameState.currentMove[i][j] =  GameState.nextMove[i][j];
                    }
                }
               panel.myRepaint(panel.getOffScrGraph());
            }

        }
    };
    public boolean decide(int i,int j){
        int neighbors = 0;
        if(j>0){
            if(GameState.currentMove[i][j-1])neighbors++;
            if(i>0)if(GameState.currentMove[i-1][j-1]) neighbors++;
            if(i<GameState.height-1)if(GameState.currentMove[i+1][j-1])neighbors++;
        }
        if(j<GameState.width-1){
            if(GameState.currentMove[i][j+1])neighbors++;
            if(i>0)if(GameState.currentMove[i-1][j+1]) neighbors++;
            if(i<GameState.height-1)if(GameState.currentMove[i+1][j+1])neighbors++;

        }
        if(i>0) if(GameState.currentMove[i-1][j])neighbors++;
        if(i<GameState.height-1) if(GameState.currentMove[i+1][j])neighbors++;
        if(neighbors==3)return true;
        if(GameState.currentMove[i][j]&&neighbors==2)return true;
        return false;
    }
}
