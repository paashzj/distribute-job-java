package com.github.shoothzj.distribute.job.impl.quartz.postgre.po;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "qrtz_triggers")
public class TimerTrigger {

    @EmbeddedId
    private TimerTriggerEmbedId timerTriggerEmbedId;

    @Column(name = "next_fire_time")
    private long nextFireTime;

    @Column(name = "prev_fire_time")
    private long prevFireTime;

    @Column(name = "start_time")
    private long startTime;

    public TimerTrigger() {
    }

    public TimerTriggerEmbedId getTimerTriggerEmbedId() {
        return timerTriggerEmbedId;
    }

    public void setTimerTriggerEmbedId(TimerTriggerEmbedId timerTriggerEmbedId) {
        this.timerTriggerEmbedId = timerTriggerEmbedId;
    }

    public long getNextFireTime() {
        return nextFireTime;
    }

    public void setNextFireTime(long nextFireTime) {
        this.nextFireTime = nextFireTime;
    }

    public long getPrevFireTime() {
        return prevFireTime;
    }

    public void setPrevFireTime(long prevFireTime) {
        this.prevFireTime = prevFireTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }
}