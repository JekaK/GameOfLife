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
        GameState gameState = new GameState();
        window = new GameWindow();
        mainPanel = new BasePanel(new BorderLayout());
        gamePanel = new GamePanel(gameState);

        playButton = new GameButton("Play");
        randomizeButton = new GameButton("Randomize it!");
        resetButton = new GameButton("Reset");

        playButton.addListener(new PlayButtonListener(gameState));
        resetButton.addListener(new ResetButtonListener(gamePanel,gameState));
        randomizeButton.addListener(new RandomizeButtonListener(gamePanel,gameState));

        controlPanel = new CompositeGameControlsPanel(1, 3);
        controlPanel.add(playButton);
        controlPanel.add(randomizeButton);
        controlPanel.add(resetButton);

        mainPanel.add(gamePanel);
        mainPanel.add(controlPanel.goToGame(), BorderLayout.PAGE_END);

        window.add(mainPanel.goToGame());
        GameLogic logic = new GameLogic(gamePanel,gameState);
        logic.startThinking();
    }
}
