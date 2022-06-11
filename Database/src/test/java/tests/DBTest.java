package tests;

import org.testng.annotations.Test;
import testdata.QueryData;
import utils.TestUtils;

public class DBTest {

    TestUtils testUtils = new TestUtils();
    QueryData queryData = new QueryData();

    @Test
    public void createNewUser(){
        String name = "testUser";
        String password = "password";
        String isUserActive = "1";

        testUtils.insertNewEntry(queryData.insertNewUser(name,password,isUserActive));
    }
}
