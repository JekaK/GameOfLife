package com.krukun.course.project;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Eugeniy Krukun on 11.05.2016.
 */
public class RightDownGliderListener implements ButtonListener,Observer {
    private GamePanel panel;
    private boolean play;
    private Point location;
    private MouseEvent pressed;
    private boolean[][] currentMove = new boolean[GameState.height][GameState.width], nextMove = new boolean[GameState.height][GameState.width];
    private int count;

    public RightDownGliderListener() {
        this.panel = GamePanel.getInstance();
        this.panel.getState().registerObserver(this);
    }

    @Override
    public MouseListener getButtonAdapter() {
        return new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                pressed = e;
            }

            @Override
            public void mouseReleased(MouseEvent e) {

                Component component = e.getComponent();
                location = component.getLocation(location);

                int x = location.x - (pressed.getComponent().getWidth() / 2) + e.getX();
                int y = location.y - (pressed.getComponent().getHeight() / 2) + e.getY();

                int j = (GameState.width * (x - ((pressed.getComponent().getWidth() / 2))) / panel.getWidth());
                int i = (GameState.height * (y - (pressed.getComponent().getHeight() / 2)) / panel.getHeight()) + 2;
                if(i>=0&&j>=0&&j-1>0&&i-1>0&&i<GameState.height&&j<GameState.width){
                    if(i<3){
                        i--;
                    }
                    currentMove[i][j] = true;
                    currentMove[++i][j] = true;
                    currentMove[i][--j] = true;
                    currentMove[i][--j] = true;
                    currentMove[i-=2][++j] = true;

                    panel.getState().setData(currentMove, nextMove, play, count);
                    panel.myRepaint(panel.getOffScrGraph());
                }
                pressed = null;

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
