package com.nathaliamello.gitflowdemo.common.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ApiResponse<T> {

    private T data;
    private String message;
    private int statusCode;
    private String errorCode;  // Código de erro específico
    private LocalDateTime timestamp;
    private List<String> errors;
    private List<Link> links;

    public ApiResponse() {
        this.timestamp = LocalDateTime.now();
    }

    public ApiResponse(T data, String message, int statusCode, String errorCode, List<String> errors, List<Link> links) {
        this.data = data;
        this.message = message;
        this.statusCode = statusCode;
        this.errorCode = errorCode;
        this.timestamp = LocalDateTime.now();
        this.errors = errors;
        this.links = links;
    }
}
