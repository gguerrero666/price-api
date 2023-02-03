package com.lambda;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Request {
    public Request(String httpMethod, String url, String tagId, String tagType) {
        this.httpMethod = httpMethod;
        this.url = url;
        this.tagId = tagId;
        this.tagType = tagType;
    }

    private String httpMethod;

    private String url;

    private String tagId;

    private String tagType;

    private boolean isFound;

    private String price;

}
