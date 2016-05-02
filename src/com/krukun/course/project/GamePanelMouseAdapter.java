package com.krukun.course.project;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.EventListener;

/**
 * Created by Eugeniy Krukun on 01.05.2016.
 */
public class GamePanelMouseAdapter implements PanelListener {
    private GameState state;

    public GamePanelMouseAdapter() {
        state = new GameState();
    }

    @Override
    public EventListener getListener(final GamePanel panel) {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int j = GameState.width * e.getX() / panel.getWidth();
                int i = GameState.height * e.getY() / panel.getHeight();
                GameState.currentMove[i][j] = !GameState.currentMove[i][j];
                panel.myRepaint(panel.getOffScrGraph());
            }
        };
    }
}
