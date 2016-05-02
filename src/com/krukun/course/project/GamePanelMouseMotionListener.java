package com.krukun.course.project;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.EventListener;

/**
 * Created by Eugeniy Krukun on 01.05.2016.
 */
public class GamePanelMouseMotionListener implements PanelListener {
    private GameState state;

    public GamePanelMouseMotionListener() {
        state = new GameState();
    }

    @Override
    public EventListener getListener(final GamePanel panel) {
        return new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int j = GameState.width * e.getX() / panel.getWidth();
                int i = GameState.height * e.getY() / panel.getHeight();
                if (SwingUtilities.isLeftMouseButton(e)) {
                    GameState.currentMove[i][j] = true;
                } else {
                   GameState.currentMove[i][j] = false;
                }
                panel.myRepaint(panel.getOffScrGraph());
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        };
    }
}
