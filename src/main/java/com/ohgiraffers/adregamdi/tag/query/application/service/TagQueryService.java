package com.ohgiraffers.adregamdi.tag.query.application.service;

import com.ohgiraffers.adregamdi.tag.command.application.dto.TagDTO;
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

    public TagDTO findTagByTagName(String tagName) {
        Tag result = tagQueryRepository.findByTagName(tagName);
        if (result == null) {
            return new TagDTO();
        }
        return new TagDTO(
                result.getTagNo(),
                result.getTagName()
        );
    }

    public String findTagNameByTagNo(Long tagNo) {
        String tagName = tagQueryRepository.findTagNameByTagNo(tagNo);
        if (tagName == null) {
            tagName ="";
        }
        return tagName;
    }

    public Long countTagByTagName(String tagName) {
        Long tagCount = tagQueryRepository.countTagByTagName(tagName);
        return tagCount;
    }
}
