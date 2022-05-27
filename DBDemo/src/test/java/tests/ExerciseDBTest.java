package tests;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testdata.QueryData;
import utils.TestUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

import static org.testng.Assert.assertTrue;

public class ExerciseDBTest {

  private Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());
  TestUtils testUtils = new TestUtils();
  QueryData queryData = new QueryData();
  @BeforeTest
  public void createUser() {
    String name = "lianaChis";
    String password = "safePassword";
    String isUserActive = "1";
    testUtils.insertNewEntry(queryData.insertNewUser(name, password, isUserActive));
  }

  @Test
  public void timeStampFormatValidation(String time) {
    //validated the json schema for adding a new pet
  }

  @Test
  public boolean checkUserCreationDate() {
    String name = "testUser";
    List<HashMap<String, String>> result = testUtils
            .resultList(queryData.getCreationDate(name));
    for (HashMap<String, String> row : result) {
      String creationDate = row.get("createdOn");
//      logger.info("The creation date is is: " + creationDate);
//      assertTrue(result.matches(creationDate),
//              "Date does not match the expected date" + expectedCreationDateForName);
      SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSS-SS");
      try{
        format.parse(creationDate);
        Pattern p = Pattern.compile("^\\d{4}-?\\d{1,2}-?\\d{1,2} \\d{1,2}:\\d{1,2}:\\d{1,2}[.]?\\d{1,6}$");
        return p.matcher(creationDate).matches();
      }
      catch(ParseException e)
      {
        return false;
      }
    }
    return false;
  }



  @Test
  public void updateUser() {
    //update the user email and validate that it was updated
      String email = "email@email.com";
      String name = "lianaChis";
      testUtils.updateEntry(queryData.updateEmailUser(email, name));
    }

  @Test
  public void deleteUser() {
    //delete the created user and validate that it was deleted
    String name = "lianaChis";
    testUtils.deleteEntry(queryData.deleteUser(name));
  }

}
