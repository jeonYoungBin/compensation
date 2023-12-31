package com.compensation.compensation.domain.response;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class Response {
    int code;
    String message;
    Object result;

    public Response(int code, String message, Object result) {
        this.code = code;
        this.message = message;
        this.result = result;
    }
}
