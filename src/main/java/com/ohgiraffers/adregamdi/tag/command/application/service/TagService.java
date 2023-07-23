package com.ohgiraffers.adregamdi.tag.command.application.service;

import com.ohgiraffers.adregamdi.tag.command.application.dto.TagDTO;
import com.ohgiraffers.adregamdi.tag.command.domain.repository.TagRepository;
import com.ohgiraffers.adregamdi.tag.command.domain.aggregate.entity.Tag;
import com.ohgiraffers.adregamdi.tag.command.domain.service.TagAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagService {

    private final TagRepository tagRepository;
    private final TagAPIService tagAPIService;

    @Autowired
    public TagService(TagRepository tagRepository,
                      TagAPIService tagAPIService) {
        this.tagRepository = tagRepository;
        this.tagAPIService = tagAPIService;
    }

    public TagDTO insertTag(String tagName) {
        Long result = tagAPIService.countTagByTagName(tagName);
        if (result > 0) {
            return new TagDTO();
        }
        Tag insertedTag = tagRepository.save(new Tag(
                tagName
        ));

        return new TagDTO(
                insertedTag.getTagNo(),
                insertedTag.getTagName()
        );
    }

}
