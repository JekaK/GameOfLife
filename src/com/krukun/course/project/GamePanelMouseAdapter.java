package com.krukun.course.project;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.EventListener;

/**
 * Created by Eugeniy Krukun on 01.05.2016.
 */
public class GamePanelMouseAdapter implements PanelListener,Observer {

    private GamePanel panel;
    private boolean play;
    private boolean[][] currentMove = new boolean[GameState.height][GameState.width],nextMove = new boolean[GameState.height][GameState.width];
    private int count;

    public GamePanelMouseAdapter() {
        panel = GamePanel.getInstance();
        panel.getState().registerObserver(this);
    }

    @Override
    public EventListener getListener() {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int j = GameState.width * e.getX() / panel.getWidth();
                int i = GameState.height * e.getY() / panel.getHeight();
                currentMove[i][j] = !currentMove[i][j];
                panel.getState().setData(currentMove, nextMove, play, count);
                panel.myRepaint(panel.getOffScrGraph());
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
