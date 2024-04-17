package com.example.apollo.utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomResponse {
    public CustomResponse(Object data, String msg) {
        this.data = data;
        this.msg = msg;
    }

    public CustomResponse(String msg) {
        this.data = null;
        this.msg = msg;
    }

    Object data;
    String msg;
}