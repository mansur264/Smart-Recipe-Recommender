import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/recipe_db"; // Change DB name
    private static final String USER = "root"; // Change MySQL username
    private static final String PASSWORD = "123456789"; // Change MySQL password

    public static Connection getConnection() {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("? MySQL Driver not found!");
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            System.out.println("? Failed to connect to MySQL!");
            e.printStackTrace();
            return null;
        }
    }
}
