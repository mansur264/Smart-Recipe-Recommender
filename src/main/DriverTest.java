public class DriverTest {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("✅ MySQL Driver loaded successfully!");
        } catch (ClassNotFoundException e) {
            System.out.println("❌ MySQL Driver NOT found!");
            e.printStackTrace();
        }
    }
}
