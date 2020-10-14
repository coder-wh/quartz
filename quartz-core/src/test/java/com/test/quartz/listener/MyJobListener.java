package com.test.quartz.listener;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;

public class MyJobListener implements JobListener {

    public String getName() {
        String name = getClass().getSimpleName();
        System.out.println("Method getName :"+ "获取到监听器名称："+name);
        return name;
    }

    public void jobToBeExecuted(JobExecutionContext context) {
        String jobName = context.getJobDetail().getKey().getName();
        System.out.println("Method jobToBeExecuted :"+ jobName + " ——任务即将执行 ");
    }

    public void jobExecutionVetoed(JobExecutionContext context) {
        String jobName = context.getJobDetail().getKey().getName();
        System.out.println("Method jobExecutionVetoed :"+ jobName + " ——任务被否决 ");
    }

    public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
        String jobName = context.getJobDetail().getKey().getName();
        System.out.println("Method jobWasExecuted :"+ jobName + " ——执行完毕 ");
        System.out.println("------------------");
    }
}
