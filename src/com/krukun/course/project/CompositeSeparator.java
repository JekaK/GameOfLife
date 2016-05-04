package com.krukun.course.project;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Eugeniy Krukun on 03.05.2016.
 */
public class CompositeSeparator implements CompositeInterface {
    private JSeparator separator;
    private String place;
    public CompositeSeparator() {
        separator = new JSeparator(SwingConstants.HORIZONTAL);
    }

    @Override
    public JComponent goToGame() {
        return separator;
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
