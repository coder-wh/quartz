package com.test.jdktimer;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 */
public class TestTimer {
    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask task = new TestTimerTask();
        timer.schedule(task, 5000L, 1000L);

        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(4);
        executorService.schedule(() -> {
            System.out.println("aaaaaa");
        }, 6, TimeUnit.SECONDS);
    }
}
