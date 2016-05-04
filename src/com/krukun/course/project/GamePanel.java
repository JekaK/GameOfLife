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
    private String place;



    public GamePanel(GameState state) {
        setLayout(new GridLayout());
        setBackground(Color.GRAY);
        setSize(400, 400);
        this.state = state;

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
        for (int i = 0; i < GameState.height; i++) {
            for (int j = 0; j < GameState.width; j++) {
                if (state.getState()[i][j]) {
                    offScrGraph.setColor(Color.YELLOW);
                    int x = j * getWidth() / GameState.width;
                    int y = i * getHeight() / GameState.height;
                    offScrGraph.fillRect(x, y, getWidth() / GameState.width, getHeight() / GameState.height);
                }
            }
        }
        offScrGraph.setColor(Color.BLACK);
        for (int i = 1; i < GameState.height; i++) {
            int y = i * getHeight() / GameState.height;
            offScrGraph.drawLine(0, y, getWidth(), y);
        }
        for (int i = 1; i < GameState.width; i++) {
            int x = i * getWidth() / GameState.width;
            offScrGraph.drawLine(x, 0, x, getHeight());
        }
        getGraphics().drawImage(offScrImg, 0, 0, this);

    }

    @Override
    public JComponent goToGame() {
        return this;
    }

    public void initListeners() {
        PanelListenerFactory factory = new PanelListenerFactory(this);
        this.addComponentListener((ComponentListener) factory.getListenerForPanel("Component", state));
        this.addMouseListener((MouseListener) factory.getListenerForPanel("Adapter", state));
        this.addMouseMotionListener((MouseMotionListener) factory.getListenerForPanel("Motion", state));
    }

    public Graphics getOffScrGraph() {
        return offScrGraph;
    }


    @Override
    public String getPlace() {
        return place;
    }

    @Override
    public void setPlace(String place) {
        this.place = place;
    }
}
