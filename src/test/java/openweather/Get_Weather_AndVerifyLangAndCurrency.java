package openweather;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class Get_Weather_AndVerifyLangAndCurrency extends openweatherBaseTest {

    @Test
    public void testLangAndCurrency(){

        Response res1 = openWeatherFunctionality.getWeatherByCity("New Delhi");

        System.out.println(res1.asPrettyString());
    }
}
