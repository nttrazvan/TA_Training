package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import testdata.TestData;

public class TestUtils {
  private Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());
  TestData testData = new TestData();
  Connection connection;

  private Connection getConnection() throws ClassNotFoundException, SQLException {
    Class.forName(testData.DATABASE_DRIVER);
    return DriverManager.getConnection(
        testData.DATABASE_URL + testData.DATABASE_NAME, testData.DATABASE_USERNAME,
        testData.DATABASE_PASSWORD);
  }
  public  void insertNewEntry(String query){
      logger.info("Execute query: " + query);
      try {
        connection = getConnection();

        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
      }catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();
      }
    try {
      connection.close();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

  public List<HashMap<String, String>> resultList(String query) {
    List<HashMap<String, String>> list = new ArrayList<>();
    logger.info("Execute query: " + query);
    try {
      connection = getConnection();

      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery(query);
      ResultSetMetaData metaData = resultSet.getMetaData();
      int columns = metaData.getColumnCount();
      while (resultSet.next()) {
        HashMap<String, String> row = new HashMap<>(columns);
        for (int i = 1; i <= columns; ++i) {
          row.put(metaData.getColumnName(i), resultSet.getString(i));
        }
        list.add(row);
      }
    } catch (SQLException | ClassNotFoundException e) {
      e.printStackTrace();
    }
    try {
      connection.close();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return list;
  }
}
