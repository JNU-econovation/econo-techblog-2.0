package com.econo.tcono.domain.hashtag.repository;

import com.econo.tcono.domain.hashtag.domain.PostHashtag;
import com.econo.tcono.global.config.QueryDslConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
@Import(QueryDslConfig.class)
class PostHashtagRepositoryTest {
    @Autowired
    PostHashtagRepository postHashtagRepository;

    PostHashtag postHashtag1;
    PostHashtag postHashtag2;
    PostHashtag postHashtag3;


    @BeforeEach
    void init() {
        postHashtag1 = PostHashtag.builder()
                .hashtagId(1L)
                .postId(1L)
                .build();
        postHashtag2 = PostHashtag.builder()
                .hashtagId(2L)
                .postId(1L)
                .build();
        postHashtag3 = PostHashtag.builder()
                .hashtagId(2L)
                .postId(1L)
                .build();
    }

    @Test
    void saveAll_테스트() {
        List<PostHashtag> postHashtagList = new ArrayList<>();
        postHashtagList.add(postHashtag1);
        postHashtagList.add(postHashtag2);
        postHashtagList.add(postHashtag3);

        List<PostHashtag> postHashtags = postHashtagRepository.saveAll(postHashtagList);

        assertThat(postHashtags.size()).isEqualTo(3);
    }

    @Test
    void findHashtagIdByPostId() {
        PostHashtag save1 = postHashtagRepository.save(postHashtag1);
        PostHashtag save2 = postHashtagRepository.save(postHashtag2);

        List<Long> hashtagIdByPostId = postHashtagRepository.findHashtagIdByPostId(1L);

        assertThat(hashtagIdByPostId.size()).isEqualTo(2);
    }
}