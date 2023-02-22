package com.econo.tcono.service.like;

public interface LikeService {
    void flipLike(Long postId, Long idpId);

    void deleteByPostId(Long postId);

}
