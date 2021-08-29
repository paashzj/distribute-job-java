package com.github.shoothzj.distribute.job.sdk;

public class CronTrigContext {

    private String jobId;

    /**
     * 注册任务时候指定的回调
     */
    private String context;

    /**
     * 分配到的分片数组
     */
    private int[] distributionArray;

    /**
     * job的分片总数
     */
    private int jobShardingNum;

    public CronTrigContext() {

    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public int[] getDistributionArray() {
        return distributionArray;
    }

    public void setDistributionArray(int[] distributionArray) {
        this.distributionArray = distributionArray;
    }

    public int getJobShardingNum() {
        return jobShardingNum;
    }

    public void setJobShardingNum(int jobShardingNum) {
        this.jobShardingNum = jobShardingNum;
    }
}
