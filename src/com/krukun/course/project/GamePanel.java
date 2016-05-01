package com.krukun.course.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Eugeniy Krukun on 30.04.2016.
 */
public class GamePanel extends JPanel implements CompositeInterface {

    private Image offScrImg;
    private Graphics offScrGraph;
    private GameState state;

    public GamePanel() {
        setLayout(new GridLayout());
        setBackground(Color.GRAY);
        setSize(400, 400);
        state = new GameState();
        initListeners();

    }

    public Image getOffScrImg() {
        return offScrImg;
    }

    public void setOffScrImg(Image offScrImg) {
        this.offScrImg = offScrImg;
    }

    public void setOffScrGraph(Graphics offScrGraph) {
        this.offScrGraph = offScrGraph;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        myRepaint(g);

    }

    public void myRepaint(Graphics g) {
        offScrGraph = g;
        offScrGraph.setColor(getBackground());
        offScrGraph.fillRect(0, 0, getWidth(), getHeight());
        for (int i = 0; i < state.getHeight(); i++) {
            for (int j = 0; j < state.getWidth(); j++) {
                if (state.getCurrentMove()[i][j]) {
                    offScrGraph.setColor(Color.YELLOW);
                    int x = j * getWidth() / state.getWidth();
                    int y = i * getHeight() / state.getHeight();
                    offScrGraph.fillRect(x, y, getWidth() / state.getWidth(), getHeight() / state.getHeight());
                }
            }
        }
        offScrGraph.setColor(Color.BLACK);
        for (int i = 1; i < state.getHeight(); i++) {
            int y = i * getHeight() / state.getHeight();
            offScrGraph.drawLine(0, y, getWidth(), y);
        }
        for (int i = 1; i < state.getWidth(); i++) {
            int x = i * getWidth() / state.getWidth();
            offScrGraph.drawLine(x, 0, x, getHeight());
        }
        getGraphics().drawImage(offScrImg, 0, 0, this);
    }

    @Override
    public JComponent goToGame() {
        return this;
    }

    public void initListeners() {
        ListenerFactory factory = new ListenerFactory(this);
        this.addComponentListener((ComponentListener) factory.getListenerForPanel("Component"));
        this.addMouseListener((MouseListener) factory.getListenerForPanel("Adapter"));
        this.addMouseMotionListener((MouseMotionListener) factory.getListenerForPanel("Motion"));
    }
    public Graphics getOffScrGraph() {
        return offScrGraph;
    }

}
