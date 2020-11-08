package com.assignment.junit;

import com.assignment.serenity.AssignmentSteps;
import com.assignment.testbase.TestBase;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class AssignmentOne extends TestBase {

    @Steps
    AssignmentSteps steps;

    @Test
    public void validateValidCountryInfo()
    {
        Response response=steps.getCountryInfo("NORWAY");
        ResponseBody body= response.getBody();
        System.out.println("Response body is :"+body.asString());
        if (body.asString().contains("Republic of India"))
        {
            System.out.println("Response body is :"+body.asString());
        }
        else
        {
            System.out.println("Response does not contain 'Republic of India' string in it.");
        }

    }

    @Test
    public void validateInValidCountryInfo()
    {

        Response response=steps.getCountryInfo("XYZ");
        response.then().statusCode(404);
        ResponseBody body= response.getBody();

        if (body.asString().contains("Not Found"))
        {
            System.out.println("Response body is :"+body.asString());
        }
        else
        {
            System.out.println("Response does not contain 'Republic of India' string in it.");
        }

    }
}
