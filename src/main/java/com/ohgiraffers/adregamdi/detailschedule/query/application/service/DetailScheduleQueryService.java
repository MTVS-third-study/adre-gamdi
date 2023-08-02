package com.ohgiraffers.adregamdi.detailschedule.query.application.service;

import com.ohgiraffers.adregamdi.detailschedule.command.application.dto.DetailScheduleDTO;
import com.ohgiraffers.adregamdi.detailschedule.command.domain.aggregate.entity.DetailSchedule;
import com.ohgiraffers.adregamdi.detailschedule.command.domain.aggregate.vo.TotalScheduleNo;
import com.ohgiraffers.adregamdi.detailschedule.query.infra.repository.DetailScheduleQueryRepository;
import com.ohgiraffers.adregamdi.schedule.command.application.dto.ScheduleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DetailScheduleQueryService {

    private final DetailScheduleQueryRepository detailScheduleQueryRepository;

    @Autowired
    public DetailScheduleQueryService(DetailScheduleQueryRepository detailScheduleQueryRepository) {
        this.detailScheduleQueryRepository =detailScheduleQueryRepository;
    }

    public List<DetailScheduleDTO> loadMyDetailScheduleList(Long scheduleNo) {
        List<DetailSchedule> result =
                detailScheduleQueryRepository.findAllByTotalScheduleNo(new TotalScheduleNo(scheduleNo));
        List<DetailScheduleDTO> myDetailScheduleList = result.stream().map(detailSchedule -> new DetailScheduleDTO(
                detailSchedule.getDetailScheduleNo(),
                detailSchedule.getProcedureNo(),
                detailSchedule.getScheduleDay(),
                detailSchedule.getTotalScheduleNo(),
                detailSchedule.getPlaceNo().getPlaceNo()
        )).collect(Collectors.toList());

        return myDetailScheduleList;
    }
}
