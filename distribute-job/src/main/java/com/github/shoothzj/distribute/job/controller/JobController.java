package com.github.shoothzj.distribute.job.controller;

import com.github.shoothzj.distribute.job.api.module.JobCallbackDto;
import com.github.shoothzj.distribute.job.api.module.JobCreateReq;
import com.github.shoothzj.distribute.job.api.module.JobDetailDto;
import com.github.shoothzj.distribute.job.api.module.JobMsgDto;
import com.github.shoothzj.distribute.job.api.module.JobType;
import com.github.shoothzj.distribute.job.api.module.ListJobDto;
import com.github.shoothzj.distribute.job.impl.common.service.ICronJobService;
import com.github.shoothzj.distribute.job.impl.common.service.IJobService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hezhangjian
 */
@Slf4j
@RestController(value = "v1/distribute-job")
public class JobController {

    @Autowired
    private ICronJobService iCronJobService;

    @Autowired
    private IJobService iJobService;

    @PostMapping(path = "/jobs")
    public void addJob(@RequestBody JobCreateReq createReq) throws Exception {
        final String jobId = createReq.getJobId();
        final String context = createReq.getContext();
        final JobMsgDto jobMsgDto = createReq.getJobMsgDto();
        final JobCallbackDto jobCallbackDto = createReq.getJobCallbackDto();
        if (jobMsgDto.getJobType().equals(JobType.CRON)) {
            iCronJobService.addJob(jobId, context, jobMsgDto.getCronJob(), jobCallbackDto);
        } else {
            throw new IllegalArgumentException("Job type not supported yet");
        }
    }

    @RequestMapping(path = "/jobs/{jobId}", method = RequestMethod.GET)
    public ResponseEntity<JobDetailDto> findJob(@PathVariable(name = "jobId") String jobId) {
        final JobDetailDto jobDetailDto = iJobService.find(jobId);
        return new ResponseEntity<>(jobDetailDto, HttpStatus.OK);
    }

    @RequestMapping(path = "/timer/job", method = RequestMethod.GET)
    public ResponseEntity<ListJobDto> findListJob(@RequestParam(name = "pageIndex") int pageIndex, @RequestParam(name = "pageSize") int pageSize) {
        final ListJobDto listJobDto = iJobService.findList(pageIndex, pageSize);
        return new ResponseEntity<>(listJobDto, HttpStatus.OK);
    }


}
