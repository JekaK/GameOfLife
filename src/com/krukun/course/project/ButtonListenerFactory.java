package com.krukun.course.project;

import java.awt.event.MouseAdapter;

/**
 * Created by Eugeniy Krukun on 04.05.2016.
 */
public class ButtonListenerFactory {
    private GameState state;
    private GamePanel panel;

    public ButtonListenerFactory(GameState state, GamePanel panel) {
        this.state = state;
        this.panel = panel;
    }

    public ButtonListener getAdapter(String name) {
        if (name.equals("Play")) {
            return new PlayButtonListener(state);
        }
        if (name.equals("Reset")) {
            return new ResetButtonListener(panel, state);
        }
        if (name.equals("Randomize")) {
            return new RandomizeButtonListener(panel, state);
        }
        return null;
    }
}
