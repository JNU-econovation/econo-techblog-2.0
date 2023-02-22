package com.econo.tcono.web.dto;

import lombok.Getter;

@Getter
public class CreatePostDto {
    private String postType;
    private String title;
    private String hashTag;
    private String content;
}
