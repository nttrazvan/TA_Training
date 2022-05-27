package testdata;

public class QueryData {

  /**
   * @param userName Enter the user name
   * @return Query as String
   */
  public String getUserByName(String userName) {
    return "SELECT * FROM users WHERE name = '" + userName + "'";
  }

  /**
   * @param name The name of the user
   * @param password User password
   * @param isActive is the user active
   * @return Query as String
   */
  public String insertNewUser(String name, String password, String isActive) {
    return "INSERT INTO users (name, password, isActive) VALUES ('" + name + "', '"
        + password + "', '" + isActive + "');";
  }

}
