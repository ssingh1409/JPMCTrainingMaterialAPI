package org.HttpBin.Basics;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Get_HTTPBin_PathParamEx {

    public static void main(String[] args) {

        //optimizing code
        String resourcePath= "/rest/v2/name/{name}";
        RestAssured.baseURI="https://restcountries.eu";

    Response r= RestAssured
                .given()
                    .pathParam("name","India")
                .when()
                    .get(resourcePath)
                .then()
                     .log().all().
                extract().response();
             String name= r.body().jsonPath().getString("[0].name");
             System.out.println("First country name is :"+name);





    }
}
