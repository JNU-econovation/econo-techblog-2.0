package com.econo.tcono.domain.hashtag.repository;


import com.econo.tcono.domain.hashtag.domain.PostHashtag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostHashtagRepository extends JpaRepository<PostHashtag, Long>, PostHashtagCustomRepository {
    void deletePostHashtagByPostId(Long postId);
}
