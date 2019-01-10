package view;

import java.io.File;
import java.util.Scanner;

public class MenuView {

    public void printMenu() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("menu.txt").getFile());
        Scanner fileScanner;
        try {
            fileScanner = new Scanner(file);
            while(fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }


    }

    public int getUserChoice() {
        String choice = "";

        Scanner getChoice = new Scanner(System.in);
        if(getChoice.hasNextLine()) {
            choice = getChoice.nextLine();
        }
        if(choice.matches("^[0-9]$")) {
            return Integer.parseInt(choice);
        }

        return -1;
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
