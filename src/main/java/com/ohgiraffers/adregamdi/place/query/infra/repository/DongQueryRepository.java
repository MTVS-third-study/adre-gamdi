package com.ohgiraffers.adregamdi.place.query.infra.repository;

import com.ohgiraffers.adregamdi.place.command.domain.aggregate.entity.Dong;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DongQueryRepository extends JpaRepository<Dong, Integer> {
    Dong findDongByDongName(String dongName);
}
