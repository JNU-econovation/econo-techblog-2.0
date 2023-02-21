package com.econo.tcono.domain.hashtag.repository;

import com.econo.tcono.domain.hashtag.domain.Hashtag;
import com.econo.tcono.global.config.QueryDslConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;


@DataJpaTest
@Import(QueryDslConfig.class)
class HashtagRepositoryTest {
    @Autowired
    private HashtagRepository hashtagRepository;
    private static Hashtag hashtag1;

    @BeforeEach
    void init() {
        hashtag1 = Hashtag.builder()
                .name("c언어")
                .build();
    }

    @Test
    void save_테스트() {
        Hashtag save = hashtagRepository.save(hashtag1);
        assertThat(save).isEqualTo(hashtag1);
    }

    @Test
    void findHashtagById_테스트() {
        Hashtag save = hashtagRepository.save(hashtag1);
        Hashtag findHashtag = hashtagRepository.findHashtagById(save.getId());

        assertThat(findHashtag).isEqualTo(save);
    }

    @Test
    void findByName() {
        Hashtag save = hashtagRepository.save(hashtag1);
        Optional<Hashtag> findHashtag = hashtagRepository.findByName("c언어");

        assertThat(findHashtag.get()).isEqualTo(save);
    }
}