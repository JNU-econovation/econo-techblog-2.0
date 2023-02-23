package com.econo.tcono.service.like;

import com.econo.tcono.domain.like.domain.Like;
import com.econo.tcono.domain.like.repository.LikeRepository;
import com.econo.tcono.domain.post.repository.PostRepository;
import com.econo.tcono.global.config.QueryDslConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@Import(QueryDslConfig.class)
class LikeServiceImplTest {
    @Mock
    LikeRepository likeRepository;
    @InjectMocks
    LikeServiceImpl likeService;
    @Mock
    LikeMapper likeMapper;
    @Mock
    PostRepository postRepository;

    @Test
    void 좋아요_존재하지_않기에_생성_테스트() {
        Like like = new Like(1L, 2L);
        when(likeMapper.mapFrom(1L,2L)).thenReturn(like);
        when(likeRepository.existsByPostIdAndIdpId(1L, 2L)).thenReturn(false);
        when(likeRepository.save(like)).thenReturn(like);


        boolean b = likeService.flipLike(1L, 2L);
        assertThat(b).isEqualTo(true);
    }

    @Test
    void 좋아요_존재할때_삭제_테스트() {
        when(likeRepository.existsByPostIdAndIdpId(1L, 2L)).thenReturn(true);

        boolean b = likeService.flipLike(1L, 2L);
        assertThat(b).isEqualTo(false);
    }
}