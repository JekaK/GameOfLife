package com.krukun.course.project;

import java.util.EventListener;

/**
 * Created by Eugeniy Krukun on 01.05.2016.
 */
public class PanelListenerFactoryMethod {

    public PanelListenerFactoryMethod() {
    }

    public PanelListener getListenerForPanel(String name,GameState state){
        PanelListener listener = null;
        if(name.equals("Component")){
            listener = new GamePanelComponentListener();
        }
        if(name.equals("Adapter")){
            listener = new GamePanelMouseAdapter();
        }
        if(name.equals("Motion")){
            listener =  new GamePanelMouseMotionListener();
        }
        return listener;
    }
}
