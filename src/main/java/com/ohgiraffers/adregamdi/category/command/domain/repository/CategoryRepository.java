package com.ohgiraffers.adregamdi.category.command.domain.repository;

import com.ohgiraffers.adregamdi.category.command.application.dto.CategoryDTO;
import com.ohgiraffers.adregamdi.category.command.domain.aggregate.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
