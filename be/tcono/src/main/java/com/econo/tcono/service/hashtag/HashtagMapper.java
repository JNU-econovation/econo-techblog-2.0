package com.econo.tcono.service.hashtag;

import com.econo.tcono.domain.hashtag.domain.Hashtag;
import com.econo.tcono.domain.hashtag.domain.PostHashtag;
import org.springframework.stereotype.Component;

@Component
public class HashtagMapper {
    public Hashtag mapFrom(String hashtag) {
        return Hashtag.builder()
                .name(hashtag)
                .build();
    }
}
