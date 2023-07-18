package com.ohgiraffers.adregamdi.schedule.command.application.service;

import com.ohgiraffers.adregamdi.schedule.command.application.dto.ScheduleDTO;
import com.ohgiraffers.adregamdi.schedule.command.domain.service.ScheduleDomainService;
import com.ohgiraffers.adregamdi.schedule.query.application.service.ScheduleQueryService;
import com.ohgiraffers.adregamdi.user.query.application.service.UserQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

    private final ScheduleQueryService scheduleQueryService;
    private final ScheduleDomainService scheduleDomainService;
    private final UserQueryService userQueryService;

    @Autowired
    public ScheduleService (ScheduleDomainService scheduleDomainService,
                            ScheduleQueryService scheduleQueryService,
                            UserQueryService userQueryService){
        this.scheduleDomainService = scheduleDomainService;
        this.scheduleQueryService = scheduleQueryService;
        this.userQueryService = userQueryService;
    }

    public void insertSchedule(ScheduleDTO scheduleDTO) {
        Long userNo = userQueryService.findByKakaoId(scheduleDTO.getKakaoId()).getUserNo();
        


    }
}
