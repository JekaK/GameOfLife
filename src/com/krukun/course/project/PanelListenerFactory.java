package com.krukun.course.project;

import java.util.EventListener;

/**
 * Created by Eugeniy Krukun on 01.05.2016.
 */
public class PanelListenerFactory {

    public PanelListenerFactory() {

    }

    public EventListener getListenerForPanel(String name,GameState state){
        if(name.equals("Component")){
            return new GamePanelComponentListener().getListener();
        }
        if(name.equals("Adapter")){
            return new GamePanelMouseAdapter().getListener();
        }
        if(name.equals("Motion")){
            return  new GamePanelMouseMotionListener().getListener();
        }
        return null;
    }
}
