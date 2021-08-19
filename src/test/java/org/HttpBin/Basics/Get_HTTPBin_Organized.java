package org.HttpBin.Basics;

import io.restassured.RestAssured;

public class Get_HTTPBin_Organized {

    public static void main(String[] args) {

        RestAssured.baseURI="http://httpbin.org/";
        RestAssured
                .get("/get")
                .prettyPrint();

        //This concept is called as "Method chaining" .Rest Assured api supports method chaining
        //convert basic commands which w3c accepts
    }
}
