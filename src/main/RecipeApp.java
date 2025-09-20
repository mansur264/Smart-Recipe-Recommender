import java.sql.*;
import java.util.Scanner;


public class RecipeApp {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Recipe App ===");
            System.out.println("1. Add Recipe");
            System.out.println("2. View Recipes");
            System.out.println("3. Add Ingredients to Recipe");
            System.out.println("4. Update Recipe");
            System.out.println("5. Delete Recipe");
            System.out.println("6. Suggest Recipes");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            int choice = -1;
            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                System.out.println("❌ Invalid input! Please enter a number.");
                sc.nextLine(); // clear scanner
                continue;
            }
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addRecipe();
                case 2 -> viewRecipes();
                case 3 -> addIngredients();
                case 4 -> updateRecipe();
                case 5 -> deleteRecipe();
                case 6 -> suggestRecipes();
                case 7 -> {
                    System.out.println("👋 Goodbye!");
                    return;
                }
                default -> System.out.println("❌ Invalid choice!");
            }
        }
    }

    private static void addRecipe() {
        System.out.print("Enter recipe name: ");
        String name = sc.nextLine();
        try (Connection conn = DatabaseConnection.getConnection()) {
            if (conn == null) return;
            String sql = "INSERT INTO recipes (recipe_name) VALUES (?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.executeUpdate();
            System.out.println("✅ Recipe added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void viewRecipes() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            if (conn == null) return;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM recipes");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + ". " + rs.getString("recipe_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void addIngredients() {
        System.out.print("Enter recipe ID: ");
        int id;
        try {
            id = sc.nextInt();
        } catch (Exception e) {
            System.out.println("❌ Invalid input! Must be a number.");
            sc.nextLine();
            return;
        }
        sc.nextLine();
        System.out.print("Enter ingredient: ");
        String ingredient = sc.nextLine();

        try (Connection conn = DatabaseConnection.getConnection()) {
            if (conn == null) return;
            String sql = "INSERT INTO ingredients (recipe_id, ingredient_name) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.setString(2, ingredient);
            stmt.executeUpdate();
            System.out.println("✅ Ingredient added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void updateRecipe() {
        System.out.print("Enter recipe ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter new recipe name: ");
        String name = sc.nextLine();

        try (Connection conn = DatabaseConnection.getConnection()) {
            if (conn == null) return;
            String sql = "UPDATE recipes SET recipe_name = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setInt(2, id);
            int rows = stmt.executeUpdate();
            System.out.println(rows > 0 ? "✅ Recipe updated!" : "❌ Recipe not found!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void deleteRecipe() {
        System.out.print("Enter recipe ID to delete: ");
        int id = sc.nextInt();
        sc.nextLine();

        try (Connection conn = DatabaseConnection.getConnection()) {
            if (conn == null) return;
            String sql = "DELETE FROM recipes WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            System.out.println(rows > 0 ? "✅ Recipe deleted!" : "❌ Recipe not found!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void suggestRecipes() {
        System.out.print("Enter ingredient to search recipes: ");
        String keyword = sc.nextLine();

        try (Connection conn = DatabaseConnection.getConnection()) {
            if (conn == null) return;
            String sql = "SELECT DISTINCT r.id, r.recipe_name FROM recipes r " +
                         "JOIN ingredients i ON r.id = i.recipe_id " +
                         "WHERE i.ingredient_name LIKE ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + keyword + "%");
            ResultSet rs = stmt.executeQuery();
            System.out.println("🔹 Recipes containing \"" + keyword + "\":");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + ". " + rs.getString("recipe_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
