package com.econo.tcono.domain.like;

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
}