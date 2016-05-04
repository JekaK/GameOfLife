package com.krukun.course.project;

import javax.swing.*;

/**
 * Created by Eugeniy Krukun on 03.05.2016.
 */
public class ColorsComboBox implements CompositeInterface {
    private JComboBox comboBox;
    private String place;

    public ColorsComboBox(String[] labels) {
        comboBox = new JComboBox(labels);
    }

    @Override
    public JComponent goToGame() {
        return comboBox;
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
