package com.lambda.util;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Util {
    public static boolean isFound(String url, String tagId) {
        return url.contains(tagId);
    }

    public static String getChar(String tagType) {
        if (tagType.equals("id")) return "#";
        if (tagType.equals("class")) return ".";
        return "";
    }

    public static String getPageCode(String url) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

}
