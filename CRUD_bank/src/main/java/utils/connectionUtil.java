package utils;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;
import java.util.Properties;

public class connectionUtil {

    public static Connection getConnection() throws SQLException, IOException, ClassNotFoundException {
        InputStream inputStream = connectionUtil.class.getClassLoader().getResourceAsStream("application.properties");
        Properties props = new Properties();
        props.load(inputStream);
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(props.getProperty("url"), props.getProperty("username"), props.getProperty("password"));
    }
}
