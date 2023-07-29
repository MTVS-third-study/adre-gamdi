package com.ohgiraffers.adregamdi.detailschedule.command.application.service;

import com.ohgiraffers.adregamdi.detailschedule.command.application.dto.DetailScheduleDTO;
import com.ohgiraffers.adregamdi.detailschedule.command.domain.aggregate.entity.DetailSchedule;
import com.ohgiraffers.adregamdi.detailschedule.command.domain.aggregate.vo.PlaceNo;
import com.ohgiraffers.adregamdi.detailschedule.command.domain.repository.DetailScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DetailScheduleService {
    private final DetailScheduleRepository detailScheduleRepository;

    @Autowired
    public DetailScheduleService(DetailScheduleRepository detailScheduleRepository) {
        this.detailScheduleRepository = detailScheduleRepository;
    }


    // 세부 일정 등록
    public List<DetailScheduleDTO> registDetailSchedule(List<DetailScheduleDTO> detailScheduleDTOList) {
        List<DetailScheduleDTO> detailScheduleList = new ArrayList<>();
        DetailScheduleDTO detailScheduleDTO = new DetailScheduleDTO();
        DetailSchedule detailSchedule;

        int listSize = detailScheduleDTOList.size();
        for (int i = 0; i < listSize; i++) {
            detailSchedule = detailScheduleRepository.save(new DetailSchedule(
                    detailScheduleDTOList.get(i).getDetailScheduleNo()
                    , detailScheduleDTOList.get(i).getProcedureNo()
                    , detailScheduleDTOList.get(i).getScheduleDay()
                    , detailScheduleDTOList.get(i).getTotalScheduleNo()
                    , new PlaceNo(detailScheduleDTOList.get(i).getPlaceNo())));

            detailScheduleDTO.setDetailScheduleNo(detailSchedule.getDetailScheduleNo());
            detailScheduleDTO.setProcedureNo(detailSchedule.getProcedureNo());
            detailScheduleDTO.setScheduleDay(detailSchedule.getScheduleDay());
            detailScheduleDTO.setTotalScheduleNo(detailSchedule.getTotalScheduleNo());
            detailScheduleDTO.setPlaceNo(detailSchedule.getPlaceNo().getPlaceNo());

            detailScheduleList.add(i, detailScheduleDTO);
        }
        return detailScheduleList;
    }

}
