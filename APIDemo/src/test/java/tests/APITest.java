package tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import java.io.File;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.TestUtils;

import static io.restassured.RestAssured.given;


public class APITest {
    String baseURL = "https://petstore.swagger.io/v2";
    String urlSuffixCreateUser = "/user";
    String urlSuffixUserLogIn = "/login";
    String urlSuffixAddPet = "/pet";
    File jsonData = new File("src/test/resources/user.json");
    TestUtils testUtils = new TestUtils();

    @Test
    public void addNewPet(){
        Response response = given()
            .baseUri(baseURL)
            .contentType("application/json")
            .body("{"
                + "  \"id\": 0,"
                + "  \"category\": {"
                + "    \"id\": 0,"
                + "    \"name\": \"chicken\""
                + "  },"
                + "  \"name\": \"Sam\","
                + "  \"status\": \"available\""
                + "}")
            .when()
            .post(urlSuffixAddPet)
            .then()
            .statusCode(200)
            .extract()
            .response();

        System.out.println(response.asString());
    }

    @Test
    public void createNewUser(){
        Response response = given()
            .baseUri(baseURL)
            .contentType("application/json")
            .body(jsonData)
            .when()
            .post(urlSuffixCreateUser);

        testUtils.checkStatusIs200(response);
    }

    @Test
    public void userLogIn(){
        Response response = given()
            .auth()
            .basic("test","test")
            .baseUri(baseURL)
            .contentType("application/json")
            .get(urlSuffixCreateUser+urlSuffixUserLogIn);

        testUtils.checkStatusIs200(response);
        JsonPath jsonPath = new JsonPath(response.asString());
        String message = jsonPath.getString("message");
        Assert.assertTrue(message.contains("logged in user session:"), "Message doesn't contain the expected value: " + message );
    }
}
