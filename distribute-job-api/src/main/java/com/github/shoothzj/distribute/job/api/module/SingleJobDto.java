package com.github.shoothzj.distribute.job.api.module;

public class SingleJobDto {

    private String serviceName;

    private String jobId;

    public SingleJobDto() {
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }
}