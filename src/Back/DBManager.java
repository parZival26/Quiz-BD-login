package Back;

import java.sql.*;
import java.util.*;

public class DBManager {

    public static ArrayList<User> getUsers()
            throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        String url = "jdbc:mysql://127.0.0.1:3306/Quiz?user=root&password=$JUANjose2006";
        Driver d = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        Connection conn = DriverManager.getConnection(url);

        String sqlQuery = "SELECT * FROM User";

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sqlQuery);

        ArrayList<User> users = new ArrayList<User>();

        while (rs.next()) {
            int id = rs.getInt("id");
            String username = rs.getString("username");
            String password = rs.getString("password");

            User user = new User(id, username, password);
            users.add(user);
        }

        conn.close();

        return users;
    }

    public static void insertLog(User user)
            throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {

        String url = "jdbc:mysql://127.0.0.1:3306/Quiz?user=root&password=$JUANjose2006";
        Driver d = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        Connection conn = DriverManager.getConnection(url);

        String sqlQuery = "INSERT INTO Logs (idUser) VALUES (" + user.getId() + ")";
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sqlQuery);

        conn.close();

    }

    public static void main(String[] args) {
        try {
            ArrayList<User> users = getUsers();

            for (User user : users) {
                System.out.println(user.getId() + " " + user.getUsername() + " " + user.getPassword());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class User {
    private int id;
    private String username;
    private String password;

    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}