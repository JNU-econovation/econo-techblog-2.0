package com.econo.tcono.response;

import lombok.experimental.UtilityClass;
import org.springframework.http.HttpStatus;

@UtilityClass
public class ApiResponseGenerator {

    public static ApiResponse<Void> success(final HttpStatus status) {
        return new ApiResponse<>(status);
    }

    public static <D> ApiResponse<D> success(final D data, final HttpStatus status) {
        return new ApiResponse<>(data, status);
    }

    public static ApiResponse<Void> fail(final HttpStatus status) {
        return new ApiResponse<>(status);
    }

    public static ApiResponse<ApiResponse.FailureBody> fail(
            final ApiResponse.FailureBody body, final HttpStatus status) {
        return new ApiResponse<>(body, status);
    }

    public static ApiResponse<ApiResponse.FailureBody> fail(
            final String code, final String message, final HttpStatus status) {
        return new ApiResponse<>(new ApiResponse.FailureBody(code, message), status);
    }
}

