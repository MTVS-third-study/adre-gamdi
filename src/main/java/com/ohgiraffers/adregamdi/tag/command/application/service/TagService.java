package com.ohgiraffers.adregamdi.tag.command.application.service;

import com.ohgiraffers.adregamdi.data.command.application.dto.TagDataDTO;
import com.ohgiraffers.adregamdi.tag.command.domain.repository.TagRepository;
import com.ohgiraffers.adregamdi.tag.command.domain.aggregate.entity.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagService {

    private final TagRepository tagRepository;

    @Autowired
    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public TagDataDTO insertTag(String tagName) {
        Tag insertedTag = tagRepository.save(new Tag());

        return new TagDataDTO(
                insertedTag.getTagNo(),
                insertedTag.getTagName()
        );
    }

}
