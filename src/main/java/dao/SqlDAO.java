package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SqlDAO {
    private Connection c;
    private Statement stmt;

    public SqlDAO() {
        c = null;
        stmt = null;
    }

    private void connectDatabase() {
        try {
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db", "postgres", "123"); // set user and password
            stmt = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }

    private void disconnectDatabase() {
        try {
            stmt.close();
            c.close();
            stmt = null;
            c = null;
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
}
