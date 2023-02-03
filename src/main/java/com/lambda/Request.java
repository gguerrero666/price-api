package com.lambda;

import lombok.Data;

@Data
public class Request {
    private String httpMethod;

    private String url;

    private String tag;

}
