package com.krukun.course.project;

import java.awt.event.MouseAdapter;

/**
 * Created by Eugeniy Krukun on 04.05.2016.
 */
public class ButtonListenerFactoryMethod {

    public ButtonListenerFactoryMethod() {
    }

    public ButtonListener getAdapter(String name) {
        ButtonListener listener = null;
        if (name.equals("Play")) {
            listener = new PlayButtonListener();
        }
        if (name.equals("Reset")) {
            listener = new ResetButtonListener( );
        }
        if (name.equals("Randomize")) {
            listener = new RandomizeButtonListener();
        }
        if(name.equals("LeftTop")){
            listener = new LeftTopGliderListener();
        }
        if(name.equals("LeftDown")){
            listener = new LeftDownGliderListener();
        }
        if(name.equals("RightTop")){
            listener = new RightTopGliderListener();
        }
        if(name.equals("RightDown")){
            listener = new RightDownGliderListener();
        }
        return listener ;
    }
}
