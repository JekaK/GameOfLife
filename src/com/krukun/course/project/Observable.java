package com.krukun.course.project;

/**
 * Created by Eugeniy Krukun on 03.05.2016.
 */
public interface Observable {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyAllObservers();
}
