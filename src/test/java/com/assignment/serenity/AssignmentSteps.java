package com.assignment.serenity;

import com.assignment.model.UserClass;
import com.assignment.utils.ReusableSpecification;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class AssignmentSteps
{

    @Step ("Getting the country information with country name={0}")
    public Response getCountryInfo(String country)
    {
       return SerenityRest.rest()
                .given()
                .when()
                .get("/v1/name/"+country);

    }



    @Step("Register user with first name={0},Last Name={1},UserName={2},Password ={3},Email ={4}")
    public ValidatableResponse createStudent(String firstName, String lastName, String userName, String password, String email)
    {
        UserClass user=new UserClass();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUserName(userName);
        user.setPassword(password);
        user.setEmail(email);
        return SerenityRest.rest().given()
                .spec(ReusableSpecification.getGenericRequestSpec())
                .log()
                .all()
                .when()
                .body(user)
                .post()
                .then();
    }
}
