package com.econo.tcono.domain.post.domain.exception;

import com.econo.tcono.global.exception.BusinessException;
import com.econo.tcono.global.exception.ErrorCode;

public class InvalidContentException extends BusinessException {
    public InvalidContentException(ErrorCode errorCode) {
        super(errorCode);
    }
}
