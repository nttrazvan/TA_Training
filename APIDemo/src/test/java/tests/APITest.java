package tests;

import static io.restassured.RestAssured.given;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import testdata.TestData;
import utils.TestUtils;

public class APITest {

  TestData testData = new TestData();
  TestUtils testUtils = new TestUtils();

  @Test
  public void addNewPet() {
    Response response = given()
        .baseUri(testData.BASE_URL)
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
        .post(testData.URL_SUFFIX_ADD_PET)
        .then()
        .statusCode(200)
        .extract()
        .response();

    System.out.println(response.asString());
  }

  @Test
  public void createNewUser() {
    Response response = given()
        .baseUri(testData.BASE_URL)
        .contentType("application/json")
        .body(testData.JSON_USER)
        .when()
        .post(testData.URL_SUFFIX_CREATE_USER);

    testUtils.checkStatusIs200(response);
  }

  @Test
  public void userLogIn() {
    Response response = given()
        .auth()
        .basic("test", "test")
        .baseUri(testData.BASE_URL)
        .contentType("application/json")
        .get(testData.URL_SUFFIX_CREATE_USER + testData.URL_SUFFIX_USER_LOG_IN);

    testUtils.checkStatusIs200(response);
    JsonPath jsonPath = new JsonPath(response.asString());
    String message = jsonPath.getString("message");
    Assert.assertTrue(message.contains("logged in user session:"),
        "Message doesn't contain the expected value: " + message);
  }
}
