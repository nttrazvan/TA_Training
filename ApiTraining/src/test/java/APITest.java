import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.TestUtils;

import java.io.File;

import static io.restassured.RestAssured.given;

public class APITest {

    String baseUrl = "https://petstore.swagger.io/v2";
    String urlSuffixAddPet = "/pet";
    String urlSuffixCreateUser = "/user";
    String urlSuffixLogIn = "/login";
    File jsonUserData = new File("src/test/resources/user.json");
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
}
