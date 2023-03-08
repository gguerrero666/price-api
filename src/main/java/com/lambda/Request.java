package com.lambda;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
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

    private boolean saved;

    private String date;

}
