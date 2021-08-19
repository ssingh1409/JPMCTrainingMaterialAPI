package testNG;

import openweather.openweatherBaseTest;
import org.testng.Assert;
import org.testng.annotations.*;

public class testNGPriorityExample extends openweatherBaseTest {

    @Test
    public void testOne(){
        System.out.println("Inside test One");
    }
    @Test
    public void testTwo() {
        System.out.println("Inside test Two");
        Assert.assertEquals("Sophia","Sheron");
    }

    @BeforeMethod
    public void eachMethod(){
        System.out.println("Before Each Method");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("After Each Method Executed");
    }
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before Suite Method");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("Here in After Suite");
    }
}
