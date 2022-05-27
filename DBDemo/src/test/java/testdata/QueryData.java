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

  public String updateEmailUser(String email, String name) {
    return "UPDATE users SET email = '" + email  + "' WHERE name = '" + name + "';";
  }

  public String deleteUser(String name) {
    return "DELETE FROM users WHERE name = '" + name + "';";
  }

  public String getCreationDate(String name) {
    return "SELECT createdOn FROM users WHERE name = '" + name + "'";
  }
}
