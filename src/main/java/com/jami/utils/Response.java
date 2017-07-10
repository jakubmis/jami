package com.jami.utils;

import lombok.Data;

/**
 * Created by Mis on 2017-07-10.
 */
@Data
public class Response<T> {

    private static final String EMPTY = "";
    public static final String OK = "OK";

    private String message;
    private T data;

    private Response() {
        this.message = EMPTY;
    }

    public static <T> Response create(T data, String message) {
        Response response = new Response();
        response.data = data;
        if (message != null) {
            response.message = message;
        }
        return response;
    }
    public static <T> Response create(String message) {
        Response response = new Response();
        if (message != null) {
            response.message = message;
        }
        return response;
    }

    public static Response success() {
        Response response = new Response();
        response.message = OK;
        return response;
    }
}
