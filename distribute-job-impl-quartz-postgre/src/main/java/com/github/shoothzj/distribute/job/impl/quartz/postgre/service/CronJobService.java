package com.github.shoothzj.distribute.job.impl.quartz.postgre.service;

import com.github.shoothzj.distribute.job.api.module.CronJob;
import com.github.shoothzj.distribute.job.api.module.JobCallbackDto;
import com.github.shoothzj.distribute.job.impl.common.service.ICronJobService;
import com.github.shoothzj.distribute.job.impl.quartz.postgre.Constant;
import com.github.shoothzj.javatool.service.JacksonService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobDataMap;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.quartz.TriggerBuilder.newTrigger;

/**
 * @author hezhangjian
 */
@Slf4j
@Service
public class CronJobService implements ICronJobService {

    @Autowired
    TimerSchedulerService timerSchedulerService;

    @Override
    public void addJob(String jobId, String context, CronJob cronJob, JobCallbackDto jobCallbackDto) throws Exception {
        Trigger trigger = newTrigger().withIdentity(jobId)
                .forJob(Constant.JOB_NAME)
                .startNow().usingJobData(Constant.CONTEXT, context)
                .usingJobData(Constant.CALLBACK, JacksonService.toJson(jobCallbackDto))
                .withSchedule(CronScheduleBuilder.cronSchedule(cronJob.getCronExpr()))
                .build();
        timerSchedulerService.scheduleJob(trigger);
    }

    @Override
    public void delJob(String jobId) throws Exception {
        timerSchedulerService.unScheduleJob(new TriggerKey(jobId));
    }

}
