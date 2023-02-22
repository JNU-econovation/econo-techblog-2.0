package com.econo.tcono.global.exception;


import com.econo.tcono.global.common.response.ApiResponse;
import com.econo.tcono.global.common.response.ApiResponseGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import java.nio.file.AccessDeniedException;

@Slf4j
@RestControllerAdvice
public class ApiExceptionHandler {

    private static final String LOG_MESSAGE_FORMAT = "{} '{}' - {}";
    private static final String UNCAUGHT_LOG_MESSAGE = "??";

    @ExceptionHandler(IllegalArgumentException.class)
    public final ApiResponse<ApiResponse.FailureBody> handleBadRequest(
            final IllegalArgumentException ex, final WebRequest request) {
        this.writeLog(ex, request);
        ApiResponse.FailureBody failureBody = new ApiResponse.FailureBody(
                HttpStatus.BAD_REQUEST.toString(),
                ex.getMessage());
        return ApiResponseGenerator.fail(failureBody, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BusinessException.class)
    public final ApiResponse<ApiResponse.FailureBody> handleConflict(
            final BusinessException ex, final WebRequest request) {
        this.writeLog(ex, request);
        ApiResponse.FailureBody failureBody = new ApiResponse.FailureBody(
                ex.getErrorCode().getErrorCode(),
                ex.getErrorCode().getMessage());

        return ApiResponseGenerator.fail(failureBody, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({AccessDeniedException.class})
    public ApiResponse<ApiResponse.FailureBody> handleForbidden(
            final AccessDeniedException ex, final WebRequest request) {
        this.writeLog(ex, request);
        ApiResponse.FailureBody failureBody = new ApiResponse.FailureBody(
                HttpStatus.FORBIDDEN.toString(),
                ex.getMessage());

        return ApiResponseGenerator.fail(failureBody, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(Exception.class)
    public ApiResponse<ApiResponse.FailureBody> handleInternalServerError(final Exception ex, final WebRequest request) {
        this.writeLog(ex, request);
        ApiResponse.FailureBody failureBody = new ApiResponse.FailureBody(
                HttpStatus.INTERNAL_SERVER_ERROR.toString(),
                ex.getMessage());

        return ApiResponseGenerator.fail(failureBody, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private <E extends Exception> void writeLog(final E ex, final WebRequest webRequest) {
        try {
            HttpServletRequest servletRequest = ((ServletWebRequest) webRequest).getRequest();
            log.error(
                    LOG_MESSAGE_FORMAT,
                    servletRequest.getMethod(),
                    servletRequest.getRequestURI(),
                    ex.getMessage(),
                    ex);
        } catch (Exception e) {
            log.error(LOG_MESSAGE_FORMAT, UNCAUGHT_LOG_MESSAGE, UNCAUGHT_LOG_MESSAGE, e.getMessage(), e);
        }
    }
}