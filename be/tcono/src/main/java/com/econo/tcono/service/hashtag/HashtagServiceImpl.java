package com.econo.tcono.service.hashtag;

import com.econo.tcono.domain.hashtag.domain.Hashtag;
import com.econo.tcono.domain.hashtag.domain.Hashtags;
import com.econo.tcono.domain.hashtag.domain.PostHashtag;
import com.econo.tcono.domain.hashtag.repository.HashtagRepository;
import com.econo.tcono.domain.hashtag.repository.PostHashtagRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class HashtagServiceImpl implements HashtagService {
    private final HashtagRepository hashtagRepository;
    private final PostHashtagRepository postHashtagRepository;
    private final HashtagMapper hashtagMapper;
    private final PostHashtagMapper postHashtagMapper;

    public HashtagServiceImpl(HashtagRepository hashtagRepository, PostHashtagRepository postHashtagRepository, HashtagMapper hashtagMapper, PostHashtagMapper postHashtagMapper) {
        this.hashtagRepository = hashtagRepository;
        this.postHashtagRepository = postHashtagRepository;
        this.hashtagMapper = hashtagMapper;
        this.postHashtagMapper = postHashtagMapper;
    }

    @Override
    @Transactional
    public void saveHashtagWithPost(String reqHashtags, Long postId) {
        postHashtagRepository.saveAll(getPostHashtagList(reqHashtags, postId));
    }

    private List<PostHashtag> getPostHashtagList(String reqHashtags, Long postId) {
        return splitHashtag(reqHashtags).stream()
                .map((hashtag -> postHashtagMapper.mapFrom(saveHashtag(hashtag).getId(), postId)))
                .collect(Collectors.toList());
    }

    private List<String> splitHashtag(String reqHashtags) {
        return List.of(reqHashtags.split(","));
    }

    private Hashtag saveHashtag(String name) {
        return hashtagRepository.findByName(name)
                .orElseGet(() -> hashtagRepository.save(hashtagMapper.mapFrom(name)));
    }

    @Override
    public Hashtags getHashtagsByPostId(Long postId) {
        List<Hashtag> hashtags = new ArrayList<>();
        getHashtagIdByPostId(postId)
                .forEach(hashtagId -> makeHashtags(hashtags, hashtagId));

        return Hashtags.of(hashtags);
    }

    private boolean makeHashtags(List<Hashtag> hashtags, Long hashtagId) {
        return hashtags.add(hashtagRepository.findHashtagById(hashtagId));
    }

    private List<Long> getHashtagIdByPostId(Long postId) {
        return postHashtagRepository.findHashtagIdByPostId(postId);
    }

    @Override
    @Transactional
    public void deleteHashtagIdByPostId(Long postId) {
        postHashtagRepository.deleteByPostId(postId);
    }

}