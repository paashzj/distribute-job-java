package com.github.shoothzj.distribute.job.impl.quartz.postgre;

import com.github.shoothzj.distribute.job.api.module.JobCallbackDto;
import com.github.shoothzj.javatool.service.JacksonService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.TriggerKey;

/**
 * @author hezhangjian
 */
@Slf4j
public class CronJobHandler implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        TriggerKey triggerKey = context.getTrigger().getKey();
        String jobId = triggerKey.getName();
        String timerContext = context.getMergedJobDataMap().getString(Constant.CONTEXT);
        String callbackStr = context.getMergedJobDataMap().getString(Constant.CALLBACK);
        final JobCallbackDto jobCallbackDto = JacksonService.toObject(callbackStr, JobCallbackDto.class);

        // todo callback
    }

}
