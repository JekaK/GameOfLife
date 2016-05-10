package com.krukun.course.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

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

        CompositeGameControlsPanel someControlPanel = new CompositeGameControlsPanel(17, 1,150,10);
        someControlPanel.add(new InfoLabel("Gliders: "));
        InfoLabel label = new InfoLabel();

        label.setIcon(new ImageIcon("D:\\Development\\Patterns\\CourseProject\\src\\com\\krukun\\course\\project\\LIFE2.GIF"));
        label.setPlace(BorderLayout.CENTER);
        label.goToGame().addMouseListener(new DragAdapter().getButtonAdapter());

        someControlPanel.add(label);
        GameButton faq = new GameButton("FAQ");
        faq.addListener(new FAQButtonListener());
        someControlPanel.add(faq);

        someControlPanel.setPlace(BorderLayout.WEST);
        mainPanel.add(someControlPanel);

        window.add(mainPanel.goToGame());
        window.addKeyListener(new MementoListener());
        GameLogic logic = new GameLogic(gameState);
        logic.startThinking();

    }

}
