package com.krukun.course.project;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Eugeniy Krukun on 30.04.2016.
 */
public class CompositePanel implements CompositeInterface {
    private JPanel panel;
    private ArrayList<CompositeInterface> arrayList;
    private String place;
    public CompositePanel() {
        panel = new JPanel();
        panel.setLayout(new GridLayout());
        arrayList = new ArrayList<CompositeInterface>();
    }
    public CompositePanel(LayoutManager manager){
        panel = new JPanel(manager);
        arrayList = new ArrayList<CompositeInterface>();
    }
    public CompositePanel(int rows, int cols) {
        panel = new JPanel();
        panel.setLayout(new GridLayout(rows, cols));
        arrayList = new ArrayList<CompositeInterface>();
    }

    public void add(CompositeInterface component) {
        arrayList.add(component);
    }
    @Override
    public JComponent goToGame() {
        for (CompositeInterface i:arrayList){
            if(i.getPlace()==null){
                panel.add(i.goToGame());
            }
            else {
                panel.add(i.goToGame(),i.getPlace());
            }
        }
        return panel;
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
