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
    }

  @Test(groups = {"updateUser"})
  public void validateUserUpdate() {
    //update the user email and validate that it was updated
    String name = "lianaChis";
    String expectedEmail = "email@email.com";
    List<HashMap<String, String>> result = testUtils
            .resultList(queryData.getUpdatedUser(name));
    for (HashMap<String, String> row : result) {
      String email = row.get("email");
      logger.info("The email of the user is: " + email);
      assertEquals(email, expectedEmail, "Email does not match the expected email" + expectedEmail);
    }
  }

  @AfterTest(groups = {"deleteUser"})
  public void deleteUser() {
    //delete the created user and validate that it was deleted
    String name = "lianaChis";
    testUtils.deleteEntry(queryData.deleteUser(name));
  }

  @AfterTest(groups = {"deleteUser"})
  public void validateUserDeletion() {
    //update the user email and validate that it was updated
    String name = "lianaChis";
    testUtils.deleteEntry(queryData.deleteUser(name));
  }
}
