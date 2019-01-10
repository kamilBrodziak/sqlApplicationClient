package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TablePrint {
    private static final int OUTER_FRAMES_AMOUNT = 2;

    public static void showTable(List<ArrayList<String>> rows, ArrayList<String> tableHeaders) {
        Tools.clearScreen();
        if(rows.size() == 0) {
            System.out.println("No records found.");
            return;
        }

        ArrayList<ArrayList<String>> rowsToAnalyze = new ArrayList<>(rows);
        if(rows.get(0).size() == tableHeaders.size()) {
            rowsToAnalyze.add(tableHeaders);
        }

        List<Integer> columnsLength = Tools.getColumnsLength(rowsToAnalyze);
        int tableWidth = OUTER_FRAMES_AMOUNT + columnsLength.size() - 1;
        for(int len: columnsLength) {
            tableWidth += len;
        }


        printHeaderPart(tableHeaders, columnsLength, tableWidth);
        printRowsPart(rows, columnsLength, tableWidth);

        Scanner backMenu = new Scanner(System.in);
        if(backMenu.hasNextLine()) {
            backMenu.nextLine();
        }

    }

    private static void printHeaderPart(List<String> tableHeaders, List<Integer> columnsLength, int tableWidth) {
        System.out.println(Tools.multiplyString("█", tableWidth));
        if (tableHeaders.size() == 1) {
            System.out.println("█" + Tools.multiplyString(" ", tableWidth - OUTER_FRAMES_AMOUNT) + "█");
            printHeader(tableHeaders.get(0), tableWidth - OUTER_FRAMES_AMOUNT);
            System.out.println("█");
            System.out.println("█" + Tools.multiplyString(" ", tableWidth - OUTER_FRAMES_AMOUNT) + "█");
        } else if(tableHeaders.size() == columnsLength.size()) {
            printHeaders(tableHeaders, columnsLength);
        }

        System.out.println(Tools.multiplyString("█", tableWidth));
    }

    private static void printHeader(String header, int length) {
        System.out.print("█" + Tools.centerString(header, length));
    }

    private static void printHeaders(List<String> tableHeaders, List<Integer> columnsLength) {
        printDecor(columnsLength);
        for(int i = 0; i < tableHeaders.size(); ++i) {
            printHeader(tableHeaders.get(i), columnsLength.get(i));
        }
        System.out.println("█");
        printDecor(columnsLength);
    }

    private static void printRowsPart(List<ArrayList<String>> rows, List<Integer> columnsLength, int tableWidth) {
        for(List<String> row: rows) {
            printDecor(columnsLength);
            printRow(row, columnsLength);
            printDecor(columnsLength);
            System.out.println(Tools.multiplyString("█", tableWidth));
        }
    }

    private static void printDecor(List<Integer> columnsLength) {
        for(int i = 0; i < columnsLength.size(); ++i) {
            System.out.print("█" + Tools.multiplyString(" ", columnsLength.get(i)));
        }
        System.out.println("█");
    }

    private static void printRow(List<String> row, List<Integer> columnsLength) {
        int rowSize = row.size();
        for(int i = 0; i < rowSize; ++i) {
            if(rowSize == 2 && i == 0)
                System.out.print("█" + Tools.rightAllignString(" " + row.get(i) + " ", columnsLength.get(i)));
            else if(rowSize == 2 && i == 1) {
                System.out.print("█" + Tools.leftAllignString(" " + row.get(i) + " ", columnsLength.get(i)));
            } else {
                System.out.print("█" + Tools.centerString(row.get(i), columnsLength.get(i)));
            }
        }
        System.out.println("█");
    }
}
