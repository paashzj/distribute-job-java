package com.github.shoothzj.distribute.job.impl.quartz.postgre.dao;

import com.github.shoothzj.distribute.job.impl.quartz.postgre.po.TimerTrigger;
import com.github.shoothzj.distribute.job.impl.quartz.postgre.po.TimerTriggerEmbedId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TimerTriggerRepository extends PagingAndSortingRepository<TimerTrigger, TimerTriggerEmbedId> {

    @Override
    Optional<TimerTrigger> findById(TimerTriggerEmbedId timerTriggerEmbedId);

    @Override
    Page<TimerTrigger> findAll(Pageable pageable);

}
