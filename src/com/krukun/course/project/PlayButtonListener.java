package com.krukun.course.project;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Eugeniy Krukun on 02.05.2016.
 */
public class PlayButtonListener implements ButtonListener {

    @Override
    public MouseAdapter getButtonAdapter(final GameButton button) {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                GameState.play =! GameState.play;
                if( GameState.play)button.setText("Pause");
                else button.setText("Play");
            }
        };
    }
}
