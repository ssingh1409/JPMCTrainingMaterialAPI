package employee;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class PostJosnExample {

    @Test
    public void testCreateEmployeeWithStringBody(){

        RestAssured.baseURI="http://dummy.restapiexample.com";
        String resourcePath ="/api/v1/create";


        RestAssured
                .given()
                .body("{\"name\":\"test\",\"salary\":\"123\",\"age\":\"23\"}")
                .when()

                .post(resourcePath)
                .then()
                .log().all()
                .assertThat().statusCode(200);
    }

    public void testCreateEmployeeWithJsonObject()
    {

        RestAssured.baseURI="http://dummy.restapiexample.com";
        String resourcePath ="/api/v1/create";
//        JSONObject payload = new JSONObject();
//
//        payload.put("name","soin");
//        payload.put("age","10");
//        payload.put("salary","1000");
//
//
//        RestAssured
//                .given()
//                .body(payload.toString())
//                .when()

//                .post(resourcePath)
//                .then()
//                .log().all()
//                .assertThat().body("status", Matchers.equalTo("success"));

    }
}
