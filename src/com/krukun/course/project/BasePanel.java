package com.krukun.course.project;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Eugeniy Krukun on 30.04.2016.
 */
public class BasePanel  implements CompositeInterface {
    private JPanel panel;
    private ArrayList<CompositeInterface> arrayList;

    public BasePanel() {
        panel = new JPanel();
        panel.setLayout(new GridLayout());
        arrayList = new ArrayList<CompositeInterface>();
    }
    public BasePanel(LayoutManager manager){
        panel = new JPanel(manager);
        arrayList = new ArrayList<CompositeInterface>();
    }
    public BasePanel(int rows, int cols) {
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
            panel.add(i.goToGame());
        }
        return panel;
    }

    public void add(JComponent component, String path) {
        panel.add(component,path);
    }
}
