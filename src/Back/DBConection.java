package Back;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConection {
    public static void main(String[] args)
            throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        String url = "jdbc:mysql://127.0.0.1:3306/Quiz?user=root&password=$JUANjose2006";
        Driver d = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        Connection conn = DriverManager.getConnection(url);

        if (!conn.isClosed()) {

            System.out.println("Connected to " + conn.getCatalog());

        }
        // conn.close()
        if (conn.isClosed()) {

            System.out.println("BYE !!!");
        }

    }// main

}