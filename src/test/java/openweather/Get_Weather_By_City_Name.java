package openweather;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Get_Weather_By_City_Name extends openweatherBaseTest{


//    @Test
//    public void testWeatherReturnedForDelhi(){
//        int actualStatus = getWeatherByCity("New Delhi").getStatusCode();
//        Assert.assertEquals(actualStatus,200);
//
//    }
//    @Test
//    public void testWeatherReturnedForMumbai(){
//        int actualStatus = getWeatherByCity("Mumbai").getStatusCode();
//        Assert.assertEquals(actualStatus,200);
//
//    }
//
//    //Chaining of requests
    @Test
    public void testGetIdAndSearch(){
        Response res1 = openWeatherFunctionality.getWeatherByCity("Mumbai");
      //  Assert.assertEquals(actualStatus,200);

        //1.sEARCH USING CITI NAME
        //2.Extract ID of that city
        //3.Search using citi id
        //4.Verify wather in step 1 and setp 3 is same

        //Extract Id of that city
        int id =res1.getBody().jsonPath().getInt("id");
        Response res2= openWeatherFunctionality.getWeatherById(id);

        String step1wather =res1.getBody().jsonPath().getString("weather[0].main");
        String step2wather =res1.getBody().jsonPath().getString("weather[0].main");
        Assert.assertEquals(step1wather,step2wather);
    }


    @Test
    public void testWeather(){

        Response res= openWeatherFunctionality.getWeatherByCity("New Delhi");
        int actual = res.getStatusCode();

         Double longitutde =  res.jsonPath().getDouble("coord.lon");
         Double latitude =  res.jsonPath().getDouble("coord.lat");

        System.out.println("Longitude is :"+longitutde);
        System.out.println("Latitude is :"+latitude);

        //return response as String
        System.err.println(res.asString());

    }
}
