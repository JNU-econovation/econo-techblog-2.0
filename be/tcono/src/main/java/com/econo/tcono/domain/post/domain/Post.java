package com.econo.tcono.domain.post.domain;

import javax.persistence.*;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "post_type")
    private PostType posttype;

    @Embedded
    private Title title;

    @Embedded
    private Content content;

    @Embedded
    private ImageUri imageUri;

    @Column(name = "post_views")
    private int views = 0;

    @Column(name = "post_like_count")
    private int likeCount = 0;
}