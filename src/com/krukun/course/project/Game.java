package com.krukun.course.project;

import java.awt.*;

/**
 * Created by Eugeniy Krukun on 30.04.2016.
 */
public class Game {
    private GameWindow window;
    private CompositePanel mainPanel;
    private GamePanel gamePanel;
    private CompositeGameControlsPanel controlPanel;
    private GameButton playButton, randomizeButton, resetButton;

    public Game() {
        initUI();
    }

    public void initUI() {
        final GameState gameState = new GameState();
        window = new GameWindow();
        mainPanel = new CompositePanel(new BorderLayout());
        gamePanel = GamePanel.getInstance();
        gamePanel.setState(gameState);

        playButton = new GameButton("Play");
        randomizeButton = new GameButton("Randomize it!");
        resetButton = new GameButton("Reset");

        ButtonListenerFactory factory = new ButtonListenerFactory();
        playButton.addListener(factory.getAdapter("Play"));
        resetButton.addListener(factory.getAdapter("Reset"));
        randomizeButton.addListener(factory.getAdapter("Randomize"));

        controlPanel = new CompositeGameControlsPanel(1, 3);
        controlPanel.add(playButton);
        controlPanel.add(randomizeButton);
        controlPanel.add(resetButton);

        mainPanel.add(gamePanel);
        controlPanel.setPlace(BorderLayout.PAGE_END);
        mainPanel.add(controlPanel);

        CompositeGameControlsPanel someControlPanel = new CompositeGameControlsPanel(20, 1, 150, 3);
        someControlPanel.add(new InfoLabel(" Chose color:"));
        someControlPanel.add(new ColorsComboBox(new String[]{"Red", "Green", "Blue"}));
        someControlPanel.add(new InfoLabel(" Chose rules:"));
        GameButton next = new GameButton("Next");
        next.addListener(new NextButtonListener());

        someControlPanel.add(next);
        GameButton prev = new GameButton("Prev");
        prev.addListener(new PreviousButtonListener());


        someControlPanel.add(prev);
        someControlPanel.add(new GameButton("FAQ"));

        someControlPanel.setPlace(BorderLayout.WEST);
        mainPanel.add(someControlPanel);

        window.add(mainPanel.goToGame());
        GameLogic logic = new GameLogic( gameState);
        logic.startThinking();

    }
}
