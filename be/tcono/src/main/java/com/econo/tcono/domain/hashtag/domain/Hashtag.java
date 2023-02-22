package com.econo.tcono.domain.hashtag.domain;

import lombok.Builder;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Hashtag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hashtag_id")
    private Long id;

    private String name;

    protected Hashtag() {
    }

    public Long getId() {
        return id;
    }

    @Builder
    public Hashtag(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hashtag)) return false;
        Hashtag hashtag = (Hashtag) o;
        return this.name.equals(hashtag.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}