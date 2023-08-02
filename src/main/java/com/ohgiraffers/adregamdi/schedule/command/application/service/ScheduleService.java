package com.ohgiraffers.adregamdi.schedule.command.application.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ohgiraffers.adregamdi.detailschedule.command.application.dto.DetailScheduleDTO;
import com.ohgiraffers.adregamdi.detailschedule.command.domain.aggregate.vo.PlaceNo;
import com.ohgiraffers.adregamdi.detailschedule.command.domain.aggregate.vo.TotalScheduleNo;
import com.ohgiraffers.adregamdi.schedule.command.application.dto.PlaceParseDTO;
import com.ohgiraffers.adregamdi.schedule.command.application.dto.ScheduleDTO;
import com.ohgiraffers.adregamdi.schedule.command.domain.aggregate.entity.Schedule;
import com.ohgiraffers.adregamdi.schedule.command.domain.aggregate.vo.ScheduleDayVO;
import com.ohgiraffers.adregamdi.schedule.command.domain.aggregate.vo.ScheduleUserNoVO;
import com.ohgiraffers.adregamdi.schedule.command.domain.repository.ScheduleRepository;
import com.ohgiraffers.adregamdi.schedule.command.domain.service.ScheduleAPIService;
import com.ohgiraffers.adregamdi.schedule.command.domain.service.ScheduleDomainService;
import com.ohgiraffers.adregamdi.schedule.query.application.service.ScheduleQueryService;
import com.ohgiraffers.adregamdi.user.query.application.service.UserQueryService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    public String insertSchedule(ScheduleDTO scheduleDTO) {
        Schedule insertedSchedule = scheduleRepository.save(new Schedule(
                new ScheduleUserNoVO(scheduleDTO.getUserNo()),
                scheduleDTO.getScheduleName(),
                new ScheduleDayVO(scheduleDTO.getStartDate(), scheduleDTO.getEndDate())
        ));

        int dayAndNight = Integer.parseInt(scheduleDTO.getDayAndNight());
        System.out.println("scheduleDTO.getTravelDays() = " + scheduleDTO.getTravelDays());
        System.out.println(scheduleDTO.getTravelDays().getClass().getName());
        Map<String, List<PlaceParseDTO>> travelDaysJSON = scheduleDTO.getTravelDays();
        List<DetailScheduleDTO> detailScheduleDTOList = new ArrayList<>();
        for (int i=1; i<=dayAndNight; i++) {
            ObjectMapper mapper = new ObjectMapper();
            if (travelDaysJSON.get(Integer.toString(i)) == null){
                continue;
            }
            List<PlaceParseDTO> dayScheduleList = mapper.convertValue(
                    travelDaysJSON.get(Integer.toString(i)),
                    new TypeReference<List<PlaceParseDTO>>() {
                        @Override
                        public Type getType() {
                            return super.getType();
                        }
                    }
            );

            System.out.println("dayScheduleList = " + dayScheduleList);
            System.out.println(dayScheduleList.getClass().getName());
//            System.out.println("데잇스케줄리스트 인자 타입" + dayScheduleList.get()getClass().getName());

            int listSize = dayScheduleList.size();
            for (int j = 0; j < listSize; j++) {
                PlaceParseDTO placeInfo = dayScheduleList.get(j);
                System.out.println("placeInfo = " + placeInfo);
                DetailScheduleDTO placeScheduleInfo = new DetailScheduleDTO();
                placeScheduleInfo.setPlaceNo(placeInfo.getPlaceNo());
                placeScheduleInfo.setProcedureNo(j+1);
                placeScheduleInfo.setScheduleDay(i);
                placeScheduleInfo.setTotalScheduleNo(new TotalScheduleNo(insertedSchedule.getScheduleNo()));
                detailScheduleDTOList.add(placeScheduleInfo);
            }
        }
        List<DetailScheduleDTO> insertedDetailScheduleList = scheduleAPIService.insertDetailSchedule(detailScheduleDTOList);
        insertedDetailScheduleList.stream().forEach(System.out::println);
        return "성공적으로 저장되었습니다.";
    }

    public void updateSchedule(ScheduleDTO scheduleDTO) {

    }

    public void deleteSchedule(Long scheduleNo) {
        try {
            scheduleAPIService.deleteDetailScheduleByscheduleNo(scheduleNo);
            scheduleRepository.deleteById(scheduleNo);
        }catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("삭제에 실패하였습니다.");
        }

    }
}
