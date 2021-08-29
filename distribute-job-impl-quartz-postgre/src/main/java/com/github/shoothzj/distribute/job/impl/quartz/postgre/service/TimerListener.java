package com.github.shoothzj.distribute.job.impl.quartz.postgre.service;

import com.github.shoothzj.distribute.job.impl.quartz.postgre.Constant;
import com.github.shoothzj.distribute.job.impl.quartz.postgre.CronJobHandler;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;


/**
 * @author hezhangjian
 */
@Slf4j
@Service
public class TimerListener {

    @Autowired
    private TimerSchedulerService timerSchedulerService;

    @PostConstruct
    public void init() throws Exception {
        timerSchedulerService.start();
        JobDetail job = JobBuilder.newJob(CronJobHandler.class).withIdentity(Constant.JOB_NAME, Constant.JOB_GROUP).storeDurably().build();
        timerSchedulerService.addJob(job, false);
    }

}
