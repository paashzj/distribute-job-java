package com.github.shoothzj.distribute.job.impl.quartz.postgre.service;

import com.github.shoothzj.distribute.job.impl.quartz.postgre.Constant;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

/**
 * @author hezhangjian
 */
@Service
public class TimerSchedulerService {

    @Autowired
    private DataSource dataSource;

    private final SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();

    @PostConstruct
    public void init() throws SchedulerException {
        schedulerFactoryBean.setDataSource(dataSource);
        schedulerFactoryBean.setOverwriteExistingJobs(true);
        schedulerFactoryBean.setSchedulerName(Constant.SCHEDULE_NAME);
        schedulerFactoryBean.setConfigLocation(new ClassPathResource("quartz.properties"));
    }

    public void start() throws Exception {
        schedulerFactoryBean.afterPropertiesSet();
        schedulerFactoryBean.start();
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        scheduler.start();
    }

    public void stop() throws Exception {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        scheduler.shutdown();
    }

    public void addJob(JobDetail job, boolean replace) throws SchedulerException {
        schedulerFactoryBean.getScheduler().addJob(job, replace);
    }

    public boolean unScheduleJob(TriggerKey triggerKey) throws SchedulerException {
        return schedulerFactoryBean.getScheduler().unscheduleJob(triggerKey);
    }

    public void scheduleJob(Trigger trigger) throws SchedulerException {
        schedulerFactoryBean.getScheduler().scheduleJob(trigger);
    }


}
