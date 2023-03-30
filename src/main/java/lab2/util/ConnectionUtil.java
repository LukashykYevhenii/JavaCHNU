package lab2.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class ConnectionUtil {

    public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    public static final String DATABASE_URL = "jdbc:mysql://localhost:3306/summer_session?autoReconnect=true&useSSL=false";


    public static final String USER = "root";
    public static final String PASSWORD = "root";

    public static Connection connection = null;
    public static Statement statement = null;
    public static PreparedStatement preparedStatement = null;

    public static void getConnection() throws SQLException, ClassNotFoundException {
        Class.forName(JDBC_DRIVER);
        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
    }

    public static void closeConnection() throws SQLException {
        connection.close();
    }

    public static void closePreparedStatement() {
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        }
    }
}
