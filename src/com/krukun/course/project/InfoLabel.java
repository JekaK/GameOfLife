package com.krukun.course.project;

import javax.swing.*;

/**
 * Created by Eugeniy Krukun on 03.05.2016.
 */
public class InfoLabel implements CompositeInterface {
    private JLabel label;
    private String place;

    public InfoLabel(String name) {
        label = new JLabel(name);
    }

    @Override
    public JComponent goToGame() {
        return label;
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
