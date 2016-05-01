package com.krukun.course.project;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.EventListener;

/**
 * Created by Eugeniy Krukun on 01.05.2016.
 */
public class MyMouseAdapter implements Listeners {
    private GameState state;
    public MyMouseAdapter() {
        state = new GameState();

    }

    @Override
    public EventListener getListener(final GamePanel panel) {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int j = state.getWidth() * e.getX() / panel.getWidth();
                int i = state.getHeight() * e.getY() / panel.getHeight();
                state.getCurrentMove()[i][j] = !state.getCurrentMove()[i][j];
                panel.myRepaint(panel.getOffScrGraph());
            }
        };
    }
}
