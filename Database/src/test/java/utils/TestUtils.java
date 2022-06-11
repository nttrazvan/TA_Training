package utils;

import testdata.TestData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestUtils {
    TestData testData = new TestData();
    Connection connection;

    private Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(testData.DATABASE_DRIVER);
        return DriverManager.getConnection(testData.DATABASE_URL + testData.DATABASE_NAME,
                testData.DATABASE_USERNAME, testData.DATABASE_PASSWORD);
    }

    public void insertNewEntry(String query){
        try {
            connection = getConnection();

            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
