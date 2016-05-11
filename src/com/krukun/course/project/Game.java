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

        CompositeGameControlsPanel leftControlPanel = new CompositeGameControlsPanel(15, 1,150,10);
        leftControlPanel.add(new InfoLabel("Gliders: "));

        GameButton leftTop = new GameButton();
        leftTop.setIcon(new ImageIcon("src\\com\\krukun\\course\\project\\gliders\\leftTop.GIF"));
        leftTop.setPlace(BorderLayout.CENTER);
        leftTop.addListener(new LeftTopGliderListener());

        GameButton leftDown = new GameButton();
        leftDown.setIcon(new ImageIcon("src\\com\\krukun\\course\\project\\gliders\\leftDown.GIF"));
        leftDown.setPlace(BorderLayout.CENTER);
        leftDown.addListener(new LeftDownGliderListener());

        GameButton rightTop = new GameButton();
        rightTop.setIcon(new ImageIcon("src\\com\\krukun\\course\\project\\gliders\\rightTop.GIF"));
        rightTop.setPlace(BorderLayout.CENTER);
        rightTop.addListener(new RightTopGliderListener());

        GameButton rightDown = new GameButton();
        rightDown.setIcon(new ImageIcon("src\\com\\krukun\\course\\project\\gliders\\rightDown.GIF"));
        rightDown.setPlace(BorderLayout.CENTER);
        rightDown.addListener(new RightDownGliderListener());

        InfoLabel leftTopLabel = new InfoLabel("Left-Top glider:");
        InfoLabel leftDownLabel = new InfoLabel("Left-Down glider:");
        InfoLabel rightTopLabel = new InfoLabel("Right-Top glider:");
        InfoLabel rightDownLabel = new InfoLabel("Right-Down glider:");

        leftControlPanel.add(leftTopLabel);
        leftControlPanel.add(leftTop);

        leftControlPanel.add(leftDownLabel);
        leftControlPanel.add(leftDown);

        leftControlPanel.add(rightTopLabel);
        leftControlPanel.add(rightTop);

        leftControlPanel.add(rightDownLabel);
        leftControlPanel.add(rightDown);

        GameButton faq = new GameButton("FAQ");
        faq.addListener(new FAQButtonListener());
        leftControlPanel.add(faq);

        leftControlPanel.setPlace(BorderLayout.WEST);
        mainPanel.add(leftControlPanel);

        window.add(mainPanel.goToGame());
        window.addKeyListener(new MementoListener());
        GameLogic logic = new GameLogic(gameState);
        logic.startThinking();
    }

}
