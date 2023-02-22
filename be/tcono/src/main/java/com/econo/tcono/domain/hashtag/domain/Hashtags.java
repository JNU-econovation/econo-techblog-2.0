package com.econo.tcono.domain.hashtag.domain;

import lombok.Builder;

import java.util.List;
import java.util.stream.Collectors;

public class Hashtags {
    private List<Hashtag> hashtags;

    public Hashtags(List<Hashtag> hashtags) {
        this.hashtags = hashtags;
    }

    public static Hashtags of(List<Hashtag> hashtags) {
        return new Hashtags(hashtags);
    }

}
