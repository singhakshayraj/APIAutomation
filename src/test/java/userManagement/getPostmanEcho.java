package userManagement;

import core.StatusCode;
import io.restassured.response.Response;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import utils.JsonReader;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static junit.framework.Assert.assertEquals;

public class getPostmanEcho {

    @Test
    public void validateResponseBodyGetBasicAuth(){

        Response response=given()
                .auth()
                .basic("postman","password")
                .when()
                .get("https://postman-echo.com/basic-auth");

        int actualStatusCode=response.getStatusCode();
        assertEquals(actualStatusCode, StatusCode.SUCCESS.code);
        System.out.println(response.body().asString());
    }
    @Test
    public void validateResponseBodyGetDigestAuth(){

        Response response=given()
                .auth()
                .digest("postman","password")
                .when()
                .get("https://postman-echo.com/digest-auth");

        int actualStatusCode=response.getStatusCode();
        assertEquals(actualStatusCode,StatusCode.SUCCESS.code);
        System.out.println(response.body().asString());
    }

    @Test(groups="SmokeSuite")
    public void validateWithTestDataFromJson() throws IOException, ParseException {

        Response response=given()
                .auth()
                .basic(JsonReader.getTestData("username"),JsonReader.getTestData("password"))
                .when()
                .get("https://postman-echo.com/basic-auth");

        int actualStatusCode=response.getStatusCode();
        assertEquals(actualStatusCode,StatusCode.SUCCESS.code);
        System.out.println(response.body().asString());

    }

}
