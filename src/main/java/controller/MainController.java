package controller;

import dao.SqlDAO;
import view.MenuView;

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
            menuView.clearScreen();
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

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;
            case 6:

                break;
            case 7:

                break;
            case 8:

                break;
        }
    }
}
