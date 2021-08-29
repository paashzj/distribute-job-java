package com.github.shoothzj.distribute.job.impl.common.service;

import com.github.shoothzj.distribute.job.api.module.JobDetailDto;
import com.github.shoothzj.distribute.job.api.module.ListJobDto;

/**
 * @author hezhangjian
 */
public interface IJobService {

    JobDetailDto find(String jobId);

    ListJobDto findList(int pageIndex, int pageSize);
}
