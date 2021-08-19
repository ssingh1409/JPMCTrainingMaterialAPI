package org.HttpBin.Basics;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

public class Get_HTTPBin_ExtractJson {

    public static void main(String[] args) {

        //optimizing code
        String resourcePath= "/rest/v2/name/{name}";
        RestAssured.baseURI="https://restcountries.eu";

    Response r= RestAssured
                .given()
                    .pathParam("name","India")
                .when()
                    .get(resourcePath)
                .then()
                     .log().all().
                extract().response();
    //because the response is array of string so we extract it as List
        //Array of jsons is a list of map
        //Reponse has List of Map so we add them in List of Map
    List<Map<String,?>> countryObjects= r.body().jsonPath().getList("$");

    //Map is a key value pair hence we wanted to extract list of map
    for(Map<String,?> country : countryObjects){
        if(country.get("name").equals("India")){
           String capitalcity = country.get("capital").toString();
           if(capitalcity.equalsIgnoreCase("New Delhi")){
               System.out.println("Test Passed");
           }
           else
           {
               System.out.println("Test Failed");
           }
        }
    }

        List<Map<String,?>> demo= r.body().jsonPath().getList("$");

    //Map is a key value pair hence we wanted to extract list of map
        for(Map<String,?> sample : demo){
            if(sample.get("languages").equals("Hindi")){



                Map<String,String> currencies = r.body().jsonPath().getMap("$");


//                if(capitalcity.equalsIgnoreCase("New Delhi")){
//                    System.out.println("Test Passed");
//                }
//                else
//                {
//                    System.out.println("Test Failed");
//                }
            }
        }




    }
}
