package trello.functions;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import trello.common.Base;

import java.util.List;
import java.util.Map;

public class Boards extends Base {

    public static boolean deleteBoard(String boardId){

        String resourcePath ="/1/boards/{id}";
        int statusCode=  RestAssured
                .given()
                     .spec(commonspec)
                        .pathParam("id",boardId)
                .when()
                     .delete(resourcePath)
                .then()
                     .log().all()
                     .extract().response()
                     .statusCode();

      if(statusCode == 200){
          return true;
      }
      else
      {
          return false;
      }

    }

    public static String createBoardAndReturnId(String name){

        String resourcePath ="/1/boards/";
        Response res=  RestAssured
                .given()
                    .spec(commonspec)
                    .queryParam("name",name)
                .when()
                    .post(resourcePath)
                .then()
                 .extract().response();
        return  res.jsonPath().getString("id");

    }

    public static String getListIDByListName(String listName,String boardId){

        String todoListId =null;
        String resourcePath ="1/boards/{id}/lists";
        Response res=  RestAssured
                .given()
                    .spec(commonspec)
                    .pathParam("id",boardId)
                .when()
                    .get(resourcePath)
                .then()

                 .extract().response();

        //fetch the id of the to do list

        List<Map<String, String>> lists = res.jsonPath().getList("$");
        for(Map<String,String> lst : lists ){
            if(lst.get("name").equals(listName)){
                todoListId = lst.get("id");
            }
        }

        return todoListId;
    }


}
