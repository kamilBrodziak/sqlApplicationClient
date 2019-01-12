package dao;
import model.Table;
import view.AdvancedSearch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SqlDAO {
    private Connection c;
    private Statement stmt;
    private AdvancedSearchDAO advancedSearchDAO;

    public SqlDAO() {
        c = null;
        stmt = null;
        advancedSearchDAO = new AdvancedSearchDAO();
    }

    private void connectDatabase() {
        try {
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db", "postgres", "123");
            c.setAutoCommit(false);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }

    private void disconnectDatabase() {
        try {
            c.close();
            c = null;
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public List<Table> getAdvancedSearchTables(String phrase) {
        connectDatabase();
        List<Table> tableList = advancedSearchDAO.searchFor(phrase, c);
        disconnectDatabase();
        return tableList;
    }
}
