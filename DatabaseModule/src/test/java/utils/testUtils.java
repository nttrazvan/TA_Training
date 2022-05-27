package utils;

import testData.TestData;

import java.sql.Connection;

public class testUtils {

    TestData testData = new TestData();

    private Connection getConnection() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver").newInstance()
    }

}
