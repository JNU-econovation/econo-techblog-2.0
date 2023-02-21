package com.econo.tcono.domain.hashtag.repository;

import com.econo.tcono.domain.hashtag.domain.PostHashtag;
import com.econo.tcono.domain.hashtag.domain.QPostHashtag;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.econo.tcono.domain.hashtag.domain.QPostHashtag.postHashtag;

@Repository
public class PostHashtagRepositoryImpl implements PostHashtagCustomRepository {
    private final JPAQueryFactory jpaQueryFactory;

    public PostHashtagRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public List<Long> findHashtagIdByPostId(Long postId) {
        return jpaQueryFactory.select(postHashtag.hashtagId)
                .from(postHashtag)
                .where(postHashtag.postId.eq(postId))
                .fetch();
    }

    @Override
    public void deleteByPostId(Long postId) {
        jpaQueryFactory.delete(postHashtag)
                .where(postHashtag.postId.eq(postId))
                .execute();
    }
}
