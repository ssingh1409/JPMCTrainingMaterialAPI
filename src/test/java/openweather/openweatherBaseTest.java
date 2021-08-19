package openweather;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;

public class openweatherBaseTest {


    //we can create request specification object
    //to create this object we need to use another class requestspec builder i.e any thing part of your request can be added in this request spec builder and then builder
    //so we can add anything - header , query , anything part of request and build the same
    //we can also have more than one commonspec
    //Rest assured provided requestspec builder will build all the provided values such as header , request , query param together and then build it
    static RequestSpecification commonspec;


    @BeforeTest
    public void beforeTest(){
//        RestAssured.baseURI="https://api.openweathermap.org/";
        commonspec=new RequestSpecBuilder()
                //provide base uri also as part of commonspec
                .setBaseUri("https://api.openweathermap.org/")
                .addQueryParam("appid","04a3ef87929f0628417b03bfbb1cad5c")
                .addHeader("contentType","application/json")
                .build();
    }

}
