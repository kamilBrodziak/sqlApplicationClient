package dao;
import model.Applicant;
import model.Table;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
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

    public void addApplicant(Applicant applicant) throws Exception{
        connectDatabase();
        String query = "INSERT INTO applicants(first_name, last_name, phone_number, email, application_code) VALUES " +
                "(?, ?, ?, ?, ?::integer);";
        PreparedStatement pstmt = c.prepareStatement(query);
        pstmt.setString(1, applicant.getFirstName());
        pstmt.setString(2, applicant.getLastName());
        pstmt.setString(3, applicant.getPhoneNumber());
        pstmt.setString(4, applicant.getEmail());
        pstmt.setString(5, applicant.getApplicationNumber() + "");
        pstmt.executeUpdate();
        pstmt.close();
        c.commit();
        disconnectDatabase();
    }

    public void updateApplicantPhone(List<String> nameAndPhone) throws Exception{
        connectDatabase();
        String query = "UPDATE applicants SET phone_number=? WHERE first_name = ? AND last_name = ?;";
        PreparedStatement pstmt = c.prepareStatement(query);
        pstmt.setString(1, nameAndPhone.get(2));
        pstmt.setString(2, nameAndPhone.get(0));
        pstmt.setString(3, nameAndPhone.get(1));
        pstmt.executeUpdate();
        pstmt.close();
        c.commit();
        disconnectDatabase();
    }

    public void deleteApplicants(String email) throws Exception {
        connectDatabase();
        String query = "DELETE FROM applicants WHERE email ILIKE ?";
        PreparedStatement pstmt = c.prepareStatement(query);
        pstmt.setString(1, "%" + email + "%");
        pstmt.executeUpdate();
        pstmt.close();
        c.commit();
        c.close();
    }
}
