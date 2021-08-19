package org.HttpBin.Basics;

import io.restassured.RestAssured;

public class Get_HTTPBin_WithParam {

    public static void main(String[] args) {

        RestAssured.baseURI="http://httpbin.org/";
        RestAssured
                .given()
                    .param("company","JPMC")
                .get("/get")
                .prettyPrint();


        //Rest assured use the concept for behavior driven approach for sending parameters or params
        //It is good practice to always use given in rest assured for mostly adding params , headers etc
        //now out put will have args section with the parameters passed in request
        //this service is mad in such a way that it will return back whatever was sent by you in request so server returned it back
        //so that we can validate what was being sent and out put was also have   "url": "http://httpbin.org/get?company=JPMC"

        //Rest assured is also supports Cucumber- format of Given , when , then as well as annotations to make your scripts more readable
       // when -> you will have actual request
        //Inside Then you will have actual assertions or validations
    }
}
