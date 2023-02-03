package com.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.lambda.util.Util;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Main implements RequestHandler<Request, Object> {

    public static void main(String[] args) {
        Main m = new Main();
//        Request request = new Request("GET",
//                "https://www.homedepot.com.mx/organizadores-y-closets/closets/closets-armables/closet-playcon-mod-supremo-5-cajones-242-cm-grafito-texturizado-159373",
//                "offerPrice_1074152",
//                "id");
        Request request = new Request("GET",
                "https://www.walmart.com.mx/juguetes/carritos-y-radiocontrol/aviones-y-helicopteros-de-control-remoto/smartphone-samsung-m23-128gb-verde-desbloqueado_00880609418881",
                "product-price",
                "id");
        System.out.println(m.handleRequest(request, null));
    }

    @Override
    public Object handleRequest(Request request, Context context) {

        if (request == null) {
            return "200";
        }

        if (request.getHttpMethod() == null) {
            return "200";
        }

        if (request.getHttpMethod().equals("GET")) {
            if (!request.getUrl().isEmpty()) {
                if (!request.getTagId().isEmpty()) {
                    try {

                        Document htmlCode = Jsoup.connect(request.getUrl()).get();
                        boolean found = Util.isFound(htmlCode.toString(), request.getTagId());

                        if (found) {
                            Elements c = htmlCode.select(Util.getChar(request.getTagType()) + request.getTagId());
                            if (c.eachText().size() > 0) {
                                request.setPrice(c.eachText().get(0).replace("00", ".00"));
                            }
                        }
                        request.setFound(found);

                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    return request;
                }
            }
        }
        if (request.getHttpMethod().equals("POST")) {
            return "POST";
        }
        return null;
    }
}

//<span id="offerPrice_1074152" class="price">	 <small>$</small>6,979<sup>00</sup>	 <span></span>	 </span>