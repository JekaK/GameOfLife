package com.krukun.course.project;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.EventListener;

/**
 * Created by Eugeniy Krukun on 01.05.2016.
 */
public class MyMouseMotionListener implements Listeners{
    private GameState state;

    public MyMouseMotionListener() {
        state = new GameState();
    }

    @Override
    public EventListener getListener(final GamePanel panel) {
        return new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int j = state.getWidth() * e.getX() / panel.getWidth();
                int i = state.getHeight() * e.getY() / panel.getHeight();
                if (SwingUtilities.isLeftMouseButton(e)) {
                    state.getCurrentMove()[i][j] = true;
                } else {
                    state.getCurrentMove()[i][j] = false;
                }
                panel.myRepaint(panel.getOffScrGraph());
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        };
    }
}
