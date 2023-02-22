package com.econo.tcono.service.post;

import com.econo.tcono.domain.post.domain.Content;
import com.econo.tcono.domain.post.domain.Post;
import com.econo.tcono.domain.post.domain.PostType;
import com.econo.tcono.domain.post.domain.Title;
import com.econo.tcono.web.dto.CreatePostDto;
import org.springframework.stereotype.Component;

@Component
public class PostMapper {
    public Post mapFrom(CreatePostDto createPostDto) {
        return Post.builder()
                .title(toTitle(createPostDto.getTitle()))
                .content(toContent(createPostDto.getContent()))
                .posttype(toPosttype(createPostDto.getPostType()))
                .build();
    }

    private Title toTitle(String title) {
        return Title.builder()
                .title(title)
                .build();
    }

    private Content toContent(String content) {
        return Content.builder()
                .content(content)
                .build();
    }

    private PostType toPosttype(String posttype) {
        return PostType.valueOf(posttype);
    }

}
