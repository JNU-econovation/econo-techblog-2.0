package com.econo.tcono.domain.hashtag.repository;

import java.util.List;

public interface PostHashtagCustomRepository {
    List<Long> findHashtagIdByPostId(Long postId);
    void deleteByPostId(Long postId);
}
