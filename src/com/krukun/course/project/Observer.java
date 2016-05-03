package com.krukun.course.project;

/**
 * Created by Eugeniy Krukun on 03.05.2016.
 */
public interface Observer {
    public void update(boolean[][]current,boolean [][] next,boolean playState,int count);
}
