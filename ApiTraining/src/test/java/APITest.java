import com.fasterxml.jackson.databind.util.JSONPObject;
import com.github.fge.jsonschema.cfg.ValidationConfiguration;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.TestUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.github.fge.jsonschema.SchemaVersion.DRAFTV4;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class APITest {

    String baseUrl = "https://petstore.swagger.io/v2";
    String urlSuffixAddPet = "/pet";
    String urlSuffixCreateUser = "/user";
    String urlSuffixLogIn = "/login";
    File jsonUserData = new File("src/test/resources/user.json");
    File jsonUserTwoData = new File("src/test/resources/updateUser.json");
    File jsonPetData = new File("src/test/resources/pet.json");
    TestUtils testUtils = new TestUtils();
    Response response;

    @Test
    public void addNewPet() {
         response = given()
                .baseUri(baseUrl)
                .contentType("application/json")
                .body("{" +
                        "  \"id\": 0," +
                        "  \"category\": {" +
                        "    \"id\": 0," +
                        "    \"name\": \"farm\"" +
                        "  },\n" +
                        "  \"name\": \"Sam\"," +
                        "  \"status\": \"available\"" +
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
                .baseUri(baseUrl)
                .contentType("application/json")
                .body(jsonUserData)
                .when()
                .post(urlSuffixCreateUser);

        testUtils.checkStatusIs200(response);
    }

    @Test
    public void userLogIn(){
        response = given()
                .auth()
                .basic("test","test")
                .baseUri(baseUrl)
                .contentType("application/json")
                .get(urlSuffixCreateUser + urlSuffixLogIn);

        testUtils.checkStatusIs200(response);
        JsonPath jsonPath = new JsonPath(response.asString());
        String message = jsonPath.getString("message");
        Assert.assertTrue(message.contains("logged in user session:"), "Message doesn't contain the expected value" + message);

    }

    @Test
    public void petSchemaValidation(){
        // Given
        JsonSchemaFactory jsonSchemaFactory = JsonSchemaFactory.newBuilder().setValidationConfiguration(ValidationConfiguration.newBuilder().setDefaultVersion(DRAFTV4).freeze()).freeze();

        response = given()
                .baseUri(baseUrl)
                .contentType("application/json")
                .body(jsonPetData)
                .post(urlSuffixAddPet)
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("responseAddedPet.json").using(jsonSchemaFactory))
                .extract().response();

        System.out.println(response.asString());
    }

    @Test
    public void updateUser(){

        response = given()
                .baseUri(baseUrl)
                .contentType("application/json")
                .body(jsonUserTwoData)
                .when()
                .put(urlSuffixCreateUser + "/test");

        testUtils.checkStatusIs200(response);
        System.out.println(response.asString());
    }

    /*
    @Test
    public void deleteUser(){
        response = given()
                .baseUri(baseUrl)
                .when()
                .delete(urlSuffixCreateUser + "/username");

        testUtils.checkStatusIs200(response);
    }

     */
}
