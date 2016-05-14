package com.krukun.course.project;

import javax.swing.*;

/**
 * Created by Eugeniy Krukun on 30.04.2016.
 */
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GameConstructor gameConstructor = new GameConstructor();
                gameConstructor.constructGame();
            }
        });
    }
}
