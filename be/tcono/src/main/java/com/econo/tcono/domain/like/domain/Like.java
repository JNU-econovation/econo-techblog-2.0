package com.econo.tcono.domain.like.domain;

import lombok.Builder;

import javax.persistence.*;

@Entity
@Table(name = "Likes")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "like_id")
    private Long id;

    @Column(name = "post_id")
    private Long postId;

    @Column(name = "idp_id")
    private Long idpId;

    @Builder
    public Like(Long postId, Long idpId) {
        this.postId = postId;
        this.idpId = idpId;
    }

    protected Like() {
    }
}