package com.github.shoothzj.distribute.job.impl.quartz.postgre.service;

import com.github.shoothzj.distribute.job.api.module.JobDetailDto;
import com.github.shoothzj.distribute.job.api.module.ListJobDto;
import com.github.shoothzj.distribute.job.api.module.SingleJobDto;
import com.github.shoothzj.distribute.job.impl.common.service.IJobService;
import com.github.shoothzj.distribute.job.impl.quartz.postgre.Constant;
import com.github.shoothzj.distribute.job.impl.quartz.postgre.dao.TimerTriggerRepository;
import com.github.shoothzj.distribute.job.impl.quartz.postgre.po.TimerTrigger;
import com.github.shoothzj.distribute.job.impl.quartz.postgre.po.TimerTriggerEmbedId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author hezhangjian
 */
@Slf4j
public class JobService implements IJobService {

    @Autowired
    private TimerTriggerRepository timerTriggerRepository;

    @Override
    public JobDetailDto find(String jobId) {
        TimerTriggerEmbedId timerTriggerEmbedId = new TimerTriggerEmbedId();
        timerTriggerEmbedId.setSchedName(Constant.SCHEDULE_NAME);
        timerTriggerEmbedId.setTriggerName(jobId);
        Optional<TimerTrigger> timerTriggerOp = timerTriggerRepository.findById(timerTriggerEmbedId);
        if (!timerTriggerOp.isPresent()) {
            return null;
        }
        final TimerTrigger timerTrigger = timerTriggerOp.get();
        JobDetailDto singleJobDTO = new JobDetailDto();
        singleJobDTO.setNextFireTime(timerTrigger.getNextFireTime());
        singleJobDTO.setPrevFireTime(timerTrigger.getPrevFireTime());
        singleJobDTO.setStartTime(timerTrigger.getStartTime());
        return singleJobDTO;
    }

    @Override
    public ListJobDto findList(int pageIndex, int pageSize) {
        Pageable pageable = PageRequest.of(pageIndex, pageSize);
        Page<TimerTrigger> timerTriggers = timerTriggerRepository.findAll(pageable);
        List<SingleJobDto> singleJobDtos = timerTriggers.get().map(timerTrigger -> {
            SingleJobDto singleJobDto = new SingleJobDto();
            singleJobDto.setJobId(timerTrigger.getTimerTriggerEmbedId().getTriggerName());
            singleJobDto.setServiceName(timerTrigger.getTimerTriggerEmbedId().getTriggerGroup());
            return singleJobDto;
        }).collect(Collectors.toList());
        ListJobDto listJobDTO = new ListJobDto();
        listJobDTO.setSingleJobDtoList(singleJobDtos);
        return listJobDTO;
    }
}
