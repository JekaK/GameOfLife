package com.krukun.course.project;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Eugeniy Krukun on 30.04.2016.
 */
public class GameConstructor {
    private GameWindow window;
    private CompositePanel mainPanel;
    private GamePanel gamePanel;
    private CompositeGameControlsPanel controlPanel, leftControlPanel;
    private GameButton playButton, randomizeButton, resetButton, leftTop, leftDown, rightTop, rightDown, faq;
    private InfoLabel leftTopLabel, leftDownLabel, rightTopLabel, rightDownLabel;
    private GameLogic logic;

    public GameConstructor() {

    }

    public void constructGame() {
        final GameState gameState = new GameState();
        window = new GameWindow();
        mainPanel = new CompositePanel(new BorderLayout());
        gamePanel = GamePanel.getInstance();
        gamePanel.setState(gameState);

        playButton = new GameButton("Play");
        randomizeButton = new GameButton("Randomize it!");
        resetButton = new GameButton("Reset");

        ButtonListenerFactoryMethod factory = new ButtonListenerFactoryMethod();
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

        leftControlPanel = new CompositeGameControlsPanel(15, 1, 150, 10);
        leftControlPanel.add(new InfoLabel("Gliders: "));

        leftTop = new GameButton();
        leftTop.setIcon(new ImageIcon("src\\com\\krukun\\course\\project\\gliders\\leftTop.GIF"));
        leftTop.setPlace(BorderLayout.CENTER);
        leftTop.addListener(factory.getAdapter("LeftTop"));

        leftDown = new GameButton();
        leftDown.setIcon(new ImageIcon("src\\com\\krukun\\course\\project\\gliders\\leftDown.GIF"));
        leftDown.setPlace(BorderLayout.CENTER);
        leftDown.addListener(factory.getAdapter("LeftDown"));

        rightTop = new GameButton();
        rightTop.setIcon(new ImageIcon("src\\com\\krukun\\course\\project\\gliders\\rightTop.GIF"));
        rightTop.setPlace(BorderLayout.CENTER);
        rightTop.addListener(factory.getAdapter("RightTop"));

        rightDown = new GameButton();
        rightDown.setIcon(new ImageIcon("src\\com\\krukun\\course\\project\\gliders\\rightDown.GIF"));
        rightDown.setPlace(BorderLayout.CENTER);
        rightDown.addListener(factory.getAdapter("RightDown"));

        leftTopLabel = new InfoLabel("Left-Top glider:");
        leftDownLabel = new InfoLabel("Left-Down glider:");
        rightTopLabel = new InfoLabel("Right-Top glider:");
        rightDownLabel = new InfoLabel("Right-Down glider:");

        leftControlPanel.add(leftTopLabel);
        leftControlPanel.add(leftTop);

        leftControlPanel.add(leftDownLabel);
        leftControlPanel.add(leftDown);

        leftControlPanel.add(rightTopLabel);
        leftControlPanel.add(rightTop);

        leftControlPanel.add(rightDownLabel);
        leftControlPanel.add(rightDown);

        faq = new GameButton("FAQ");
        faq.addListener(new FAQButtonListener());
        leftControlPanel.add(faq);

        leftControlPanel.setPlace(BorderLayout.WEST);
        mainPanel.add(leftControlPanel);

        window.add(mainPanel.goToGame());
        window.addKeyListener(new MementoListener());
        logic = new GameLogic(gameState);
        logic.startThinking();
    }

}
