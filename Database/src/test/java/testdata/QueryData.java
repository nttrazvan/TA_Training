package testdata;

public class QueryData {

    public String insertNewUser (String name, String password, String isActive){
        return "INSERT INTO users (name, password, isActive) VALUES ('" + name + "','" + password + "','" + isActive + "');";
    }
}
