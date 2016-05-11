package com.krukun.course.project;


import javax.swing.*;

/**
 * Created by Eugeniy Krukun on 30.04.2016.
 */
public class GameButton  implements CompositeInterface {
    private JButton button;
    private String place;

    public GameButton() {
        button = new JButton();
        button.setVisible(true);
        button.setFocusable(false);
    }

    public GameButton(String name) {
        button = new JButton();
        button.setText(name);
        button.setVisible(true);
        button.setFocusable(false);
    }
    public void setIcon(ImageIcon icon){
        button.setIcon(icon);
        button.setSize(icon.getIconWidth(),icon.getIconHeight());
    }
    public void setText(String name){
        button.setText(name);
    }
    @Override
    public JComponent goToGame() {
        return button;
    }
    public void addListener(ButtonListener buttonListener){
        button.addMouseListener(buttonListener.getButtonAdapter());
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
