package tests;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testdata.QueryData;
import utils.TestUtils;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import static org.testng.Assert.*;
//TODO remove unused imports

public class ExerciseDBTest {

  private Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());
  TestUtils testUtils = new TestUtils();
  QueryData queryData = new QueryData();
  @BeforeTest (groups = {"createUser"})
  public void createUser() {
    String name = "lianaChis";
    String password = "safePassword";
    String isUserActive = "1";
    testUtils.insertNewEntry(queryData.insertNewUser(name, password, isUserActive));
  }

  @Test(groups = {"timeStampValidation"})
  public void timeStampFormatValidation() {
    String name = "testUser";
    List<HashMap<String, String>> result = testUtils
            .resultList(queryData.getCreationDate(name));
    for (HashMap<String, String> row : result) {
      String creationDate = row.get("createdOn");
      logger.info("The creation date is: " + creationDate);
      LocalDateTime ldt = null;
      //TODO remove null initializer because it is redundant
      //TODO name variable in a suggestive way
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
      try {
        ldt = LocalDateTime.parse(creationDate, formatter);
        String formatedDate = ldt.format(formatter);
        logger.info("Expected format: "+formatedDate);
        assertEquals(formatedDate, creationDate, "DB format does not match expected format");
      } catch (DateTimeParseException e) {
        e.printStackTrace();
        fail();
      }
    }
  }

  @Test(groups = {"updateUser"})
  public void updateUser() {
    //update the user email and validate that it was updated
      String email = "email@email.com";
      String name = "lianaChis";
      testUtils.updateEntry(queryData.updateEmailUser(email, name));
    List<HashMap<String, String>> result = testUtils
            .resultList(queryData.getUserByName(name));
    logger.info("The email " + result.get(0).get("email") + " should equal " + email);
    assertEquals(email,result.get(0).get("email"),"The email does not match " + email);
    }

  @Test(groups = {"deleteUser"})
  public void deleteUser() {
    //delete the created user and validate that it was deleted
    String expectedName = "lianaChis";
    testUtils.deleteEntry(queryData.deleteUser(expectedName));
    List<HashMap<String, String>> result = testUtils
            .resultList(queryData.getUserByName(expectedName));
    logger.info("The list size for " + expectedName +" is: " + result.size());
    assertTrue(result.size() == 0);
  }
}
