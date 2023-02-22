package com.econo.tcono.service.hashtag;

import com.econo.tcono.domain.hashtag.domain.PostHashtag;
import org.springframework.stereotype.Component;

@Component
public class PostHashtagMapper {
    public PostHashtag mapFrom(Long hashtagId, Long postId) {
        return PostHashtag.builder()
                .hashtagId(hashtagId)
                .postId(postId)
                .build();
    }
}
