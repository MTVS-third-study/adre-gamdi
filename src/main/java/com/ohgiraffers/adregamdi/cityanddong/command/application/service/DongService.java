package com.ohgiraffers.adregamdi.cityanddong.command.application.service;

import com.ohgiraffers.adregamdi.cityanddong.command.application.dto.DongDTO;
import com.ohgiraffers.adregamdi.cityanddong.command.domain.aggregate.entity.Dong;
import com.ohgiraffers.adregamdi.cityanddong.command.domain.repository.DongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DongService {

    private final DongRepository dongRepository;

    @Autowired
    public DongService(DongRepository dongRepository) {
        this.dongRepository = dongRepository;
    }

    public DongDTO insertDong(DongDTO dongDTO) {
        Dong insertedDong = dongRepository.save(new Dong(
                dongDTO.getDongNo(),
                dongDTO.getDongName()
        ));
        return new DongDTO(
                insertedDong.getDongNo(),
                insertedDong.getDongName()
        );
    }
}
