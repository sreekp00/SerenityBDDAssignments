package com.assignment.junit;

import com.assignment.testbase.TestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(SerenityRunner.class)
public class AssignmentFour extends TestBase {


    @Test
    public void autherizeUserSucess()
    {

        String username = "admin";
        String password = "password";

        //language=JSON
        String jsonBody = "{\n" +
                "  \"name\": \"Foo\"\n" +
                "}";

        SerenityRest.rest().given().auth().preemptive().basic(username, password)
                .body(jsonBody)
                .contentType(ContentType.JSON)
                .when()
                .post("http://localhost:8080/secured/hello")
                .then()
                .statusCode(200)
                .body("success", equalTo(true))
                .body("data", equalTo("hello Foo"));

    }

    @Test
    public void autherizeUserFail()
    {

        String username = "admin";
        String password = "password123";

        //language=JSON
        String jsonBody = "{\n" +
                "  \"name\": \"Foo\"\n" +
                "}";

        SerenityRest.rest().given().auth().preemptive().basic(username, password)
                .body(jsonBody)
                .contentType(ContentType.JSON)
                .when()
                .post("http://localhost:8080/secured/hello")
                .then()
                .statusCode(401)
                .body("success", equalTo(false));

    }

}
