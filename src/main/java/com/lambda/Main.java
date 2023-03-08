package com.lambda;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.lambda.util.Util;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Main implements RequestHandler<Request, Object> {

    private AmazonDynamoDB amazonDynamoDB;

    public static void main(String[] args) {
        Main m = new Main();
        Request request = new Request("GET",
                "https://www.homedepot.com.mx/organizadores-y-closets/closets/closets-armables/closet-playcon-mod-supremo-5-cajones-242-cm-grafito-texturizado-159373",
                "offerPrice_1074152",
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

                                request.setDate(getDate());

                                // DynamoDB Code:
                                this.initDynamoDbClient();
                                request.setSaved(saveData(request));


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


    private boolean saveData(Request request) {

        String DYNAMODB_TABLE_NAME = "log-prices";

        Map<String, AttributeValue> attributesMap = new HashMap<>();

        attributesMap.put("httpMethod", new AttributeValue(String.valueOf(request.getHttpMethod())));
        attributesMap.put("url", new AttributeValue(request.getUrl()));
        attributesMap.put("tagId", new AttributeValue(request.getTagId()));
        attributesMap.put("tagType", new AttributeValue(String.valueOf(request.getTagType())));
        attributesMap.put("price", new AttributeValue(request.getPrice()));
        attributesMap.put("date", new AttributeValue(request.getDate()));

        amazonDynamoDB.putItem(DYNAMODB_TABLE_NAME, attributesMap);

        return true;

    }

    private void initDynamoDbClient() {
        this.amazonDynamoDB = AmazonDynamoDBClientBuilder.standard()
                .withRegion(Regions.US_EAST_1)
                .build();
    }

    private String getDate(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return formatter.format(date);
    }
}