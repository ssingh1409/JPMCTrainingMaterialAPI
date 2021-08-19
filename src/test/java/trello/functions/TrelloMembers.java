package trello.functions;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import trello.common.Base;

import java.util.List;
import java.util.Map;

public class TrelloMembers extends Base {

    public static List<String> getBoardsNameForThisMember(){

        //id is path parameter
        String resourcePath ="1/members/{id}/boards";
       List<String> names =  RestAssured
                .given()
                    .spec(commonspec)
                    .pathParam("id","me")
                .when()
                    .get(resourcePath)
                .then()
               .log().all()
                    .extract().response()
                   .jsonPath().getList("name");

       return names;

    }

    public static String getFirstIdOfBoard(){

        String resourcePath ="1/members/{id}/boards";
       Response res =  RestAssured
                .given()
                    .spec(commonspec)
                  .pathParam("id","me")
                .when()
                    .get(resourcePath)
                .then()
                    .extract().response();


        return res.body().jsonPath().getString("[0].id");

    }

public static  String getBoardIDByName(String boardName){

    String resourcePath ="1/members/{id}/boards";
    String boardId = null;
    Response res=  RestAssured
            .given()
                 .spec(commonspec)
                 .pathParam("id","me")
            .when()
            .get(resourcePath);

    List<Map<String,?>> boards = res.jsonPath().getList("$");
    for (Map<String,?> board : boards) {

        if(board.get("name").equals(boardName)){
            boardId =(String) board.get("id");
        }

    }
    return boardId;



}


}

//when we will have a method along with the resource