package openweather;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class Get_LanguageAndCurrency {

@Test
    public void test() {

    String resourcePath = "/rest/v2/name/{name}";
    RestAssured.baseURI="https://restcountries.eu";

    Response r = RestAssured
            .given()
            .pathParam("name", "India")
            .when()
            .get(resourcePath)
            .then()
            .extract().response();

    System.out.println(r.prettyPrint());
    List<Map<String,?>> countries = r.jsonPath().getList("$");
    for(Map<String,?> countryObject :countries){
      List<Map<String, String>> langObject= (List<Map<String, String>> ) countryObject.get("languages");
      for(Map<String, String> language : langObject){
        if(language.get("name").equals("English")){
            List<Map<String, String>> currencyObject = (List<Map<String, String>>)  countryObject.get("currencies");
            for(Map<String, String> currency : currencyObject)
            {
                System.err.println(currency.get("name"));
            }
        }
      }
    }
}
}
