package com.krukun.course.project;

import java.util.EventListener;

/**
 * Created by Eugeniy Krukun on 01.05.2016.
 */
public class ListenerFactory {
    private GamePanel panel;

    public ListenerFactory(GamePanel panel) {
        this.panel = panel;
    }

    public EventListener getListenerForPanel(String name){
        if(name.equals("Component")){
            return new GamePanelComponentListener(panel).getListener(panel);
        }
        if(name.equals("Adapter")){
            return new GamePanelMouseAdapter().getListener(panel);
        }
        if(name.equals("Motion")){
            return  new GamePanelMouseMotionListener().getListener(panel);
        }
        return null;
    }
}
