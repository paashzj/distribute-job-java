package com.github.shoothzj.distribute.job.api.module;

import lombok.Data;

/**
 * @author hezhangjian
 */
@Data
public class CronJob {

    private String cronExpr;

    public CronJob() {
    }
}
