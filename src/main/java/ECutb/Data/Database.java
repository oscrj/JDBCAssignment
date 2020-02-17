package ECutb.Data;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Database {

    public static Connection getConnections() throws SQLException {
        Properties properties = new Properties();
        try{
           properties.load(new FileInputStream("src/main/resources/Connect.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");

        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }
}
