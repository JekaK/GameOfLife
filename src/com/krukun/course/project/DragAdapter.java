package com.krukun.course.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Eugeniy Krukun on 07.05.2016.
 */
public class DragAdapter implements Observer {
    private GamePanel panel;
    private boolean play;
    private Point location;
    private MouseEvent pressed;
    private boolean[][] currentMove = new boolean[GameState.height][GameState.width], nextMove = new boolean[GameState.height][GameState.width];
    private int count;

    public DragAdapter() {
        this.panel = GamePanel.getInstance();
        this.panel.getState().registerObserver(this);
    }


    public MouseListener getButtonAdapter() {
        return new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                pressed = e;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                Component component = e.getComponent();
                location = component.getLocation(location);


                int x = location.x - (pressed.getComponent().getWidth()/2) + e.getX();
                int y = location.y - (pressed.getComponent().getHeight()/2) + e.getY();

                int j = (GameState.width * (x-((pressed.getComponent().getWidth()/2))) / panel.getWidth())+2;
                int i = (GameState.height * (y-(pressed.getComponent().getHeight()/2)) / panel.getHeight())+2;

                currentMove[i][j] = true;
                currentMove[i][--j] = true;
                currentMove[i][--j] = true;
                currentMove[++i][j] = true;
                currentMove[++i][++j] = true;
                panel.getState().setData(currentMove, nextMove, play, count);
                panel.myRepaint(panel.getOffScrGraph());
                System.out.println("released");
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

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
