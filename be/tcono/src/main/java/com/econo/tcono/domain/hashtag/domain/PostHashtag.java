package com.econo.tcono.domain.hashtag.domain;

import lombok.Builder;

import javax.persistence.*;

@Entity
public class PostHashtag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_hashtag_id")
    private Long id;

    private Long postId;

    private Long hashtagId;

    protected PostHashtag() {
    }

    @Builder
    public PostHashtag(Long postId, Long hashtagId) {
        this.postId = postId;
        this.hashtagId = hashtagId;
    }
}
