package testdata;

import java.io.File;

public class TestData {
  public String BASE_URL = "https://petstore.swagger.io/v2";
  public String URL_SUFFIX_CREATE_USER = "/user";
  public String URL_SUFFIX_USER_LOG_IN = "/login";
  public String URL_SUFFIX_ADD_PET = "/pet";
  public File JSON_USER = new File("src/test/resources/user.json");
}
