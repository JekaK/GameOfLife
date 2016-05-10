package com.krukun.course.project;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.util.EventListener;

/**
 * Created by Eugeniy Krukun on 01.05.2016.
 */
public class GamePanelMouseMotionListener implements PanelListener, Observer {
    private GamePanel panel;
    private boolean play;
    private boolean[][] currentMove = new boolean[GameState.height][GameState.width], nextMove = new boolean[GameState.height][GameState.width];
    private int count;

    public GamePanelMouseMotionListener() {
        panel = GamePanel.getInstance();
        panel.getState().registerObserver(this);
    }

    @Override
    public EventListener getListener() {
        return new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int j = GameState.width * e.getX() / panel.getWidth();
                int i = GameState.height * e.getY() / panel.getHeight();
                if(i>=0&&j>=0&&i<GameState.height&&j<GameState.width) {
                    if (SwingUtilities.isLeftMouseButton(e)) {
                        currentMove[i][j] = true;
                    } else {
                        currentMove[i][j] = false;
                    }
                    panel.getState().setData(currentMove, nextMove, play, count);
                    panel.myRepaint(panel.getOffScrGraph());
                }
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
