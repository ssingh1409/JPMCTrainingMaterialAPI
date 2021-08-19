package trello.functions;

import io.restassured.RestAssured;
import trello.common.Base;

public class Cards extends Base {

    public static int addNewCardToListUsingListId(String todoListId, String cardTitle){

       return RestAssured
                .given()
                     .spec(commonspec)
                     .queryParam("idList",todoListId)
                       .queryParam("name",cardTitle)
                .when()
                    .post("/1/cards")
                .then()
                .extract().response().statusCode();

    }
}
