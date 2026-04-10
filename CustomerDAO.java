import java.sql.*;
import java.util.*;

public class CustomerDAO {
    public static boolean authenticate(String username, String password) {
        try (Connection conn = DBHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM customers WHERE username=? AND password=?")) {
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) { e.printStackTrace(); }
        return false;
    }
    public static boolean register(String username, String password) {
        try (Connection conn = DBHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO customers (username, password) VALUES (?, ?)")) {
            ps.setString(1, username);
            ps.setString(2, password);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) { return false; }
    }
    public static List<String> getAllCustomers() {
        List<String> users = new ArrayList<>();
        try (Connection conn = DBHelper.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT username FROM customers")) {
            while (rs.next()) users.add(rs.getString("username"));
        } catch (SQLException e) { e.printStackTrace(); }
        return users;
    }
    public static void deleteCustomer(String username) {
        try (Connection conn = DBHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement("DELETE FROM customers WHERE username=?")) {
            ps.setString(1, username);
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }
    public static void updatePassword(String username, String newPass) {
        try (Connection conn = DBHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement("UPDATE customers SET password=? WHERE username=?")) {
            ps.setString(1, newPass);
            ps.setString(2, username);
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }
}