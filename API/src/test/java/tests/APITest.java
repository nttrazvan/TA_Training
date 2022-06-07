package tests;
import com.github.fge.jsonschema.cfg.ValidationConfiguration;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import testdata.DataContainer;
import utils.TestUtils;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import static com.github.fge.jsonschema.SchemaVersion.DRAFTV4;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;


public class APITest {
    TestUtils testUtils = new TestUtils();
    DataContainer dataContainer = new DataContainer();
    private Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());
    Response response;

    @Test(priority = 2)
    public void addNewPet() {
        response = given()
                .baseUri(dataContainer.baseURL)
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
                .post(dataContainer.urlSuffixAddPet)
                .then()
                .statusCode(200)
                .extract()
                .response();
        System.out.println(response.asString());
    }

    @Test(priority = 3)
    public void createNewUser() {
        response = given()
                .baseUri(dataContainer.baseURL)
                .contentType("application/json")
                .body(dataContainer.jsonUserData)
                .when()
                .post(dataContainer.urlSuffixCreateUser);

        testUtils.checkStatusIs200(response);
        System.out.println(response.asString());
    }

    @Test(priority = 1)
    public void userLogIn() {
        response = given()
                .auth()
                .basic("test", "test")
                .baseUri(dataContainer.baseURL)
                .contentType("application/json")
                .when()
                .get(dataContainer.urlSuffixCreateUser + dataContainer.urlSuffixLogIn);

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
                .baseUri(dataContainer.baseURL)
                .contentType("application/json")
                .body(dataContainer.jsonUpdateUser)
                .when()
                .put(dataContainer.urlSuffixCreateUser + "/test");

        testUtils.checkStatusIs200(response);
        System.out.println(response.asString());
    }

    @Test(priority = 5)
    public void getUser() throws IOException {

        String usernamePath = new String(
                Files.readAllBytes(Paths.get(dataContainer.updateUserJsonPath)),
                StandardCharsets.UTF_8);
        JSONObject jsonObject = new JSONObject(usernamePath);
        String username = jsonObject.getString("username");
        System.out.println(username);

        response = given()
                .baseUri(dataContainer.baseURL)
                .when()
                .get(dataContainer.urlSuffixCreateUser + "/" + username);

        testUtils.checkStatusIs200(response);
        System.out.println(response.asString());
    }

    @Test(priority = 6)
    public void deleteUser() throws IOException {
        //delete the updated User
        String usernamePath = new String(
                Files.readAllBytes(Paths.get(dataContainer.updateUserJsonPath)),
                StandardCharsets.UTF_8);
        JSONObject jsonObject = new JSONObject(usernamePath);
        String username = jsonObject.getString("username");
        System.out.println(username);

        response = given()
                .baseUri(dataContainer.baseURL)
                .when()
                .delete(dataContainer.urlSuffixCreateUser + "/" + username);

        testUtils.checkStatusIs200(response);
    }

    @Test(priority = 7)
    public void getUserAfterDelete() throws IOException {
        String usernamePath = new String(
                Files.readAllBytes(Paths.get(dataContainer.updateUserJsonPath)),
                StandardCharsets.UTF_8);
        JSONObject jsonObject = new JSONObject(usernamePath);
        String username = jsonObject.getString("username");
        System.out.println(username);

        response = given()
                .baseUri(dataContainer.baseURL)
                .when()
                .get(dataContainer.urlSuffixCreateUser + "/" + username);

        testUtils.checkStatusIs404(response);
        JsonPath jsonPath = new JsonPath(response.asString());
        String message = jsonPath.getString("message");
        logger.info("The message is " + message);
        Assert.assertEquals(message, "User not found", "Message does not contain the expected value: " + message);
    }

    @Test(priority = 8)
    public void petSchemaValidation() {
        //validated the json schema for adding a new pet
        JsonSchemaFactory jsonSchemaFactory = JsonSchemaFactory.newBuilder().setValidationConfiguration(
                ValidationConfiguration.newBuilder().setDefaultVersion(DRAFTV4).freeze()).freeze();

        response = given()
                .baseUri(dataContainer.baseURL)
                .contentType("application/json")
                .body(dataContainer.jsonAddPet)
                .post(dataContainer.urlSuffixAddPet)
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath(dataContainer.addPathJsonString).using(jsonSchemaFactory))
                .extract()
                .response();
        System.out.println(response.asString());
    }
}
