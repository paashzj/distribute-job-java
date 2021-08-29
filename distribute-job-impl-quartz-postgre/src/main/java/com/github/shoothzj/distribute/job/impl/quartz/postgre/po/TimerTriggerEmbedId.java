package com.github.shoothzj.distribute.job.impl.quartz.postgre.po;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class TimerTriggerEmbedId implements Serializable {

    @Column(name = "sched_name")
    private String schedName;

    @Column(name = "trigger_name")
    private String triggerName;

    @Column(name = "trigger_group")
    private String triggerGroup;

    public TimerTriggerEmbedId() {
    }

    public String getSchedName() {
        return schedName;
    }

    public void setSchedName(String schedName) {
        this.schedName = schedName;
    }

    public String getTriggerName() {
        return triggerName;
    }

    public void setTriggerName(String triggerName) {
        this.triggerName = triggerName;
    }

    public String getTriggerGroup() {
        return triggerGroup;
    }

    public void setTriggerGroup(String triggerGroup) {
        this.triggerGroup = triggerGroup;
    }
}