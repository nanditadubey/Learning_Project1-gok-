package com.gojek.utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

/**
 * Created by nandita.dubey on 09/05/20.
 */
public class RestUtils {


    public static Response getCall(String url, int statuscode)
    {
        Response response = null;
        try {

            response = given().contentType(ContentType.JSON)
                .when()
                .get(url)
                .then()
                .assertThat()
                .statusCode(statuscode)
                .extract().response();
    } catch (Exception e) {
        e.printStackTrace();
    }
        return response;
    }
}
