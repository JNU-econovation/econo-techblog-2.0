package com.econo.tcono.service.hashtag;

import com.econo.tcono.domain.hashtag.domain.Hashtags;

public interface HashtagService {
    void saveHashtagWithPost(String reqHashtags, Long postId);
    Hashtags getHashtagsByPostId(Long postId);
    void deleteHashtagIdByPostId(Long postId);
}
