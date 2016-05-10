package com.krukun.course.project;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Created by Eugeniy Krukun on 03.05.2016.
 */
public class InfoLabel implements CompositeInterface {
    private JLabel label;
    private String place;

    public InfoLabel() {
        label = new JLabel();
    }

    public InfoLabel(String name) {
        label = new JLabel(name);
    }

    @Override
    public JComponent goToGame() {
        return label;
    }
    public void setIcon(ImageIcon icon){
        label.setIcon(icon);
        label.setHorizontalAlignment(JLabel.CENTER);
        Border border = LineBorder.createGrayLineBorder();
        label.setBorder(border);
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
