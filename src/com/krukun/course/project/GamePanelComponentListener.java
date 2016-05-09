package com.krukun.course.project;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.EventListener;

/**
 * Created by Eugeniy Krukun on 01.05.2016.
 */
public class GamePanelComponentListener implements PanelListener {
    private GamePanel panel;
    public GamePanelComponentListener() {
        panel = GamePanel.getInstance();
    }

    @Override
    public EventListener getListener() {

        return new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent e) {
                panel.setOffScrImg(panel.createImage(panel.getWidth(), panel.getHeight()));
                panel.setOffScrGraph(panel.getOffScrImg().getGraphics());
                panel.myRepaint(panel.getOffScrGraph());
            }
            @Override
            public void componentMoved(ComponentEvent e) {

            }

            @Override
            public void componentShown(ComponentEvent e) {

            }

            @Override
            public void componentHidden(ComponentEvent e) {

            }

        };
    }
}
