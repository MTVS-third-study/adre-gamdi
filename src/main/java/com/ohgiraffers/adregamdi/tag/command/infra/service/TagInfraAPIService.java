package com.ohgiraffers.adregamdi.tag.command.infra.service;

import com.ohgiraffers.adregamdi.tag.command.application.dto.TagDTO;
import com.ohgiraffers.adregamdi.tag.command.domain.aggregate.entity.Tag;
import com.ohgiraffers.adregamdi.tag.command.domain.service.TagAPIService;
import com.ohgiraffers.adregamdi.tag.query.application.service.TagQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagInfraAPIService implements TagAPIService {

    private final TagQueryService tagQueryService;

    @Autowired
    public TagInfraAPIService(TagQueryService tagQueryService) {
        this.tagQueryService = tagQueryService;
    }

    @Override
    public Long countTagByTagName(String tagName) {
        Long tagCount = tagQueryService.countTagByTagName(tagName);
        return tagCount;
    }
}
