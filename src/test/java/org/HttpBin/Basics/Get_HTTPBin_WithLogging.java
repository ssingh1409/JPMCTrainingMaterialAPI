package org.HttpBin.Basics;

import io.restassured.RestAssured;

public class Get_HTTPBin_WithLogging {

    public static void main(String[] args) {

        RestAssured.baseURI="http://httpbin.org/";

        RestAssured
                .given()
                    .queryParam("company","JPMC")
                    .header("Accept","text/html")
                .when()
                    .get("/get")
                .then()
                    .assertThat().statusCode(200)
                    .log().all();

        //pretty print is not available before aseert its only available after assert we also required extract for that
        //log().all is also available before assert as well as after assert and log().all we can print both body and header of response which we are getting from server
        //In rest assured even if we dont send any header few headers are sent by default that is why we can see response headers

        //Pretty Print can be printed only after response() and it only prints the response body we cannot see headers section of response

        //log().all should be called at the end of Given and at the begining of then
    }
}
