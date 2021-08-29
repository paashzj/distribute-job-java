package com.github.shoothzj.distribute.job.api.module;

import lombok.Data;

/**
 * @author hezhangjian
 */
@Data
public class JobCreateReq {

    private String JobId;

    private String context;

    private JobMsgDto jobMsgDto;

    private JobCallbackDto jobCallbackDto;

    public JobCreateReq() {
    }
}
