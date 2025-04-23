package ie.atu;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Insert {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/usingjdbc";
        String user = "root";
        String password = "password";

        try {
            // 1. Connect to database
            Connection conn = DriverManager.getConnection(url, user, password);

            // 2. Prepare SQL insert statement
            String sql = "INSERT INTO students (first_name, last_name, email, age) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "Alice");
            pstmt.setString(2, "Doherty");
            pstmt.setString(3, "alice@example.com");
            pstmt.setInt(4, 21);

            // 3. Execute update
            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new user was inserted successfully!");
            }

            // 4. Close connection
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

