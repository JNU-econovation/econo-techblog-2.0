package com.econo.tcono.domain.like.repository;

import com.econo.tcono.domain.like.domain.Like;
import org.springframework.data.repository.Repository;

public interface LikeRepository extends Repository<Like, Long>, LikeCustomRepository {
    Like save(Like like);

    boolean existsByPostIdAndIdpId(Long postId, Long idpId);

    void deleteAllByPostId(Long postId);
}
