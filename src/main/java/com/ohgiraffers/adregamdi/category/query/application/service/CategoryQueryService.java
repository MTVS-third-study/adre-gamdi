package com.ohgiraffers.adregamdi.category.query.application.service;

import com.ohgiraffers.adregamdi.category.command.application.dto.CategoryDTO;
import com.ohgiraffers.adregamdi.category.command.domain.aggregate.entity.Category;
import com.ohgiraffers.adregamdi.category.query.infra.repository.CategoryQueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryQueryService {

    private final CategoryQueryRepository categoryQueryRepository;

    @Autowired
    public CategoryQueryService(CategoryQueryRepository categoryQueryRepository) {
        this.categoryQueryRepository = categoryQueryRepository;
    }

    public CategoryDTO findCategoryByCategoryName(String categoryName) {
        Category findedCategory = categoryQueryRepository.findCategoryByCategoryName(categoryName);
        return new CategoryDTO(
                findedCategory.getCategoryNo(),
                findedCategory.getCategoryName()
                );
    }
}
