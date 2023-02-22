package com.econo.tcono.service.like;

import com.econo.tcono.domain.like.domain.Like;
import org.springframework.stereotype.Component;

@Component
public class LikeMapper {
    public Like mapFrom(Long postId, Long idpId) {
        return Like.builder()
                .postId(postId)
                .idpId(idpId)
                .build();
    }
}
