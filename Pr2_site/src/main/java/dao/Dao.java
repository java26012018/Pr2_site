package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dao {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://contac01.mysql.ukraine.com.ua:3306/contac01_prilosh";
    private static final String LOGIN = "contac01_prilosh";
    private static final String PASS = "4h57futz";

    protected static Connection getConnection() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        Connection out;
        try {
            out = DriverManager.getConnection(URL, LOGIN, PASS);
            return out;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
