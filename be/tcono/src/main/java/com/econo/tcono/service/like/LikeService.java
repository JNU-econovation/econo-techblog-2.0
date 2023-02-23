package com.econo.tcono.service.like;

public interface LikeService {
    boolean flipLike(Long postId, Long idpId);

    void deleteByPostId(Long postId);

}
