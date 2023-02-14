package com.econo.tcono.global.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;


public enum ErrorCode {
    NOT_EMPTY_TITLE(HttpStatus.BAD_REQUEST, "P-001", "빈 제목은 허용되지 않습니다."),
    NOT_ALLOWED_MIN_SIZE_TITLE(HttpStatus.BAD_REQUEST, "P-002", "제목은 최소 30글자 입니다."),
    NOT_ALLOWED_MAX_SIZE_CONTENT(HttpStatus.BAD_REQUEST, "P-003", "내용은 최소 100글자 입니다.");

    ErrorCode(HttpStatus httpStatus, String errorCode, String message) {
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.message = message;
    }

    private HttpStatus httpStatus;
    private String errorCode;
    private String message;

    public String getMessage() {
        return message;
    }

    public String getErrorCode() {
        return errorCode;
    }
}