package com.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class Main implements RequestHandler<Request, Object> {

    @Override
    public Object handleRequest(Request request, Context context) {

        if (request==null){
            return "200";
        }

        if (request.getHttpMethod()==null){
            return "200";
        }

        switch (request.getHttpMethod()){
            case "GET":
                if(!request.getUrl().isEmpty()) {
                    return "URL: " + request.getUrl();
                }
        }
        return null;
    }
}