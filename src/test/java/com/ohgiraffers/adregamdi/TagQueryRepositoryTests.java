package com.ohgiraffers.adregamdi;

import com.ohgiraffers.adregamdi.place.command.domain.aggregate.entity.Tag;
import com.ohgiraffers.adregamdi.place.command.domain.repository.TagRepository;
import com.ohgiraffers.adregamdi.place.query.infra.repository.TagQueryRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
@SpringBootTest
@AutoConfigureDataJpa
@Transactional
public class TagQueryRepositoryTests {

    @Autowired
    private TagRepository tagRepository;
    @Autowired
    private TagQueryRepository tagQueryRepository;


//    @BeforeEach
//    void SetUp(TagRepository tagRepository){
//        this.tagRepository = tagRepository;
//    }

    @DisplayName("태그 저장 성공 여부")
    @Test
    void testinertTag() {

        // given
        String tagName = "제주도";

        // when & then
        Assertions.assertDoesNotThrow(
                () -> tagRepository.save(new Tag(tagName))
        );

    }



}
