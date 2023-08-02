package com.ohgiraffers.adregamdi.schedule.query.application.service;

import com.ohgiraffers.adregamdi.detailschedule.command.application.dto.DetailScheduleDTO;
import com.ohgiraffers.adregamdi.detailschedule.query.application.service.DetailScheduleQueryService;
import com.ohgiraffers.adregamdi.place.query.application.dto.ResponsePlaceDTO;
import com.ohgiraffers.adregamdi.place.query.application.service.PlaceQueryService;
import com.ohgiraffers.adregamdi.schedule.command.application.dto.ScheduleDTO;
import com.ohgiraffers.adregamdi.schedule.command.domain.aggregate.entity.Schedule;
import com.ohgiraffers.adregamdi.schedule.query.application.dto.DetailScheduleAndPlaceDTO;
import com.ohgiraffers.adregamdi.schedule.query.infra.repository.ScheduleQueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScheduleQueryService {

    private final ScheduleQueryRepository scheduleQueryRepository;
    private final DetailScheduleQueryService detailScheduleQueryService;
    private final PlaceQueryService placeQueryService;

    @Autowired
    public ScheduleQueryService(ScheduleQueryRepository scheduleQueryRepository,
                                DetailScheduleQueryService detailScheduleQueryService,
                                PlaceQueryService placeQueryService){
        this.scheduleQueryRepository = scheduleQueryRepository;
        this.detailScheduleQueryService = detailScheduleQueryService;
        this.placeQueryService = placeQueryService;
    }

    public List<ScheduleDTO> loadMyScheduleList(Long userNo) {
        List<Schedule> myScheduleListResult = scheduleQueryRepository.findScheduleListByUserNo(userNo);
        if (myScheduleListResult == null){
            return new ArrayList<>();
        }
        ScheduleQueryDTOEntitySwap swap = new ScheduleQueryDTOEntitySwap();
        List<ScheduleDTO> myScheduleList = myScheduleListResult.stream().
                map(i -> swap.scheduleToScheduleDTO(i)).
                collect(Collectors.toList());

        return myScheduleList;
    }

    public ScheduleDTO loadMySchedule(Long scheduleNo) {
        Schedule mySchedule = scheduleQueryRepository.findByScheduleNo(scheduleNo);
        return new ScheduleDTO(
                mySchedule.getScheduleNo(),
                mySchedule.getScheduleName(),
                mySchedule.getScheduleUserNoVO().getUserNo(),
                mySchedule.getScheduleDayVO().getStartDay(),
                mySchedule.getScheduleDayVO().getEndDay(),
                mySchedule.getScheduleDayVO().getDayAndNight()
        );
    }

    public List<DetailScheduleAndPlaceDTO> loadMyDetailScheduleList(Long scheduleNo) {
        List<DetailScheduleDTO> result = detailScheduleQueryService.loadMyDetailScheduleList(scheduleNo);
        List<DetailScheduleAndPlaceDTO> resultList = result.stream().map(detailScheduleDTO -> new DetailScheduleAndPlaceDTO(
                    detailScheduleDTO,
                    placeQueryService.findPlaceWithTagsByPlaceNo(detailScheduleDTO.getPlaceNo())
                        )
                ).collect(Collectors.toList());

        return resultList;
    }
}
