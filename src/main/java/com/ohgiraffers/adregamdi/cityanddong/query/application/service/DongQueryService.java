package com.ohgiraffers.adregamdi.cityanddong.query.application.service;

import com.ohgiraffers.adregamdi.cityanddong.command.application.dto.DongDTO;
import com.ohgiraffers.adregamdi.cityanddong.command.domain.aggregate.entity.Dong;
import com.ohgiraffers.adregamdi.cityanddong.query.infra.repository.DongQueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DongQueryService {

    private final DongQueryRepository dongQueryRepository;

    @Autowired
    public DongQueryService(DongQueryRepository dongQueryRepository) {
        this.dongQueryRepository = dongQueryRepository;
    }

    public DongDTO findDongByDongName(String dongName) {
        Dong result = dongQueryRepository.findDongByDongName(dongName);
        return new DongDTO(
                result.getDongNo(),
                result.getDongName()
        );
    }
}
