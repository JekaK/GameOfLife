package com.krukun.course.project;

import java.awt.event.MouseAdapter;

/**
 * Created by Eugeniy Krukun on 04.05.2016.
 */
public class ButtonListenerFactory {

    public ButtonListenerFactory() {
    }

    public ButtonListener getAdapter(String name) {
        if (name.equals("Play")) {
            return new PlayButtonListener();
        }
        if (name.equals("Reset")) {
            return new ResetButtonListener( );
        }
        if (name.equals("Randomize")) {
            return new RandomizeButtonListener();
        }
        if(name.equals("LeftTop")){
            return new LeftTopGliderListener();
        }
        if(name.equals("LeftDown")){
            return new LeftDownGliderListener();
        }
        if(name.equals("RightTop")){
            return new RightTopGliderListener();
        }
        if(name.equals("RightDown")){
            return new RightDownGliderListener();
        }
        return null;
    }
}
