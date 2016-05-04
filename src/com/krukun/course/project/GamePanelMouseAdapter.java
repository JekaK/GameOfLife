package com.krukun.course.project;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.EventListener;

/**
 * Created by Eugeniy Krukun on 01.05.2016.
 */
public class GamePanelMouseAdapter implements PanelListener,Observer {

    private GameState state;
    private boolean play;
    private boolean[][] currentMove = new boolean[GameState.height][GameState.width],nextMove = new boolean[GameState.height][GameState.width];
    private int count;

    public GamePanelMouseAdapter(GameState state) {
        this.state = state;
        state.registerObserver(this);
    }

    @Override
    public EventListener getListener(final GamePanel panel) {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int j = GameState.width * e.getX() / panel.getWidth();
                int i = GameState.height * e.getY() / panel.getHeight();
                currentMove[i][j] = !currentMove[i][j];
                panel.myRepaint(panel.getOffScrGraph());
                state.setData(currentMove,nextMove,play,count);
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
