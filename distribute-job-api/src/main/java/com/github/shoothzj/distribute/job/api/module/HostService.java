package com.github.shoothzj.distribute.job.api.module;

import lombok.Data;

/**
 * @author hezhangjian
 */
@Data
public class HostService {

    private String host;

    private int port;

    public HostService() {
    }
}
