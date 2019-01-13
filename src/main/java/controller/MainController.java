package controller;

import dao.SqlDAO;
import model.Applicant;
import model.Table;
import view.UserInput;
import view.MenuView;
import view.TablePrint;
import view.Tools;

import java.util.List;

public class MainController {
    private SqlDAO dao;
    private MenuView menuView;

    public MainController() {
        dao = new SqlDAO();
        menuView = new MenuView();
    }

    public void start() {

        int choice = -1;

        while(choice != 0) {
            Tools.clearScreen();
            menuView.printMenu();
            choice = menuView.getUserChoice();
            runOption(choice);
        }
    }

    private void runOption(int choice) {
        switch (choice) {
            case 0:
                break;
            case 1:
                runAdvancedSearch();
                break;
            case 2:
                System.out.println("\033[0;106m" + "test    " + "\033[0m");
                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;
            case 6:
                addApplicant();
                break;
            case 7:
                updateApplicant();
                break;
            case 8:
                deleteApplicant();
                break;
        }
    }

    public void runAdvancedSearch() {
        String phrase = UserInput.getSearchPhrase();
        List<Table> tableList = dao.getAdvancedSearchTables(phrase);
        for(int i = 0; i < tableList.size(); ++i) {
            TablePrint.showTable(tableList.get(i));
        }
    }

    public void addApplicant() {
        Applicant applicant = UserInput.getNewApplicant();
        try {
            dao.addApplicant(applicant);
            List<Table> tableList = dao.getAdvancedSearchTables(applicant.getApplicationNumber() + "");
            TablePrint.showTable(tableList.get(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateApplicant() {
        List<String> fullName = UserInput.getApplicantNameAndPhone();
        try {
            dao.updateApplicantPhone(fullName);
            List<Table> tableList = dao.getAdvancedSearchTables(fullName.get(2));
            TablePrint.showTable(tableList.get(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteApplicant() {
        String email = UserInput.getEmail();
        try {
            dao.deleteApplicants(email);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
