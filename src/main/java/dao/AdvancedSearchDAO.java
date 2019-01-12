package dao;

import model.Record;
import model.Table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AdvancedSearchDAO {

    public List<Table> searchFor(String phrase, Connection connection) {
        Table mentors = getMentorTable(phrase, connection);
        Table applicants = getApplicantsTable(phrase, connection);

        List<Table> tables = new ArrayList<>();
        tables.add(mentors);
        tables.add(applicants);

        return tables;
    }

    private Table getMentorTable(String phrase, Connection connection) {
        String tableHeader = "Mentors";
        List<String> columnHeaders = getMentorColumnHeaders();
        List<Record> records = getMentorRecords(phrase, connection);
        Table table = new Table(tableHeader, columnHeaders, records);

        return table;
    }

    private List<String> getMentorColumnHeaders() {
        List<String> columnHeaders = new ArrayList<>();
        columnHeaders.add("id");
        columnHeaders.add("First name");
        columnHeaders.add("Last name");
        columnHeaders.add("Nick");
        columnHeaders.add("Phone number");
        columnHeaders.add("Email");
        columnHeaders.add("City");
        return columnHeaders;
    }

    private List<Record> getMentorRecords(String phrase, Connection connection) {
        List<Record> recordList = new ArrayList<>();
        try {
            String query = "SELECT * FROM mentors WHERE first_name ILIKE ? OR last_name ILIKE ? OR nick_name ILIKE ? " +
                    "OR phone_number ILIKE ? OR email ILIKE ? OR city ILIKE ?";
            PreparedStatement pstmt = connection.prepareStatement(query);
            for(int i = 1; i < 7; i++){
                pstmt.setString(i,"%" + phrase + "%");
            }
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                List<String> recordAttributes = new ArrayList<>();
                recordAttributes.add(rs.getInt("id") + "");
                recordAttributes.add(rs.getString("first_name"));
                recordAttributes.add(rs.getString("last_name"));
                recordAttributes.add(rs.getString("nick_name"));
                recordAttributes.add(rs.getString("phone_number"));
                recordAttributes.add(rs.getString("email"));
                recordAttributes.add(rs.getString("city"));
                recordList.add(new Record(recordAttributes));
            }
            pstmt.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        return recordList;
    }

    private Table getApplicantsTable(String phrase,Connection connection) {
        String tableHeader = "Applicants";
        List<String> columnHeaders = getApplicantsColumnHeaders();
        List<Record> records = getApplicantsRecords(phrase, connection);
        Table table = new Table(tableHeader, columnHeaders, records);

        return table;
    }

    private List<String> getApplicantsColumnHeaders() {
        List<String> columnHeaders = new ArrayList<>();
        columnHeaders.add("id");
        columnHeaders.add("First name");
        columnHeaders.add("Last name");
        columnHeaders.add("Phone number");
        columnHeaders.add("Email");
        columnHeaders.add("Application code");
        return columnHeaders;
    }

    private List<Record> getApplicantsRecords(String phrase, Connection connection) {
        List<Record> recordList = new ArrayList<>();
        try {
            String query = "SELECT * FROM applicants WHERE first_name ILIKE ? OR last_name ILIKE ? " +
                    "OR phone_number ILIKE ? OR email ILIKE ? OR application_code::varchar ILIKE ?";
            PreparedStatement pstmt = connection.prepareStatement(query);
            for(int i = 1; i < 6; i++){
                pstmt.setString(i,"%" + phrase + "%");
            }
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                List<String> recordAttributes = new ArrayList<>();
                recordAttributes.add(rs.getInt("id") + "");
                recordAttributes.add(rs.getString("first_name"));
                recordAttributes.add(rs.getString("last_name"));
                recordAttributes.add(rs.getString("phone_number"));
                recordAttributes.add(rs.getString("email"));
                recordAttributes.add(rs.getInt("application_code") + "");
                recordList.add(new Record(recordAttributes));
            }
            pstmt.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        return recordList;
    }
}
