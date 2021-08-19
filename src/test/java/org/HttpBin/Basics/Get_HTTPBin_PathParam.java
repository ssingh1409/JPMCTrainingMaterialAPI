package org.HttpBin.Basics;

import io.restassured.RestAssured;

public class Get_HTTPBin_PathParam {

    public static void main(String[] args) {

        //optimizing code
        String resourcePath= "/users/{username}/repos";
        RestAssured.baseURI="https://api.github.com";
        RestAssured
                .given()
                    .queryParam("sort","pushed")
                    .pathParam("username","ameyanaik")
                .when()
                    .get(resourcePath)
                .then()
                     .log().all()
                     .assertThat().statusCode(200)
                     .assertThat().contentType("application/json");



       //Instead of hardcoding the value of username in get we have passed the value from path param
        //Advantage is we dont  have to change the url everytime instead we can just chnage the path param value
        //Importance :

        //assert more than one thing as part of the code
    }
}
