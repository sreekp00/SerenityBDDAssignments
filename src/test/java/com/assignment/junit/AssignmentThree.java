package com.assignment.junit;

import com.assignment.model.UserClass;
import com.assignment.serenity.AssignmentSteps;
import com.assignment.testbase.TestBase;
import com.assignment.utils.TestUtils;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(SerenityRunner.class)
public class AssignmentThree extends TestBase {


    static String userName= TestUtils.getRandomString();
    static String password=userName;
    static String firstName="SMOKEUSER"+TestUtils.getRandomString();
    static String lastName="SMOKEUSER"+TestUtils.getRandomString();
    static String email=userName+"xyz@gmail.com";

    @Steps
    AssignmentSteps steps;

    @Test
    public void createUser()
    {
        ValidatableResponse response=steps.createStudent(firstName,lastName,userName,password,email);
        String body= response.toString();
        response.statusCode(201);
        assertTrue(body.contains("Operation completed successfully"));
    }

    @Test
    public void createDuplicateUserError()
    {
        ValidatableResponse response=steps.createStudent(firstName,lastName,userName,password,email);
        String body= response.toString();
        response.statusCode(200);
        assertTrue(body.contains("FAULT_USER_ALREADY_EXISTS"));
    }

}
