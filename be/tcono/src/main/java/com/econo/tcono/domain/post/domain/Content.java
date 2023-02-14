package com.econo.tcono.domain.post.domain;

import com.econo.tcono.domain.post.domain.exception.InvalidContentException;
import com.econo.tcono.global.exception.ErrorCode;

import javax.persistence.Embeddable;

@Embeddable
public class Content {
    private static final int MIN_CONTENT_LENGTH = 100;
    private String content;

    public Content() {
        validate(content);
        this.content = content;
    }

    private void validate(String content) {
        if (content.length() < MIN_CONTENT_LENGTH) {
            throw new InvalidContentException(ErrorCode.NOT_ALLOWED_MAX_SIZE_CONTENT);
        }
    }

}
