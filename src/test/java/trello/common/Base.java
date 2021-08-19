package trello.common;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeSuite;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Base {


    //we can create request specification object
    //to create this object we need to use another class requestspec builder i.e any thing part of your request can be added in this request spec builder and then builder
    //so we can add anything - header , query , anything part of request and build the same
    //we can also have more than one commonspec
    //Rest assured provided requestspec builder will build all the provided values such as header , request , query param together and then build it
   protected static RequestSpecification commonspec;

    @BeforeSuite
    public void beforeTest() throws FileNotFoundException , IOException{
//        RestAssured.baseURI="https://api.openweathermap.org/";
        commonspec=new RequestSpecBuilder()
                //provide base uri also as part of commonspec
                .setBaseUri("https://api.trello.com/")
                //This is how we set proxy
//                .setProxy("127.0.01",8080)

                //for few of the post api's you require to set content type
                .setContentType(ContentType.JSON)
                .addQueryParam("key",Utilities.getProperty("trelloKey"))
                .addQueryParam("token",Utilities.getProperty("trelloToken"))
                .addHeader("Accept","application/json")
                .build();
    }


}
