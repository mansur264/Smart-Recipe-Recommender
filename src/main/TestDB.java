import java.sql.Connection;

public class TestDB {
    public static void main(String[] args) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            if (conn != null) {
                System.out.println("✅ Connected to MySQL successfully!");
            } else {
                System.out.println("❌ Failed to connect to MySQL!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
