package com.econo.tcono.service.like;

import com.econo.tcono.domain.like.domain.Like;
import com.econo.tcono.domain.like.repository.LikeRepository;
import com.econo.tcono.domain.post.repository.PostRepository;
import org.springframework.transaction.annotation.Transactional;


@Transactional(readOnly = true)
public class LikeServiceImpl implements LikeService {
    private final LikeMapper likeMapper;
    private final LikeRepository likeRepository;
    private final PostRepository postRepository;

    public LikeServiceImpl(LikeMapper likeMapper, LikeRepository likeRepository, PostRepository postRepository) {
        this.likeMapper = likeMapper;
        this.likeRepository = likeRepository;
        this.postRepository = postRepository;
    }

    @Override
    public boolean flipLike(Long postId, Long idpId) {
        boolean isExist = likeRepository.existsByPostIdAndIdpId(postId, idpId);
        if (isExist) {
            likeRepository.deleteByPostIdAndIdpId(postId, idpId);
            postRepository.decreaseLikeCount(postId);
            return false;
        }
        addNewPostLike(postId, idpId);
        postRepository.increaseLikeCount(postId);
        return true;
    }

    private void addNewPostLike(Long postId, Long idpId) {
        Like like = likeMapper.mapFrom(postId, idpId);
        likeRepository.save(like);
    }

    @Override
    public void deleteByPostId(Long postId) {
        likeRepository.deleteAllByPostId(postId);
    }
}
