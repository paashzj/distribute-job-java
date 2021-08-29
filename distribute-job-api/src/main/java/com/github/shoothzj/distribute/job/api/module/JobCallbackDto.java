package com.github.shoothzj.distribute.job.api.module;

import lombok.Data;

/**
 * @author hezhangjian
 */
@Data
public class JobCallbackDto {

    private ServiceType serviceType;

    private HostService hostService;

    private ServiceCombService serviceCombService;

    public JobCallbackDto() {
    }

    public String acquireGroup() {
        if (serviceType.equals(ServiceType.HOST)) {
            return hostService.getHost();
        } else if (serviceType.equals(ServiceType.SERVICE_COMB)) {
            return serviceCombService.getServiceName();
        } else {
            return "";
        }
    }

}
