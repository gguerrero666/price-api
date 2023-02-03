package com.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class Main implements RequestHandler<Request, Object> {

    public String handleRequest(String nombre, Context context) {
        context.getLogger().log("Nombre: " + nombre);
        return "Hola " + nombre;
    }

    @Override
    public Object handleRequest(Request request, Context context) {

        if (request.getHttpMethod()==null){
            return "200";
        }

        switch (request.getHttpMethod()){
            case "GET":
                if(!request.getName().isEmpty()){
                    return "Hola " + request.getName();
                }
                else {
                    return "Hola incognito";
                }
            case "POST":
        }
        return null;
    }
}