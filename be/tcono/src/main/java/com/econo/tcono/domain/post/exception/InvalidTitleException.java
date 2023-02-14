package com.econo.tcono.domain.post.exception;

import com.econo.tcono.global.exception.BusinessException;
import com.econo.tcono.global.exception.ErrorCode;

public class InvalidTitleException extends BusinessException {
    public InvalidTitleException(ErrorCode errorCode) {
        super(errorCode);
    }
}
