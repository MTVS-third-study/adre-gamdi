package com.ohgiraffers.adregamdi.category.command.application.service;

import com.ohgiraffers.adregamdi.category.command.application.dto.CategoryDTO;
import com.ohgiraffers.adregamdi.category.command.domain.aggregate.entity.Category;
import com.ohgiraffers.adregamdi.category.command.domain.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService (CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryDTO insertCategory(String categoryName) {
        Category insertCategory = categoryRepository.save(new Category(categoryName));
        if (insertCategory == null){
            return new CategoryDTO();
        }
        return new CategoryDTO(
                insertCategory.getCategoryNo(),
                insertCategory.getCategoryName()
        );
    }
}
