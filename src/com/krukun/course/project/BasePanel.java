package com.krukun.course.project;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Eugeniy Krukun on 30.04.2016.
 */
public class BasePanel  implements CompositeInterface{
    private JPanel panel;

    public BasePanel() {
        panel = new JPanel();
        panel.setLayout(new GridLayout());
    }
    public BasePanel(LayoutManager manager){
        panel = new JPanel(manager);
    }
    public BasePanel(int rows, int cols) {
        panel = new JPanel();
        panel.setLayout(new GridLayout(rows, cols));
    }

    public void add(JComponent component) {
        panel.add(component);
    }
    @Override
    public JComponent goToGame() {
        return panel;
    }

    public void add(JComponent component, String path) {
        panel.add(component,path);
    }
}
