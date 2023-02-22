package com.econo.tcono.domain.like.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

import static com.econo.tcono.domain.like.domain.QLike.like;

public class LikeRepositoryImpl implements LikeCustomRepository{
    private final JPAQueryFactory jpaQueryFactory;

    public LikeRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public void deleteByPostIdAndIdpId(Long postId, Long idpId) {
        jpaQueryFactory.delete(like)
                .where(like.postId.eq(postId)
                        .and(like.idpId.eq(idpId)))
                .execute();
    }
}
