package tests;

import static org.testng.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testdata.QueryData;
import utils.TestUtils;

public class DBTest {

  private Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());
  TestUtils testUtils = new TestUtils();
  QueryData queryData = new QueryData();

  @BeforeTest
  public void createNewUser() {
    String name = "testUser";
    String password = "strongPassword";
    String isUserActive = "1";
    testUtils.insertNewEntry(queryData.insertNewUser(name, password, isUserActive));
  }

  @Test
  public void checkUserWasCreated() {
    String expectedName = "testUser";
    List<HashMap<String, String>> result = testUtils
        .resultList(queryData.getUserByName(expectedName));
    for (HashMap<String, String> row : result) {
      String name = row.get("name");
      logger.info("The found name is: " + name);
      assertTrue(expectedName.contains(name),
          "Name does not match the expected name" + expectedName);
    }
  }
}
