package com.krukun.course.project;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Eugeniy Krukun on 06.05.2016.
 */
public class FAQButtonListener implements ButtonListener {

    @Override
    public MouseListener getButtonAdapter() {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null,
                        "The universe of the Game of Life is an infinite two-dimensional orthogonal grid of square cells, each of which is in one of two possible states, alive or dead.\n" +
                                "Every cell interacts with its eight neighbours, which are the cells that are horizontally, vertically, or diagonally adjacent. \n" +
                                "At each step in time, the following transitions occur:\n" +
                                "\n" +
                                "           1.Any live cell with fewer than two live neighbours dies, as if caused by under-population.\n" +
                                "           2.Any live cell with two or three live neighbours lives on to the next generation.\n" +
                                "           3.Any live cell with more than three live neighbours dies, as if by over-population.\n" +
                                "           4.Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.\n" +
                                "\n" +
                                "The initial pattern constitutes the seed of the system." +
                                "\nThe first generation is created by applying the above rules simultaneously to every cell in the seed—births and deaths occur simultaneously, \n" +
                                "and the discrete moment at which this happens is sometimes called a tick (in other words, each generation is a pure function of the preceding one).\n" +
                                "The rules continue to be applied repeatedly to create further generations.",
                        "Game of Life rules",
                        JOptionPane.PLAIN_MESSAGE);
            }
        };
    }
}
