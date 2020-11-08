package com.assignment.junit;

import com.assignment.serenity.AssignmentSteps;
import com.assignment.testbase.TestBase;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

@RunWith(SerenityRunner.class)
public class AssignmentTwo extends TestBase {

    @Steps
    AssignmentSteps steps;

    @Test
    public void validateNorwayCountryInfo()
    {
        Response response=steps.getCountryInfo("NORWAY");
        ResponseBody body= response.getBody();
        String capital= body.jsonPath().getString("capital");
        assertTrue(capital.contains("Oslo"));
    }
}
