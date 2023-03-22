package com.lambda;

import com.lambda.util.Util;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class AWSMain {

    private static String url = "https://aws.amazon.com/products/?aws-products-all.sort-by=item.additionalFields.productNameLowercase&aws-products-all.sort-order=asc&awsf.re%3AInvent=*all&awsf.Free%20Tier%20Type=*all&awsf.tech-category=*all&awsm.page-aws-products-all=1";
    private static String service = "m-headline";
    public static void main(String[] args){
        try {

            Document htmlCode = Jsoup.connect(url).get();
            boolean found = Util.isFound(htmlCode.toString(), service);

            System.out.println(found);

        }catch (Exception e){
            System.out.println(e);
        }
    }
}
