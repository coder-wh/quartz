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
    private static int count = 0;
    public static void main(String[] args) {
        //单线程调度 不支持多个任务
//        Timer timer = new Timer();
//        TimerTask task = new TestTimerTask();
//        timer.schedule(task, 5000L, 1000L);

        //多线程执行 如果出现异常 定时任务会终止运行
        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(4);
        executorService.scheduleAtFixedRate(() -> {
            count++;
            System.out.println("aaaaaa");
            if(count == 3){
                throw new RuntimeException("任务出错了");
            }
        }, 1,2, TimeUnit.SECONDS);
    }
}
