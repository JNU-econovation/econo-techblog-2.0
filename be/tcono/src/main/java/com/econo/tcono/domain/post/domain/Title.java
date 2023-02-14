package com.econo.tcono.domain.post.domain;

import com.econo.tcono.domain.post.exception.InvalidTitleException;
import com.econo.tcono.global.exception.ErrorCode;

import javax.persistence.Column;

public class Title {
    private static final int MAX_TITLE_LENGTH = 30;

    @Column(name = "post_title", nullable = false)
    private String title;

    protected Title() {
    }

    public Title(String title) {
        validate(title);
        this.title = title;
    }

    private void validate(String title) {
        if (title == null || title.isBlank()) {
            throw new InvalidTitleException(ErrorCode.NOT_EMPTY_TITLE);
        }

        if (title.length() > MAX_TITLE_LENGTH) {
            throw new InvalidTitleException(ErrorCode.NOT_ALLOWED_MIN_SIZE_TITLE);
        }
    }
}
