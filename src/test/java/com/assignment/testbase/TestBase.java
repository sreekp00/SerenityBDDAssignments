package com.assignment.testbase;
import io.restassured.RestAssured;
import org.junit.BeforeClass;


public class TestBase {

    @BeforeClass
    public static void init()
    {
        //RestAssured.baseURI="http://restcountries.eu/rest";
        //RestAssured.baseURI="http://restapi.demoqa.com/customer/register";
        RestAssured.baseURI="https://api.github.com/authorizations";
    }
}
