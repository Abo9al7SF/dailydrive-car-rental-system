import java.sql.*;

public class DBHelper {
    private static final String URL = "jdbc:sqlite:car_rental.db";

    static {
        try {
            System.out.println("DB will be created/used at: " 
            + new java.io.File("car_rental.db").getAbsolutePath());

            Class.forName("org.sqlite.JDBC");

            try (Connection conn = getConnection()) {
                Statement stmt = conn.createStatement();

    
                stmt.execute("CREATE TABLE IF NOT EXISTS cars (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, category TEXT)");
                stmt.execute("CREATE TABLE IF NOT EXISTS customers (username TEXT PRIMARY KEY, password TEXT)");
                stmt.execute("CREATE TABLE IF NOT EXISTS logs (id INTEGER PRIMARY KEY AUTOINCREMENT, action TEXT, time TEXT)");

                ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM cars");
                if (rs.next() && rs.getInt(1) == 0) {
                    stmt.execute("INSERT INTO cars (name, category) VALUES " +
                        "('Toyota Camry','Sedan')," +
                        "('Honda Accord','Sedan')," +
                        "('Honda CR-V','SUV')," +
                        "('Toyota RAV4','SUV')," +
                        "('BMW 5 Series','Luxury')," +
                        "('Mercedes E-Class','Luxury')");
                }


                rs = stmt.executeQuery("SELECT COUNT(*) FROM customers");
                if (rs.next() && rs.getInt(1) == 0) {
                    stmt.execute("INSERT INTO customers (username, password) VALUES ('customer','customer123')");
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}