package com.github.shoothzj.distribute.job.api.module;

import java.util.List;

public class ListJobDto {

    private List<SingleJobDto> singleJobDtoList;

    public ListJobDto() {
    }

    public List<SingleJobDto> getSingleJobDtoList() {
        return singleJobDtoList;
    }

    public void setSingleJobDtoList(List<SingleJobDto> singleJobDtoList) {
        this.singleJobDtoList = singleJobDtoList;
    }
}