package com.test.quartz.listener;

import org.quartz.JobExecutionContext;
import org.quartz.Trigger;
import org.quartz.TriggerListener;

public class MyTriggerListener implements TriggerListener {
    private String name;

    public MyTriggerListener(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Trigger 被触发，Job 上的 execute() 方法将要被执行时
    public void triggerFired(Trigger trigger, JobExecutionContext context) {
        String triggerName = trigger.getKey().getName();
        System.out.println(name + "-Method triggerFired " + triggerName + " was fired");
    }

    // 在 Trigger 触发后，Job 将要被执行时由 Scheduler 调用这个方法
    // 返回true时，这个任务不会被触发
    public boolean vetoJobExecution(Trigger trigger, JobExecutionContext context) {
        String triggerName = trigger.getKey().getName();
        System.out.println(name + "-Method vetoJobExecution " + triggerName + " was not vetoed");
        return false;
    }

    public void triggerMisfired(Trigger trigger) {
        String triggerName = trigger.getKey().getName();
        System.out.println(name + "-Method triggerMisfired " + triggerName + " misfired");
    }

    public void triggerComplete(Trigger trigger, JobExecutionContext context,
                                Trigger.CompletedExecutionInstruction triggerInstructionCode) {
        String triggerName = trigger.getKey().getName();
        System.out.println(name + "-Method triggerComplete " + triggerName + " is complete");
        System.out.println("------------");
    }
}
