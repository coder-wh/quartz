package com.test.quartz.scheduler;

import com.test.quartz.job.MyJob1;
import com.test.quartz.job.MyJob2;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.HashSet;

public class MyScheduler {
	public static void main(String[] args) throws SchedulerException {
		String jobName = "job1";
		String jobGroupName = "group1";

		// JobDetail
		JobDetail jobDetail = JobBuilder.newJob(MyJob1.class)
				.withIdentity(jobName, jobGroupName)
				.usingJobData("moon","light")
				.build();

		// Trigger
		Trigger trigger = TriggerBuilder.newTrigger()
				.withIdentity("trigger", "group1")
				.startNow()
				.withSchedule(SimpleScheduleBuilder.simpleSchedule()
						.withIntervalInSeconds(2)
						.repeatForever())
				.build();
		// trigger1
		Trigger trigger1 = TriggerBuilder.newTrigger()
				.withIdentity("trigger1", "group1")
				.startNow()
				.withSchedule(SimpleScheduleBuilder.simpleSchedule()
						.withIntervalInSeconds(5)
						.repeatForever())
				.build();

		// SchedulerFactory
		SchedulerFactory factory = new StdSchedulerFactory();

		// Scheduler
		Scheduler scheduler = factory.getScheduler();

		// 绑定关系是1：N
		scheduler.scheduleJob(jobDetail, new HashSet<Trigger>(){{
			add(trigger);
			add(trigger1);
		}},true);
		scheduler.start();


		//动态的删除任务
//		scheduler.pauseTrigger(TriggerKey.triggerKey(jobName, jobGroupName));
//		scheduler.unscheduleJob(TriggerKey.triggerKey(jobName, jobGroupName));
//		scheduler.deleteJob(JobKey.jobKey(jobName, jobGroupName));
	}

}
