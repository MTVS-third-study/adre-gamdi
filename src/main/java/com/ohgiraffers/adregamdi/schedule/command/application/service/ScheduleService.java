package com.ohgiraffers.adregamdi.schedule.command.application.service;

import com.ohgiraffers.adregamdi.detailschedule.command.application.service.DetailScheduleService;
import com.ohgiraffers.adregamdi.schedule.command.application.dto.DetailScheduleDTO;
import com.ohgiraffers.adregamdi.schedule.command.application.dto.ScheduleDTO;
import com.ohgiraffers.adregamdi.schedule.command.domain.aggregate.entity.Schedule;
import com.ohgiraffers.adregamdi.schedule.command.domain.aggregate.vo.ScheduleDayVO;
import com.ohgiraffers.adregamdi.schedule.command.domain.aggregate.vo.ScheduleUserNoVO;
import com.ohgiraffers.adregamdi.schedule.command.domain.repository.ScheduleRepository;
import com.ohgiraffers.adregamdi.schedule.command.domain.service.ScheduleAPIService;
import com.ohgiraffers.adregamdi.schedule.command.domain.service.ScheduleDomainService;
import com.ohgiraffers.adregamdi.schedule.command.infra.service.ScheduleInfraAPIService;
import com.ohgiraffers.adregamdi.schedule.query.application.service.ScheduleQueryService;
import com.ohgiraffers.adregamdi.user.query.application.service.UserQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ScheduleService {

    private final ScheduleQueryService scheduleQueryService;
    private final ScheduleDomainService scheduleDomainService;
    private final ScheduleRepository scheduleRepository;
    private final ScheduleAPIService scheduleAPIService;

    private final UserQueryService userQueryService;

    @Autowired
    public ScheduleService (ScheduleDomainService scheduleDomainService,
                            ScheduleQueryService scheduleQueryService,
                            ScheduleRepository scheduleRepository,
                            UserQueryService userQueryService,
                            ScheduleAPIService scheduleAPIService){
        this.scheduleDomainService = scheduleDomainService;
        this.scheduleQueryService = scheduleQueryService;
        this.scheduleRepository = scheduleRepository;
        this.userQueryService = userQueryService;
        this.scheduleAPIService = scheduleAPIService;
    }

    public String insertSchedule(ScheduleDTO scheduleDTO, DetailScheduleDTO detailScheduleDTO) {
        Schedule insertedSchedule = scheduleRepository.save(new Schedule(
                new ScheduleUserNoVO(scheduleDTO.getUserNo()),
                scheduleDTO.getScheduleName(),
                new ScheduleDayVO(scheduleDTO.getStartDate(), scheduleDTO.getEndDate())
        ));
        detailScheduleDTO.setScheduleNo(insertedSchedule.getScheduleNo());

        return "성공적으로 저장되었습니다.";
    }

    public void updateSchedule(ScheduleDTO scheduleDTO) {

    }

    public void deleteSchedule(Long scheduleNo) {
        scheduleRepository.deleteById(scheduleNo);
    }
}
