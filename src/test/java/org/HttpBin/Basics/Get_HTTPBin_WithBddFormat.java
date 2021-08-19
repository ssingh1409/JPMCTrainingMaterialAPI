package org.HttpBin.Basics;

import io.restassured.RestAssured;

public class Get_HTTPBin_WithBddFormat {

    public static void main(String[] args) {

        RestAssured.baseURI="http://httpbin.org/";
        RestAssured
                .given()
                    .param("company","JPMC")
                    .header("MyHeader1","Custom header value 1")
                    .cookie("MyCookie1","Custom Cookie Value 1")
                .when()
                    .get("/get")
                .then()
                    .extract()
                     .response()
                     .prettyPrint();


        //Rest assured is also supports Cucumber- format of Given , when , then as well as annotations to make your scripts more readable
       // when -> you will have actual request
        //Inside Then you will have actual assertions or validations
    }
}
