package view;

import java.util.Scanner;

public class AdvancedSearch {

    public static String getSearchPhrase() {
        String searchPhrase = "";
        Scanner scanner = new Scanner(System.in);
        if(scanner.hasNextLine()) {
            searchPhrase = scanner.nextLine();
        }

        return searchPhrase.toLowerCase();
    }
}
