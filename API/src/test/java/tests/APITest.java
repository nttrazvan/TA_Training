package tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.TestUtils;

import java.io.File;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class APITest {
    String baseURL = "https://petstore.swagger.io/v2";
    String urlSuffixAddPet = "/pet";
    String urlSuffixCreateUser = "/user";
    String urlSuffixLogIn = "/login";
    String urlSuffixUpdateUser = "/user/test";
    File jsonUserData = new File("src/test/resources/user.json");
    File jsonUpdateUser = new File("src/test/resources/updateUser.json");
    TestUtils testUtils = new TestUtils();
    Response response;
    String user = "test";

    @Test
    public void addNewPet(){
        response = given()
                .baseUri(baseURL)
                .contentType("application/json")
                .body("{\n" +
                "  \"id\": 0,\n" +
                "  \"category\": {\n" +
                "    \"id\": 0,\n" +
                "    \"name\": \"farm\"\n" +
                "  },\n" +
                "  \"name\": \"Sam\",\n" +
                "  \"status\": \"available\"\n" +
                "}")
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
        response = given()
                .baseUri(baseURL)
                .contentType("application/json")
                .body(jsonUserData)
                .when()
                .post(urlSuffixCreateUser);

        testUtils.checkStatusIs200(response);
        System.out.println(response.asString());
    }

    @Test
    public void userLogIn(){
        response = given()
                .auth()
                .basic("test","test")
                .baseUri(baseURL)
                .contentType("application/json")
                .when()
                .get(urlSuffixCreateUser + urlSuffixLogIn);

        testUtils.checkStatusIs200(response);
        JsonPath jsonPath = new JsonPath(response.asString());
        String message = jsonPath.getString("message");
        Assert.assertTrue(message.contains("logged in user session:"),"Message does not contain the expected value: " + message);
    }

    @Test
    public void updateUser() {
        //update the user that was created in the createNewUser() method in APITest.java
        response = given()
                .baseUri(baseURL)
                .contentType("application/json")
                .body(jsonUpdateUser)
                .when()
                .put(urlSuffixUpdateUser);

        testUtils.checkStatusIs200(response);
        System.out.println(response.asString());
    }

    @Test
    public void getUser() {
        //update the user that was created in the createNewUser() method in APITest.java
        response = given()
                .baseUri(baseURL)
                .contentType("application/json")
                .body(jsonUpdateUser)
                .when()
                .get(urlSuffixUpdateUser);

        testUtils.checkStatusIs200(response);
        System.out.println(response.asString());
    }
}
