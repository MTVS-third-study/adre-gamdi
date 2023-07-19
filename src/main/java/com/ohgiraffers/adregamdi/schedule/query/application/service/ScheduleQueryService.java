package com.ohgiraffers.adregamdi.schedule.query.application.service;

import com.ohgiraffers.adregamdi.schedule.query.application.dto.ScheduleQueryDTO;
import com.ohgiraffers.adregamdi.schedule.query.infra.repository.ScheduleQueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleQueryService {

    private final ScheduleQueryRepository scheduleQueryRepository;

    @Autowired
    public ScheduleQueryService(ScheduleQueryRepository scheduleQueryRepository){
        this.scheduleQueryRepository = scheduleQueryRepository;
    }

    public void loadMyScheduleList(Long userNo) {

        scheduleQueryRepository.findByScheduleName(userNo);

    }
}
