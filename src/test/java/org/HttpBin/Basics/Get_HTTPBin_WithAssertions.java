package org.HttpBin.Basics;

import io.restassured.RestAssured;

public class Get_HTTPBin_WithAssertions {

    public static void main(String[] args) {

        RestAssured.baseURI="http://httpbin.org/";

        RestAssured
                .given()
                    .queryParam("company","JPMC")
                .when()
                    .get("/get")

                .then()
                    .assertThat().statusCode(200)
                    .extract().response()
                    .prettyPrint();

        //Any test can be organised in given , when and then format
        //we have pre-requisite(Arrange ), we have action, we have assert
        //During Arrangement part we use -> Given
        //After Given during action starts when we do this use -> When
        //fOR Assertions we used -> Then
        //Rest assured is also supports Cucumber- format of Given , when , then as well as annotations to make your scripts more readable
       // when -> you will have actual request
        //Inside Then you will have actual assertions or validations

        //Pretty Print can be printed only after response()
    }
}
