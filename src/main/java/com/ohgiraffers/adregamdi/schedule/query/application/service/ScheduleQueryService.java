package com.ohgiraffers.adregamdi.schedule.query.application.service;

import com.ohgiraffers.adregamdi.schedule.command.application.dto.ScheduleDTO;
import com.ohgiraffers.adregamdi.schedule.command.domain.aggregate.entity.Schedule;
import com.ohgiraffers.adregamdi.schedule.query.infra.repository.ScheduleQueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScheduleQueryService {

    private final ScheduleQueryRepository scheduleQueryRepository;

    @Autowired
    public ScheduleQueryService(ScheduleQueryRepository scheduleQueryRepository){
        this.scheduleQueryRepository = scheduleQueryRepository;
    }

    public List<ScheduleDTO> loadMyScheduleList(Long userNo) {
        List<Schedule> myScheduleListResult = scheduleQueryRepository.findScheduleListByUserNo(userNo);

        ScheduleQueryDTOEntitySwap swap = new ScheduleQueryDTOEntitySwap();
        List<ScheduleDTO> myScheduleList = myScheduleListResult.stream().
                map(i -> swap.scheduleToScheduleDTO(i)).
                collect(Collectors.toList());

        return myScheduleList;
    }
}
