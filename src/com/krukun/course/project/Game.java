package com.krukun.course.project;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Eugeniy Krukun on 30.04.2016.
 */
public class Game {
    private GameWindow window;
    private BasePanel mainPanel;
    private GamePanel gamePanel;
    private CompositeGameControlsPanel controlPanel;
    private GameButton playButton, randomizeButton, resetButton;


    public Game() {
        initUI();
    }

    public void initUI() {
        window = new GameWindow();
        mainPanel = new BasePanel(new BorderLayout());
        gamePanel = new GamePanel();

        playButton = new GameButton("Play");
        randomizeButton = new GameButton("Randomize it!");
        resetButton = new GameButton("Reset");

        playButton.addListener(new PlayButtonListener());
        resetButton.addListener(new ResetButtonListener(gamePanel));

        controlPanel = new CompositeGameControlsPanel(1, 3);
        controlPanel.add(playButton);
        controlPanel.add(randomizeButton);
        controlPanel.add(resetButton);

        mainPanel.add(gamePanel);
        mainPanel.add(controlPanel.goToGame(), BorderLayout.PAGE_END);

        window.add(mainPanel.goToGame());
        GameLogic logic = new GameLogic(gamePanel);
    }
}
