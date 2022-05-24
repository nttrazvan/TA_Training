package utils;

import io.restassured.response.Response;
import org.testng.Assert;

public class TestUtils {

  public void checkStatusIs200(Response response){
    Assert.assertEquals(response.getStatusCode(), 200, "Status code is not the expected one!");
  }
}
