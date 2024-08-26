package userManagement;

import core.BaseTest;
import core.StatusCode;
import io.restassured.RestAssured;
import io.restassured.http.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static junit.framework.Assert.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static utils.JsonReader.getJsonArray;

import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;
import utils.ExtentReport;
import utils.JsonReader;
import utils.PropertyReader;
import utils.SoftAssertionUtil;

import java.io.IOException;
import java.util.*;


public class getUsers extends BaseTest {

    SoftAssertionUtil softAssertion=new SoftAssertionUtil();
    @Test(groups = "SmokeSuite")
    public void getGetUserData(){
        given().
                when().
                get("https://reqres.in/api/users?page=2").
                then().assertThat().statusCode(200);

    }
//
//    @Test
//    public void validateGetResponseBody(){
//        RestAssured.baseURI="https://jsonplaceholder.typicode.com";
//
//        given().
//                when().
//                    get("/todos/1").
//                        then().
//                            assertThat().
//                                statusCode(200).
//                                    body(not(isEmptyString())).
//                                        body("title",equalTo("delectus aut autem")).
//                                            body("userId",equalTo(1));
//
//
//    }
//
//    @Test
//    public void validateResponseHasItems() {
//        // Set base URI for the API
//        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
//
//        // Send a GET request and store the response in a variable
//        Response response = given()
//                .when()
//                .get("/posts")
//                .then()
//                .extract()
//                .response();
//
//        // Use Hamcrest to check that the response body contains specific items
//        assertThat(response.jsonPath().getList("title"), hasItems("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"));
//    }
//
//    @Test
//    public void validateResponseHasSize() {
//        // Set base URI for the API
//        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
//
//        // Send a GET request and store the response in a variable
//        Response response = given()
//                .when()
//                .get("/comments")
//                .then()
//                .extract()
//                .response();
//
//        // Use Hamcrest to check that the response body has a specific size
//        assertThat(response.jsonPath().getList(""), hasSize(500));
//    }
//
//    @Test
//    public void validateListContainsInOrder() {
//        // Set base URI for the API
//        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
//
//        // Send a GET request and store the response in a variable
//        Response response = given()
//                .when()
//                .get("/comments?postId=1")
//                .then()
//                .extract()
//                .response();
//
//        // Use Hamcrest to check that the response body contains specific items in a specific order
//        List<String> expectedEmails = Arrays.asList("Eliseo@gardner.biz", "Jayne_Kuhic@sydney.com", "Nikita@garfield.biz","Lew@alysha.tv","Hayden@althea.biz");
//        assertThat(response.jsonPath().getList("email"), contains(expectedEmails.toArray(new String[0])));
//    }
//
//    @Test
//    public void testGetUsersWithQueryParameters() {
//        RestAssured.baseURI = "https://reqres.in/api";
//        Response response = given()
//                .queryParam("page", 2)
//                .when()
//                .get("/users")
//                .then()
//                .statusCode(200)
//                .extract()
//                .response();
//
//        // Assert that the response contains 6 users
//        response.then().body("data", hasSize(6));
//
//        // Assert that the first user in the list has the correct values
//        response.then().body("data[0].id", equalTo(7));
//        response.then().body("data[0].email", is("michael.lawson@reqres.in"));
//        response.then().body("data[0].first_name", is("Michael"));
//        response.then().body("data[0].last_name", is("Lawson"));
//        response.then().body("data[0].avatar", is("https://reqres.in/img/faces/7-image.jpg"));
//    }
//
//    @Test(description = "Validate the status code for GET users endpoint")
//    public void validateStatusCodeGetUser() throws IOException, ParseException {
//
//
//      //  System.out.println("*****************" + Helper.propertyReader("qaBaseUrl"));
//
//
//
//
//        //System.out.println("URI is ******:" + uri);
//
//
//        Response resp = given()
//                .queryParam("page", 2)
//                .when()
//                .get("https://reqres.in/api/users?page=2"); //RestAssured
//
//
//        int actualStatusCode = resp.statusCode();  //RestAssured
//        assertEquals(actualStatusCode, 200); //Testng
//    }
//
//    @Test
//    public void testGetUsersWithMultipleQueryParams() {
//        Response response =
//                given()
//                        .queryParam("page", 2)
//                        .queryParam("per_page", 3)
//                        .queryParam("rtqsdr", 4)
//                        .when()
//                        .get("https://reqres.in/api/users")
//                        .then()
//                        .statusCode(200)
//                        .extract()
//                        .response();
//        int actualStatusCode = response.statusCode();  //RestAssured
//        assertEquals(actualStatusCode, 200); //Testng
//
//    }
//

//    @BeforeClass
//    public void setup() {
//        // Set base URI for the API
//        RestAssured.baseURI = "https://reqres.in/api";
//    }
//    @Test
//    public void testCreateUserWithFormParam() {
//        Response response = given()
//                .contentType(ContentType.URLENC)
//               // .contentType("application/x-www-form-urlencoded")
//                .formParam("name", "John Doe222")

    @Test
    public void testName() {
    }
//                .formParam("job", "Developer")
//                .when()
//                .post("/users")
//                .then()
//                .statusCode(201)
//                .extract()
//                .response();
//
//        // Assert that the response contains the correct name and job values
//       // response.then().body("name", equalTo("John Doe"));
//       // response.then().body("job", equalTo("Developer"));
//    }
//
//    @Test
//    public void testGetUserListWithHeader(){
//        given()
//                .header("Content-Type","application/json")
//                .when()
//                .get("https://reqres.in/api/users?page=2")
//                .then()
//                .statusCode(200);
//
//        System.out.println("success");
//    }
//
//    @Test
//    public void testWithTwoHeaders(){
//        given()
//                .header("Authorization","Bearer sdfsdfdsfsafd")
//                .header("Content-Type","application/json")
//                .when()
//                .get("https://reqres.in/api/users?page=2")
//                .then()
//                .statusCode(200);
//
//        System.out.println("success");
//    }
//
//    @Test
//    public void testTwoHeadersWithMap(){
//
//        Map<String,String> headers=new HashMap<>();
//        headers.put("Authorization","Bearer asdfadsfads");
//        headers.put("Content-Type","application/json");
//
//        given()
//                .headers(headers)
//                .when()
//                .get("https://reqres.in/api/users?page=2")
//                .then()
//                .statusCode(200);
//
//        System.out.println("success");
//    }
//
//    @Test
//    public void testFetchHeader(){
//        Response response=given().when()
//                .get("https://reqres.in/api/users?page=2")
//                .then()
//                .extract().response();
//
//        Headers headers=response.getHeaders();
//        for(Header h:headers){
//            if(h.getName().equals("Server")){
//                System.out.println(h.getName()+": "+h.getValue());
//                assertEquals(h.getValue(),"cloudflare");
//            }
//
//        }
//    }
//
//    @Test
//    public void testUserCookies(){
//        Cookie cookie=new Cookie.Builder("cookieKey1","cookiesValue1").build();
//
//        given()
//                .cookie(cookie)
//                .when()
//                .get("https://reqres.in/api/users?page=2")
//                .then()
//                .statusCode(200);
//
//    }
//
//    @Test
//    public void testFetchCookies(){
//        Response response=given()
//                .when()
//                .get("https://reqre.in/api/users/page=2")
//                .then()
//                .extract().response();
//
//        Map<String,String> cookies=response.getCookies();
//        Cookies cookies1=response.getDetailedCookies();
//        cookies1.getValue("server");
//        assertThat(cookies,hasKey("JSESSIONID"));
//        assertThat(cookies,hasValue("ABCDSDASD"));
//    }

//    @Test
//    public void validateResponseBodyGetBasicAuth(){
//
//        Response response=given()
//                .auth()
//                .basic("postman","password")
//                .when()
//                .get("https://postman-echo.com/basic-auth");
//
//        int actualStatusCode=response.getStatusCode();
//        assertEquals(actualStatusCode,StatusCode.SUCCESS.code);
//        System.out.println(response.body().asString());
//    }
//
//    @Test
//    public void validateResponseBodyGetDigestAuth(){
//
//        Response response=given()
//                .auth()
//                .digest("postman","password")
//                .when()
//                .get("https://postman-echo.com/digest-auth");
//
//        int actualStatusCode=response.getStatusCode();
//        assertEquals(actualStatusCode,StatusCode.SUCCESS.code);
//        System.out.println(response.body().asString());
//    }
//
    @Test(groups={"SmokeSuite","RegressionSuite"})
    public void validateStatusCodeDelete(){
        ExtentReport.extentlog=
                ExtentReport
                        .extentreport
                        .startTest("validateStatusCodeDelete","Validate 204 status code for DELETE method");
        Response resp=given()
                .delete("https://reqres.in/api/users/2");
        assertEquals(resp.getStatusCode(), StatusCode.NO_CONTENT.code);
        System.out.println("VerifyStatusCodeDelete executed sucessfully");
    }
//
//    @Test
//    public void validateWithTestDataFromJson() throws IOException, ParseException {
//
//        Response response=given()
//                .auth()
//                .basic(JsonReader.getTestData("username"),JsonReader.getTestData("password"))
//                .when()
//                .get("https://postman-echo.com/basic-auth");
//
//        int actualStatusCode=response.getStatusCode();
//        assertEquals(actualStatusCode,StatusCode.SUCCESS.code);
//        System.out.println(response.body().asString());
//
//    }
//
    @Test(description = "Validate the status code for GET users endpoint",groups = "RegressionSuite ")
    public void validateWithDataFromPropertiesFile() throws IOException, ParseException {
        ExtentReport.extentlog=
                ExtentReport
                        .extentreport
                        .startTest("validateWithDataFromPropertiesFile","Validate Data From Properties File");

        String serverAddress= PropertyReader.propertyReader("config.properties","server");
        System.out.println("serverAddress is "+serverAddress);
        Response resp = given()
                .queryParam("page", 2)
                .when()
                .get(serverAddress); //RestAssured


        int actualStatusCode = resp.statusCode();  //RestAssured
        assertEquals(actualStatusCode, 200); //Testng
    }
//
//    @Test(description = "Validate the status code for GET users endpoint")
//    public void validateFromProperties_TestData() throws IOException, ParseException {
//        String serverAddress= PropertyReader.propertyReader("config.properties","server");
//        String endpoint=JsonReader.getTestData("endpoint");
//        System.out.println("endpoint is="+endpoint);
//        String baseURL=serverAddress+endpoint;
//        System.out.println("serverAddress is "+baseURL);
//        Response resp = given()
//                .queryParam("page", 2)
//                .when()
//                .get(baseURL); //RestAssured
//
//
//        int actualStatusCode = resp.statusCode();  //RestAssured
//        assertEquals(actualStatusCode, 200); //Testng
//    }
//
//    @Test
//    public void softAssertion(){
//        SoftAssert softAssertion=new SoftAssert();
//        System.out.println("softAssert");
//        softAssertion.assertTrue(false);
//        softAssertion.assertTrue(true);
//      //  softAssertion.assertAll();
//
//    }
//
//    @Test
//    public void softAssertionUtl(){
//        SoftAssertionUtil softAssertion=new SoftAssertionUtil();
//        System.out.println("softAssert");
//        softAssertion.assertTrue(true,"message");
//
//    }

//    @Test
//    public void validateWithSoftAssertUtil() {
//        RestAssured.baseURI = "https://reqres.in/api";
//        Response response = given()
//                .queryParam("page", 2)
//                .when()
//                .get("/users")
//                .then()
//                .statusCode(200)
//                .extract()
//                .response();
//
//        // Assert that the response contains 6 users
//        response.then().body("data", hasSize(6));
//
//        softAssertion.assertEquals(response.getStatusCode(),StatusCode.NO_CONTENT.code,"Status Code is not 200");
//        softAssertion.assertAll();
//
//        System.out.println("ValidateWithSoftAssertUtil executed successfully");
//    }

    @DataProvider(name="testdata")
    public Object[][] testData(){
        return new Object[][]{
                {"1","John"},
                {"2","Jane"},
                {"3","Bob"}
        };
    }

    @Test(dataProvider = "testdata")
    @Parameters({"id","name"})
    public void testEndPoint(String id , String name){
        given()
                .queryParam("id",id)
                .queryParam("name",name)
                .when()
                .get("https://reqres.in/api/users")
                .then()
                .statusCode(200);
    }

    @Test
    public void Test() throws IOException,ParseException{
        JsonReader.getJsonArrayData("languages",1);
    }

    @Test
    public void Test1() throws IOException,ParseException{
        JsonReader.getJsonArrayData("contact",2);
        JSONArray jsonArray=getJsonArray("contact");
        Iterator<String> iterator=jsonArray.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
