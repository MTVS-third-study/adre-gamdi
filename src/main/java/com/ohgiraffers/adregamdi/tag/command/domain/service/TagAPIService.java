package com.ohgiraffers.adregamdi.tag.command.domain.service;

import com.ohgiraffers.adregamdi.tag.command.application.dto.TagDTO;
import com.ohgiraffers.adregamdi.tag.command.domain.aggregate.entity.Tag;
import com.ohgiraffers.adregamdi.tag.command.infra.service.TagInfraAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface TagAPIService {

    Long countTagByTagName(String tagName);
}
