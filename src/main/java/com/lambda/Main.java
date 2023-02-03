package com.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.lambda.util.Util;

import java.io.IOException;

public class Main implements RequestHandler<Request, Object> {

    @Override
    public Object handleRequest(Request request, Context context) {

        if (request==null){
            return "200";
        }

        if (request.getHttpMethod()==null){
            return "200";
        }

        if (request.getHttpMethod().equals("GET")) {
            if (!request.getUrl().isEmpty()) {
                if (!request.getTagId().isEmpty()) {
                    try {
                        request.setFound(Util.isFound(Util.getPageCode(request.getUrl()), request.getTagId()));
                    } catch (IOException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return request;
                }
            }
        }
        return null;
    }
}

//<span id="offerPrice_1074152" class="price">	 <small>$</small>6,979<sup>00</sup>	 <span></span>	 </span>