package com.ohgiraffers.adregamdi.tag.query.application.service;

import com.ohgiraffers.adregamdi.data.command.application.dto.TagDataDTO;
import com.ohgiraffers.adregamdi.tag.query.infra.repository.TagQueryRepository;
import com.ohgiraffers.adregamdi.tag.command.domain.aggregate.entity.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagQueryService {

    private final TagQueryRepository tagQueryRepository;

    @Autowired
    public TagQueryService(TagQueryRepository tagQueryRepository) {
        this.tagQueryRepository = tagQueryRepository;
    }

    public TagDataDTO findTagByTagName(String tagName) {
        Tag result = tagQueryRepository.findByTagName(tagName);
        return new TagDataDTO(
                result.getTagNo(),
                result.getTagName()
        );
    }
}
