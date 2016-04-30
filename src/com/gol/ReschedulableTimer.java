package com.gol;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Eugeniy Krukun on 19.04.2016.
 */
public class ReschedulableTimer extends Timer
{
    private Runnable  task;
    private TimerTask timerTask;

    public void schedule(Runnable runnable, long delay)
    {
        task = runnable;
        timerTask = new TimerTask()
        {
            @Override
            public void run()
            {
                task.run();
            }
        };
        this.schedule(timerTask, delay);
    }

    public void reschedule(long delay)
    {
        timerTask.cancel();
        timerTask = new TimerTask()
        {
            @Override
            public void run()
            {
                task.run();
            }
        };
        this.schedule(timerTask, delay);
    }
}