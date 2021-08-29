package com.github.shoothzj.distribute.job.api.module;

import lombok.Data;

/**
 * @author hezhangjian
 */
@Data
public class JobMsgDto {

    private JobType jobType;

    private CronJob cronJob;

    public JobMsgDto() {
    }
}
