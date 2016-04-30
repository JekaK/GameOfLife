package com.krukun.course.project;

import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Eugeniy Krukun on 30.04.2016.
 */
public class GameWindow extends JFrame{

    public GameWindow()  {
       super("Game of Life");
       setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       setSize(400, 400);
       setLocationRelativeTo(null);
       setVisible(true);
    }

}
