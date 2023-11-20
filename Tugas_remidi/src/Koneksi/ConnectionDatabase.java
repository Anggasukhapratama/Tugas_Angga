package Koneksi;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;

public class ConnectionDatabase {

  public static Connection getKoneksi() {
    try {
        Properties prop = new Properties();
        InputStream input = ConnectionDatabase.class.getClassLoader().getResourceAsStream("config.properties");

        if (input == null) {
            System.out.println("Sorry, unable to find config.properties");
            return null;
        }

        prop.load(input);

        String url = prop.getProperty("db.url=jdbc:mysql://localhost:3306/loginform");
        String username = prop.getProperty("db.username");
        String password = prop.getProperty("db.password");

        System.out.println("URL: " + url);
        System.out.println("Username: " + username);

        return DriverManager.getConnection(url, username, password);
    } catch (IOException | SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Database connection error: " + e.getMessage(), "Connection Error", JOptionPane.ERROR_MESSAGE);
        return null;
    }
}
}
