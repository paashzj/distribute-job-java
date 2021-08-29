package com.github.shoothzj.distribute.job.impl.common.service;

import com.github.shoothzj.distribute.job.api.module.CronJob;
import com.github.shoothzj.distribute.job.api.module.JobCallbackDto;

/**
 * @author hezhangjian
 */
public interface ICronJobService {

    void addJob(String jobId,  String context, CronJob cronJob, JobCallbackDto jobCallbackDto) throws Exception;

    void delJob(String jobId) throws Exception;

}
