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

    public CompositeGameControlsPanel(int row, int col) {
        panel = new JPanel(new GridLayout(row,col));
        panel.setVisible(true);
    }
    public void add(CompositeInterface component){
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
