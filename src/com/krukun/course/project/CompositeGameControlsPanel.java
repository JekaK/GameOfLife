package com.krukun.course.project;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Eugeniy Krukun on 30.04.2016.
 */
public class CompositeGameControlsPanel  implements CompositeInterface {
    private JPanel panel;
    private ArrayList<CompositeInterface> list = new ArrayList<CompositeInterface>();
    private String place;
    public CompositeGameControlsPanel(int row, int col) {
        panel = new JPanel(new GridLayout(row,col));
        panel.setVisible(true);
    }
    public CompositeGameControlsPanel(int row, int col,int width,int height) {
        panel = new JPanel(new GridLayout(row,col));

        panel.setPreferredSize(new Dimension(width,height));
        panel.setVisible(true);
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void add(CompositeInterface component){
        if(component==null){
            return;
        }
        list.add(component);
    }
    @Override
    public JComponent goToGame() {
        for(CompositeInterface i:list){
            panel.add(i.goToGame());
        }
        return panel;
    }


}
