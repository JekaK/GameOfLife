package com.krukun.course.project;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Eugeniy Krukun on 02.05.2016.
 */
public class ResetButtonListener implements ButtonListener {
    private GamePanel panel;

    public ResetButtonListener(GamePanel panel) {
        this.panel = panel;
    }

    @Override
    public MouseAdapter getButtonAdapter(GameButton button) {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                GameState.currentMove = new boolean[GameState.height][GameState.width];
                panel.myRepaint(panel.getOffScrGraph());
            }
        };
    }
}
