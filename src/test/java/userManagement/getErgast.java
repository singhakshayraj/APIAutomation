package userManagement;
import core.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utils.ExtentReport;
import utils.FailRetry;

import static io.restassured.RestAssured.given;
import static junit.framework.Assert.assertEquals;
public class getErgast extends BaseTest {

    //@Test(description = "Validate the status code for GET users endpoint",groups="RegressionSuite")
    @Test(retryAnalyzer = FailRetry.class)
    public void validateResponseBodyGetPathParam() {
        ExtentReport.extentlog=
                ExtentReport
                        .extentreport
                        .startTest("validateResponseBodyGetPathParam","Validate Response Body from GET Param");


        String raceSeasonValue = "2017";
        Response resp = given().pathParam("raceSeason", raceSeasonValue)
                .when()
                .get("http://ergast.com/api/f1/{raceSeason}/circuits.json"); //RestAssured


        int actualStatusCode = resp.statusCode();  //RestAssured
        assertEquals(actualStatusCode, 201); //Testng
        System.out.println(resp.body().asString());

    }
}
