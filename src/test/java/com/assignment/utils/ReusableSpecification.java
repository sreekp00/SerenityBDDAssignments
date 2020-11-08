package com.assignment.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.concurrent.TimeUnit;
import static org.hamcrest.Matchers.*;

public class ReusableSpecification {

    public static RequestSpecBuilder rspec;
    public static RequestSpecification requestSpecification;
    public static ResponseSpecBuilder respec;
    public static ResponseSpecification responseSpecification;
    public static RequestSpecification getGenericRequestSpec()
    {
        rspec=new RequestSpecBuilder();
        rspec.setContentType(ContentType.JSON);
        requestSpecification= rspec.build();
        return requestSpecification;
    }

    public static ResponseSpecification getGenericResponseSpec()
    {
        respec=new ResponseSpecBuilder();
        respec.expectResponseTime(lessThan(5l), TimeUnit.SECONDS);
        responseSpecification=respec.build();
        return responseSpecification;
    }


}
