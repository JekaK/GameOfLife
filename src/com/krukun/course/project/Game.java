package com.krukun.course.project;

import javax.swing.*;
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
        GameState gameState = new GameState();
        window = new GameWindow();
        mainPanel = new CompositePanel(new BorderLayout());
        gamePanel = new GamePanel(gameState);

        playButton = new GameButton("Play");
        randomizeButton = new GameButton("Randomize it!");
        resetButton = new GameButton("Reset");

        ButtonListenerFactory factory = new ButtonListenerFactory(gameState, gamePanel);
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
        someControlPanel.add(new GameButton("FAQ"));

        someControlPanel.setPlace(BorderLayout.WEST);
        mainPanel.add(someControlPanel);

        window.add(mainPanel.goToGame());
        GameLogic logic = new GameLogic(gamePanel, gameState);
        logic.startThinking();

        /*Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();
        originator.setCurrentMove(new boolean[][]{{true,false}});
        careTaker.add(originator.saveStateToMemento());
        originator.setCurrentMove(new boolean[][]{{false,true}});
        careTaker.add(originator.saveStateToMemento());
        */

    }
}
