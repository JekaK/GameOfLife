package com.gol;

import javax.swing.*;

/**
 * Created by kruku on 12.04.2016.
 */
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GameOfLife();
            }
        });
    }
}
