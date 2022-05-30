package tests;

import com.github.fge.jsonschema.SchemaVersion;
import com.github.fge.jsonschema.cfg.ValidationConfiguration;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.TestUtils;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.github.fge.jsonschema.SchemaVersion.DRAFTV4;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.MatcherAssert.assertThat;


public class APITest {

  //TODO move constants in a separate class
  String baseURL = "https://petstore.swagger.io/v2";
  String urlSuffixAddPet = "/pet";
  String urlSuffixCreateUser = "/user";
  String urlSuffixLogIn = "/login";
  File jsonUserData = new File("src/test/resources/user.json");
  File jsonUpdateUser = new File("src/test/resources/updateUser.json");
  File jsonAddPet = new File("src/test/resources/addPet.json");
  TestUtils testUtils = new TestUtils();
  Response response;
  //TODO is this String used?
  String user = "test";

  @Test(priority = 2)
  public void addNewPet() {
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

  @Test(priority = 3)
  public void createNewUser() {
    response = given()
        .baseUri(baseURL)
        .contentType("application/json")
        .body(jsonUserData)
        .when()
        .post(urlSuffixCreateUser);

    testUtils.checkStatusIs200(response);
    System.out.println(response.asString());
  }

  @Test(priority = 1)
  public void userLogIn() {
    response = given()
        .auth()
        .basic("test", "test")
        .baseUri(baseURL)
        .contentType("application/json")
        .when()
        .get(urlSuffixCreateUser + urlSuffixLogIn);

    testUtils.checkStatusIs200(response);
    JsonPath jsonPath = new JsonPath(response.asString());
    String message = jsonPath.getString("message");
    Assert.assertTrue(message.contains("logged in user session:"),
        "Message does not contain the expected value: " + message);
  }

  @Test(priority = 4)
  public void updateUser() {
    //update the user that was created in the createNewUser() method in APITest.java
    response = given()
        .baseUri(baseURL)
        .contentType("application/json")
        .body(jsonUpdateUser)
        .when()
        .put(urlSuffixCreateUser + "/test");

    testUtils.checkStatusIs200(response);
    System.out.println(response.asString());
  }

  @Test(priority = 5)
  public void getUser() throws IOException {

    String usernamePath = new String(
        Files.readAllBytes(Paths.get("src/test/resources/updateUser.json")),
        StandardCharsets.UTF_8);
    JSONObject jsonObject = new JSONObject(usernamePath);
    String username = jsonObject.getString("username");
    System.out.println(username);

    response = given()
        .baseUri(baseURL)
        .when()
        .get(urlSuffixCreateUser + "/" + username);

    testUtils.checkStatusIs200(response);
    System.out.println(response.asString());
  }

  @Test(priority = 6)
  public void deleteUser() throws IOException {
    //delete the updated User
    String usernamePath = new String(
        Files.readAllBytes(Paths.get("src/test/resources/updateUser.json")),
        StandardCharsets.UTF_8);
    JSONObject jsonObject = new JSONObject(usernamePath);
    String username = jsonObject.getString("username");
    System.out.println(username);

    response = given()
        .baseUri(baseURL)
        .when()
        .delete(urlSuffixCreateUser + "/" + username);

    testUtils.checkStatusIs200(response);
  }

  @Test(priority = 7)
  public void getUserAfterDelete() throws IOException {

    String usernamePath = new String(
        Files.readAllBytes(Paths.get("src/test/resources/updateUser.json")),
        StandardCharsets.UTF_8);
    JSONObject jsonObject = new JSONObject(usernamePath);
    String username = jsonObject.getString("username");
    System.out.println(username);

    response = given()
        .baseUri(baseURL)
        .when()
        .get(urlSuffixCreateUser + "/" + username);

    //TODO wouldn't it be better to check that the message is "User not found"?
    testUtils.checkStatusIs404(response);
    System.out.println(response.asString());
  }

  @Test(priority = 8)
  public void petSchemaValidation() {
    //validated the json schema for adding a new pet

    JsonSchemaFactory jsonSchemaFactory = JsonSchemaFactory.newBuilder().setValidationConfiguration(
        ValidationConfiguration.newBuilder().setDefaultVersion(DRAFTV4).freeze()).freeze();

    response = given()
        .baseUri(baseURL)
        .contentType("application/json")
        .body(jsonAddPet)
        .post(urlSuffixAddPet)
        .then()
        .assertThat()
        //TODO the JsaonSchemaInClasspath can be extracted in a String
        .body(matchesJsonSchemaInClasspath("responseAddPet.json").using(jsonSchemaFactory))
        .extract()
        .response();
    System.out.println(response.asString());
  }
}
