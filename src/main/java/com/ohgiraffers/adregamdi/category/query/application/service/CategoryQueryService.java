package com.ohgiraffers.adregamdi.category.query.application.service;

import com.ohgiraffers.adregamdi.category.command.application.dto.CategoryDTO;
import com.ohgiraffers.adregamdi.category.command.domain.aggregate.entity.Category;
import com.ohgiraffers.adregamdi.category.query.infra.repository.CategoryQueryRepository;
import com.ohgiraffers.adregamdi.place.query.infra.repository.PlaceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryQueryService {

    private final PlaceMapper placeMapper;
    private final CategoryQueryRepository categoryQueryRepository;

    @Autowired
    public CategoryQueryService(PlaceMapper placeMapper,
            CategoryQueryRepository categoryQueryRepository) {
        this.placeMapper = placeMapper;
        this.categoryQueryRepository = categoryQueryRepository;
    }

    public CategoryDTO findCategoryByCategoryName(String categoryName) {
        Category findedCategory = categoryQueryRepository.findCategoryByCategoryName(categoryName);
        if (findedCategory == null) {
            return new CategoryDTO();
        }
        return new CategoryDTO(
                findedCategory.getCategoryNo(),
                findedCategory.getCategoryName()
                );
    }

    public CategoryDTO findCategoryByCategoryNo(int categoryNo) {
        Category category = categoryQueryRepository.findCategoryByCategoryNo(categoryNo);
        if (category == null) {
            return new CategoryDTO();
        }
        return new CategoryDTO(
                category.getCategoryNo(),
                category.getCategoryName()
        );
    }

    public String findCategoryNameByCategoryNo(int categoryNo){
        String categoryName = placeMapper.findCategoryNameByCategoryNo(categoryNo);
        if (categoryName == null) {
            return "-";
        }
        return categoryName;
    }

}
