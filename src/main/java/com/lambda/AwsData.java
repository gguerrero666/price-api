package com.lambda;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AwsData {

    private int id_product;
    private String category;
    private String product_name;
    private String product_description;

}
