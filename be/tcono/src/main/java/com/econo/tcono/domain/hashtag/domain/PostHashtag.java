package com.econo.tcono.domain.hashtag.domain;

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
}
