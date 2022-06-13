import org.testng.annotations.Test;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


public class APITest {
    String baseURL = "https://petstore.swagger.io/v2";
    String urlSuffixAddPet = "/pet";
    String urlSuffixCreateUser="/user";

    @Test
    public void addNewPet(){
        Response response = given()
                .baseUri(baseURL)
                .contentType("application/json")
                .body("{\n" +
                        "  \"id\": 0,\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 0,\n" +
                        "    \"name\": \"string\"\n" +
                        "  },\n" +
                        "  \"name\": \"doggie\",\n" +
                        "\n" +
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
    public void createNewUser{

        Response response = given()
                .baseUri(baseURL)
                .contentType("application/json")
                .body(jsonUserData)
                .when()
                .post

    }
}
