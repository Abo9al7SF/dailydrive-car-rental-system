import java.sql.*;
import java.util.*;

public class LogDAO {
    public static void log(String action) {
        try (Connection conn = DBHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO logs (action, time) VALUES (?, datetime('now'))")) {
            ps.setString(1, action);
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }
    public static List<String> getAllLogs() {
        List<String> logs = new ArrayList<>();
        try (Connection conn = DBHelper.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT action, time FROM logs ORDER BY id")) {
            while (rs.next()) logs.add(rs.getString("action") + " at " + rs.getString("time"));
        } catch (SQLException e) { e.printStackTrace(); }
        return logs;
    }
}