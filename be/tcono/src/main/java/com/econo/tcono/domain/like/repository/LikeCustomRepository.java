package com.econo.tcono.domain.like.repository;

public interface LikeCustomRepository {
    void deleteByPostIdAndIdpId(Long postId, Long idpId);
}
