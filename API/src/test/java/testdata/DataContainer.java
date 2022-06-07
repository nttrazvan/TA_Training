package testdata;

import utils.TestUtils;

import java.io.File;

public class DataContainer {
    public String baseURL = "https://petstore.swagger.io/v2";
    public String urlSuffixAddPet = "/pet";
    public String urlSuffixCreateUser = "/user";
    public String urlSuffixLogIn = "/login";
    public String updateUserJsonPath = "src/test/resources/updateUser.json";
    public String addPathJsonString = "responseAddPet.json";
    public File jsonUserData = new File("src/test/resources/user.json");
    public File jsonUpdateUser = new File("src/test/resources/updateUser.json");
    public File jsonAddPet = new File("src/test/resources/addPet.json");
}
