package com.ohgiraffers.adregamdi.schedule.command.application.service;

import com.ohgiraffers.adregamdi.schedule.command.application.dto.ScheduleDTO;
import com.ohgiraffers.adregamdi.schedule.command.domain.aggregate.entity.Schedule;
import com.ohgiraffers.adregamdi.schedule.command.domain.aggregate.vo.ScheduleDayVO;
import com.ohgiraffers.adregamdi.schedule.command.domain.aggregate.vo.ScheduleUserNoVO;
import com.ohgiraffers.adregamdi.schedule.command.domain.repository.ScheduleRepository;
import com.ohgiraffers.adregamdi.schedule.command.domain.service.ScheduleDomainService;
import com.ohgiraffers.adregamdi.schedule.query.application.service.ScheduleQueryService;
import com.ohgiraffers.adregamdi.user.command.application.dto.UserDTO;
import com.ohgiraffers.adregamdi.user.command.domain.aggregate.entity.User;
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

    public ScheduleDTO insertSchedule(ScheduleDTO scheduleDTO) {
        Schedule insertedSchedule = scheduleRepository.save(new Schedule(
                new ScheduleUserNoVO(scheduleDTO.getUserNo()),
                scheduleDTO.getScheduleName(),
                new ScheduleDayVO(scheduleDTO.getStartDay(), scheduleDTO.getEndDay())
        ));

        return new ScheduleDTO(
                insertedSchedule.getScheduleName(),
                insertedSchedule.getScheduleUserNoVO().getUserNo(),
                insertedSchedule.getScheduleDayVO().getStartDay(),
                insertedSchedule.getScheduleDayVO().getEndDay(),
                insertedSchedule.getScheduleDayVO().getDayAndNight()
        );
    }

    public void updateSchedule(ScheduleDTO scheduleDTO) {

    }

    public void deleteSchedule(Long scheduleNo) {
        scheduleRepository.deleteById(scheduleNo);
    }
}
