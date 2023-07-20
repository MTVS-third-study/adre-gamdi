package com.ohgiraffers.adregamdi.schedule.query.application.service;

import com.ohgiraffers.adregamdi.schedule.command.domain.aggregate.entity.Schedule;
import com.ohgiraffers.adregamdi.schedule.command.domain.aggregate.vo.ScheduleUserNoVO;
import com.ohgiraffers.adregamdi.schedule.query.application.dto.ScheduleQueryDTO;
import com.ohgiraffers.adregamdi.schedule.query.infra.repository.ScheduleQueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScheduleQueryService {

    private final ScheduleQueryRepository scheduleQueryRepository;

    @Autowired
    public ScheduleQueryService(ScheduleQueryRepository scheduleQueryRepository){
        this.scheduleQueryRepository = scheduleQueryRepository;
    }

    public List<ScheduleQueryDTO> loadMyScheduleList(Long userNo) {
        ScheduleUserNoVO userNoVO = new ScheduleUserNoVO(userNo);
        List<Schedule> myScheduleListResult = scheduleQueryRepository.findAllByScheduleUserNoVO(userNoVO);
        ScheduleQueryDTOEntityMapper entityDtoMapper = new ScheduleQueryDTOEntityMapper();

        List<ScheduleQueryDTO> myScheduleList = myScheduleListResult.stream().
                map(i -> entityDtoMapper.scheduleToScheduleQueryDTO(i)).
                collect(Collectors.toList());

        return myScheduleList;
    }
}
