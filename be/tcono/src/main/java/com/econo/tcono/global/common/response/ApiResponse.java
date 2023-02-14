package com.econo.tcono.global.common.response;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;
import java.sql.Timestamp;

public class ApiResponse<B> extends ResponseEntity<B> implements Serializable {

    public ApiResponse(HttpStatus status) {
        super(status);
    }

    public ApiResponse(B body, HttpStatus status) {
        super(body, status);
    }

    public static class FailureBody implements Serializable {

        private String code;
        private String message;

        public FailureBody(String code, String message) {
            this.code = code;
            this.message = message;
        }
    }

    public static class SuccessWithDataBody<T> implements Serializable {
        private Timestamp timestamp;
        private String message;
        private T data;

        public SuccessWithDataBody(String message, T data) {
            this.timestamp = new Timestamp(System.currentTimeMillis());
            this.message = message;
            this.data = data;
        }
    }

    public static class SuccessWithoutDataBody<T> implements Serializable {
        private Timestamp timestamp;
        private String message;
        private T data;

        public SuccessWithoutDataBody(String message) {
            this.timestamp = new Timestamp(System.currentTimeMillis());
            this.message = message;
        }
    }

}
