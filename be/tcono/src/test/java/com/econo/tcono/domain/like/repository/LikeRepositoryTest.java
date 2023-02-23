package com.econo.tcono.domain.like.repository;

import com.econo.tcono.domain.like.domain.Like;
import com.econo.tcono.global.config.QueryDslConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.*;


@DataJpaTest
@Import(QueryDslConfig.class)
class LikeRepositoryTest {
    Like like1;

    @Autowired
    LikeRepository likeRepository;

    @BeforeEach
    void init() {
        like1 = Like.builder()
                .postId(1L)
                .idpId(2L)
                .build();
    }

    @Test
    void save_테스트() {
        Like save = likeRepository.save(like1);

        assertThat(save).isEqualTo(like1);
    }

    @Test
    void 좋아요_존재_체크_테스트() {
        Like save = likeRepository.save(like1);

        boolean b = likeRepository.existsByPostIdAndIdpId(1L, 2L);

        assertThat(b).isEqualTo(true);

    }

    @Test
    void 좋아요_존재_안함_체크_테스트() {
        likeRepository.save(like1);

        boolean isExist = likeRepository.existsByPostIdAndIdpId(2L, 1L);

        assertThat(isExist).isEqualTo(false);
    }

    @Test
    void delete_테스트() {
        likeRepository.save(like1);
        likeRepository.deleteByPostIdAndIdpId(1L, 2L);

        boolean exists = likeRepository.existsByPostIdAndIdpId(1L, 2L);
        assertThat(exists).isEqualTo(false);
    }

    @Test
    void 글에_존재하는_좋아요_모두_삭제(){
        Like like2 = Like.builder()
                .postId(1L)
                .idpId(3L)
                .build();

        Like like3 = Like.builder()
                .postId(1L)
                .idpId(4L)
                .build();

        likeRepository.save(like2);
        likeRepository.save(like3);
        likeRepository.deleteAllByPostId(1L);

        boolean b2 = likeRepository.existsByPostIdAndIdpId(1L, 3L);
        assertThat(b2).isEqualTo(false);

        boolean b3 = likeRepository.existsByPostIdAndIdpId(1L, 4L);
        assertThat(b3).isEqualTo(false);

    }
}