package openweather;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class openWeatherFunctionality extends openweatherBaseTest {

    public static Response getWeatherByCity(String cityName){

        return RestAssured
                .given()
                    .spec(commonspec)
                    .queryParam("q",cityName)
                .when()
                      .get("/data/2.5/weather")
                .then()
                      .log().all()
                      .extract().response();
    }

    public static Response getWeatherById(int cityId){

        return RestAssured
                .given()
                    .spec(commonspec)
                    .queryParam("q",cityId)
                .when()
                    .get("/data/2.5/weather")
                .then()
                    .log().all()
                     .extract().response();

    }
}
