package com.ohgiraffers.adregamdi.cityanddong.command.domain.repository;

import com.ohgiraffers.adregamdi.cityanddong.command.domain.aggregate.entity.Dong;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DongRepository extends JpaRepository<Dong, Long> {
}
