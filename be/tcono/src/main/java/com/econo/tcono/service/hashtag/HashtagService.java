package com.econo.tcono.service.hashtag;

import com.econo.tcono.domain.hashtag.domain.Hashtag;
import com.econo.tcono.domain.hashtag.repository.HashtagRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class HashtagService {
    private final HashtagRepository hashtagRepository;
    private final HashtagMapper hashtagMapper;

    public HashtagService(HashtagRepository hashtagRepository, HashtagMapper hashtagMapper) {
        this.hashtagRepository = hashtagRepository;
        this.hashtagMapper = hashtagMapper;
    }

    /**
     * 존재하지 않은 해시태그 일 경우만 저장
     *
     * @param hashtags
     */
    @Transactional
    public void saveHashtagWithPost(String hashtags) {
        splitHashtag(hashtags)
                .forEach(this::saveHashtag);
    }

    private List<String> splitHashtag(String hashtags) {
        return List.of(hashtags.split(","));
    }

    private Hashtag saveHashtag(String name) {
        return hashtagRepository.findByName(name)
                .orElseGet(() -> hashtagRepository.save(hashtagMapper.mapFrom(name)));
    }

}