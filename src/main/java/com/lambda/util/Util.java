package com.lambda.util;

public class Util {
    public static boolean isFound(String url, String tagId){
        return url.contains(tagId);
    }

    public static String getChar(String tagType) {
        if (tagType.equals("id")) return "#";
        if (tagType.equals("class")) return ".";
        return "";
    }

}
