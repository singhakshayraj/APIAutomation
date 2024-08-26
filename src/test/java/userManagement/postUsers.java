package userManagement;

import io.restassured.response.Response;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;
import core.StatusCode;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class postUsers {
    private static FileInputStream fileInputStreamMethod(String requestBodyFileName) throws IOException{
        FileInputStream fileInputStream= new FileInputStream((new File(System.getProperty("user.dir")+"/resources/TestData/"+requestBodyFileName)));

        return fileInputStream;
    }
    
    @Test
    public void validatePostWithString(){

        Response response=given()
                .header("Content-type","application/json")
                .body("{\"name\":\"morpheus\",\"job\":\"leader\"}")
                .when()
                .post("https://reqres.in/api/users");

        assertEquals(response.getStatusCode(),StatusCode.CREATED.code);
        System.out.println("validatePostWithString executed succesfully");
        System.out.println(response.getBody().asString());


    }

    @Test
    public void validatePutWithString(){

        Response response=given()
                .header("Content-type","application/json")
                .body("{\"name\":\"akshay\",\"job\":\"LEAD SDET\"}")
                .when()
                .put("https://reqres.in/api/users/2");

        assertEquals(response.getStatusCode(),StatusCode.SUCCESS.code);
        System.out.println("validatePutWithString executed succesfully");
        System.out.println(response.getBody().asString());


    }

    @Test
    public void validatePatchWithString(){

        Response response=given()
                .header("Content-type","application/json")
                .body("{\"name\":\"akshay1\"}")
                .when()
                .patch("https://reqres.in/api/users/2");

        assertEquals(response.getStatusCode(),StatusCode.SUCCESS.code);
        System.out.println("validatePutWithString executed succesfully");
        System.out.println(response.getBody().asString());


    }

    @Test
    public void validatePostWithJsonFile() throws IOException {

        Response response=given()
                .header("Content-type","application/json")
                .body(IOUtils.toString(fileInputStreamMethod("postRequestBody.json")))
                .when()
                .post("https://reqres.in/api/users");

        assertEquals(response.getStatusCode(),StatusCode.CREATED.code);
        System.out.println("validatePostWithJsonFile executed succesfully");
        System.out.println(response.getBody().asString());


    }

    @Test
    public void validatePatchWithJsonFile() throws IOException {

        Response response=given()
                .header("Content-type","application/json")
                .body(IOUtils.toString(fileInputStreamMethod("patchRequestBody.json")))
                .when()
                .patch("https://reqres.in/api/users/2");
        System.out.println(response.getStatusCode());
        assertEquals(response.getStatusCode(),StatusCode.SUCCESS.code);
        System.out.println("validatePatchWithJsonFile executed succesfully");
        System.out.println(response.getBody().asString());
    }

    @Test
    public void validatePutWithJsonFile() throws IOException {

        Response response=given()
                .header("Content-type","application/json")
                .body(IOUtils.toString(fileInputStreamMethod("putRequestBody.json")))
                .when()
                .put("https://reqres.in/api/users/2");
        System.out.println(response.getStatusCode());
        assertEquals(response.getStatusCode(),StatusCode.SUCCESS.code);
        System.out.println("validatePutWithJsonFile executed succesfully");
        System.out.println(response.getBody().asString());
    }
}
