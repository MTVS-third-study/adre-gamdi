package com.ohgiraffers.adregamdi.category.query.infra.repository;

import com.ohgiraffers.adregamdi.category.command.domain.aggregate.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryQueryRepository extends JpaRepository<Category, Long> {

    Category findCategoryByCategoryName(String categoryName);
}
