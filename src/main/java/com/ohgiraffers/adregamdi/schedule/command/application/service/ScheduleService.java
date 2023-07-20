package com.ohgiraffers.adregamdi.schedule.command.application.service;

import com.ohgiraffers.adregamdi.schedule.command.application.dto.ScheduleDTO;
import com.ohgiraffers.adregamdi.schedule.command.domain.aggregate.entity.Schedule;
import com.ohgiraffers.adregamdi.schedule.command.domain.repository.ScheduleRepository;
import com.ohgiraffers.adregamdi.schedule.command.domain.service.ScheduleDomainService;
import com.ohgiraffers.adregamdi.schedule.query.application.service.ScheduleQueryService;
import com.ohgiraffers.adregamdi.user.query.application.service.UserQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScheduleService {

    private final ScheduleQueryService scheduleQueryService;
    private final ScheduleDomainService scheduleDomainService;
    private final ScheduleRepository scheduleRepository;

    private final UserQueryService userQueryService;

    @Autowired
    public ScheduleService (ScheduleDomainService scheduleDomainService,
                            ScheduleQueryService scheduleQueryService,
                            ScheduleRepository scheduleRepository,
                            UserQueryService userQueryService){
        this.scheduleDomainService = scheduleDomainService;
        this.scheduleQueryService = scheduleQueryService;
        this.scheduleRepository = scheduleRepository;
        this.userQueryService = userQueryService;
    }

    @Transactional
    public Schedule insertSchedule(ScheduleDTO scheduleDTO) {
        Long userNo = userQueryService.findByKakaoId(scheduleDTO.getKakaoId()).getUserNo();
        scheduleDTO.setUserNo(userNo);
        ScheduleDTOEntityMapper dtoEntityMapper = new ScheduleDTOEntityMapper();

        Schedule schedule = dtoEntityMapper.scheduleDTOtoScedule(scheduleDTO);

        return scheduleRepository.save(schedule);
    }
}
