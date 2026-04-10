import java.sql.*;
import java.util.*;

public class CarDAO {
    public static List<String> getAllCars() {
        List<String> cars = new ArrayList<>();
        try (Connection conn = DBHelper.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT name, category FROM cars")) {
            while (rs.next()) {
                cars.add(rs.getString("name") + " (" + rs.getString("category") + ")");
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return cars;
    }
    public static void addCar(String name, String category) {
        try (Connection conn = DBHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO cars (name, category) VALUES (?, ?)")) {
            ps.setString(1, name);
            ps.setString(2, category);
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }
    public static void deleteCar(String name, String category) {
        try (Connection conn = DBHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement("DELETE FROM cars WHERE name=? AND category=?")) {
            ps.setString(1, name);
            ps.setString(2, category);
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }
    public static void updateCar(String oldName, String oldCategory, String newName, String newCategory) {
        try (Connection conn = DBHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement("UPDATE cars SET name=?, category=? WHERE name=? AND category=?")) {
            ps.setString(1, newName);
            ps.setString(2, newCategory);
            ps.setString(3, oldName);
            ps.setString(4, oldCategory);
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }
}