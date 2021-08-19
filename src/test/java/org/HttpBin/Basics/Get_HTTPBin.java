package org.HttpBin.Basics;

import io.restassured.RestAssured;

public class Get_HTTPBin {

    public static void main(String[] args) {

        RestAssured.get("http://httpbin.org/get").prettyPrint();

        //
        RestAssured.baseURI="http://httpbin.org/get";
    }
}
