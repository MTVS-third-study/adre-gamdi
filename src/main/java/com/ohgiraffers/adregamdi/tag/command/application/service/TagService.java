package com.ohgiraffers.adregamdi.tag.command.application.service;

import com.ohgiraffers.adregamdi.tag.command.application.dto.TagDTO;
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

    public TagDTO insertTag(String tagName) {
        Tag insertedTag = tagRepository.save(new Tag());

        return new TagDTO(
                insertedTag.getTagNo(),
                insertedTag.getTagName()
        );
    }

}
