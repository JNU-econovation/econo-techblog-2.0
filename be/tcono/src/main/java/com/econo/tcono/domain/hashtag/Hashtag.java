package com.econo.tcono.domain.hashtag;

import javax.persistence.*;

@Entity
public class Hashtag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hashtag_id")
    private Long id;

    private String name;

    protected Hashtag() {
    }
}