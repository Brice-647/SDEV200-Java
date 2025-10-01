import java.sql.*;

public class TestDB {
    public static void main(String[] args) {
        // Database credentials
        String url = "jdbc:mysql://localhost:3306/university"; // 3306 is default MySQL port
        String user = "root"; // XAMPP default user
        String password = ""; // leave empty if you haven’t set one in phpMyAdmin

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Connected to database!");

            // Create a statement
            Statement stmt = conn.createStatement();

            // Execute a query
            ResultSet rs = stmt.executeQuery("SELECT * FROM Staff");

            // Print results
            while (rs.next()) {
                String id = rs.getString("id");
                String lastName = rs.getString("lastName");
                String firstName = rs.getString("firstName");
                String email = rs.getString("email");

                System.out.println(id + " | " + lastName + " | " + firstName + " | " + email);
            }

            // Close connection
            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
