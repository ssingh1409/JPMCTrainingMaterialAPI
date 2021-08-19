package trello.functions;

import io.restassured.RestAssured;
import trello.common.Base;

import java.util.List;

public class CreateBoard extends Base {

    public static int createNewBoard(String name){

        String resourcePath ="/1/boards/";
        int status=  RestAssured
                .given()
                .spec(commonspec)
                .queryParam("name",name)

                .when()
                    .post(resourcePath)
                .then()
                     .log().all()
                   .extract().response()
                    .statusCode();

        return status;


    }

}
