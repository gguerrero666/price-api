package com.lambda.util;

public class Util {
    public static boolean isFound(String url, String tagId){
        return url.indexOf(tagId)>0;
    }

    public static String getChar(String tagType) {
        if (tagType.equals("id")) return "#";
        if (tagType.equals("class")) return ".";
        return "";
    }

}
