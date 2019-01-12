package controller;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import dao.SqlDAO;
import model.Table;
import view.AdvancedSearch;
import view.MenuView;
import view.TablePrint;
import view.Tools;

import javax.swing.text.TableView;
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

                break;
            case 7:

                break;
            case 8:

                break;
        }
    }

    public void runAdvancedSearch() {
        String phrase = AdvancedSearch.getSearchPhrase();
        List<Table> tableList = dao.getAdvancedSearchTables(phrase);
        for(int i = 0; i < tableList.size(); ++i) {
            TablePrint.showTable(tableList.get(i));
        }
    }
}
