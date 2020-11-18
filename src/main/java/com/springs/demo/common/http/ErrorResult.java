package com.springs.demo.common.http;

import lombok.Data;

@Data
public class ErrorResult<T> {
    private int code;
    private String message;
    private T data;



    public static ErrorResult error(int code, String message) {
        ErrorResult errorResult = new ErrorResult();
        errorResult.setCode(code);
        errorResult.setMessage(message);
        return errorResult;
    }

    public static <V> ErrorResult<V> error(int code, String message, V data) {
        ErrorResult<V> errorResult = new ErrorResult<V>();
        errorResult.setCode(code);
        errorResult.setMessage(message);
        errorResult.setData(data);
        return errorResult;
    }

    // getter / setter 略
}