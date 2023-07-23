package com.ohgiraffers.adregamdi.cityanddong.query.infra.repository;

import com.ohgiraffers.adregamdi.cityanddong.command.domain.aggregate.entity.Dong;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DongQueryRepository extends JpaRepository<Dong, Integer> {
    Dong findDongByDongName(String dongName);
    Dong findDongByDongNo(int dongNo);
}
