package com.krukun.course.project;

/**
 * Created by Eugeniy Krukun on 01.05.2016.
 */
public class GameState {
    public static boolean play = false;
    public final static int width = 100, height = 50;
    public static boolean[][] currentMove = new boolean[height][width], nextMove = new boolean[height][width];

}
