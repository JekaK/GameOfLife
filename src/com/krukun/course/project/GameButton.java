package com.krukun.course.project;


import javax.swing.*;

/**
 * Created by Eugeniy Krukun on 30.04.2016.
 */
public class GameButton  implements CompositeInterface {
    private JButton button;
    public GameButton(String name) {
        button = new JButton();
        button.setText(name);
        button.setVisible(true);
    }

    @Override
    public JComponent goToGame() {
        return button;
    }
}
