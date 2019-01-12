package view;

import model.Record;
import model.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TablePrint {
    private static final int OUTER_FRAMES_AMOUNT = 2;
    private static final String COLOR_RESET = "\033[0m";
    private static final String COLOR_CYAN_BACK = "\033[0;106m";
    private static final String TABLE_CHAR = "█";

    public static void showTable(Table table) {
        Tools.clearScreen();
        List<Record> recordList = table.getRecordList();
        List<String> columnHeaderList = table.getColumnHeaderList();
        String tableHeader = table.getTableHeader();
        if(recordList.size() == 0) {
            System.out.println("No records found.");
            return;
        }

        List<Record> rowsToAnalyze = new ArrayList<>(recordList);
        if(recordList.get(0).getRecordAttributes().size() == columnHeaderList.size()) {
            rowsToAnalyze.add(new Record(columnHeaderList));
        }

        if(recordList.get(0).getRecordAttributes().size() == 1) {
            List<String> titleRec = new ArrayList<>();
            titleRec.add(tableHeader);
            rowsToAnalyze.add(new Record(titleRec));
        }

        List<Integer> columnsLength = Tools.getColumnsLength(rowsToAnalyze);
        int tableWidth = OUTER_FRAMES_AMOUNT + columnsLength.size() - 1;
        for(int len: columnsLength) {
            tableWidth += len;
        }

        printTableHeaderPart(table.getTableHeader(), tableWidth);
        printHeaderPart(table.getColumnHeaderList(), columnsLength, tableWidth);
        printRowsPart(table.getRecordList(), columnsLength, tableWidth);

        Scanner backMenu = new Scanner(System.in);
        if(backMenu.hasNextLine()) {
            backMenu.nextLine();
        }
    }

    private static void printTableHeaderPart(String title, int tableWidth) {
        System.out.println(Tools.multiplyString(TABLE_CHAR, tableWidth));
        System.out.println(TABLE_CHAR + COLOR_CYAN_BACK +
                Tools.multiplyString(" ", tableWidth - OUTER_FRAMES_AMOUNT) + COLOR_RESET + TABLE_CHAR);
        printHeader(title, tableWidth - OUTER_FRAMES_AMOUNT);
        System.out.println(TABLE_CHAR);
        System.out.println(TABLE_CHAR + COLOR_CYAN_BACK +
                Tools.multiplyString(" ", tableWidth - OUTER_FRAMES_AMOUNT) + COLOR_RESET + TABLE_CHAR);
    }

    private static void printHeaderPart(List<String> tableHeaders, List<Integer> columnsLength, int tableWidth) {
        System.out.println(Tools.multiplyString(TABLE_CHAR, tableWidth));
        if (tableHeaders.size() == 1) {
            System.out.println(TABLE_CHAR + COLOR_CYAN_BACK +
                    Tools.multiplyString(" ", tableWidth - OUTER_FRAMES_AMOUNT) + COLOR_RESET + TABLE_CHAR);
            printHeader(tableHeaders.get(0), tableWidth - OUTER_FRAMES_AMOUNT);
            System.out.println(TABLE_CHAR);
            System.out.println(TABLE_CHAR + COLOR_CYAN_BACK +
                    Tools.multiplyString(" ", tableWidth - OUTER_FRAMES_AMOUNT) + COLOR_RESET + TABLE_CHAR);
        } else if(tableHeaders.size() == columnsLength.size()) {
            printHeaders(tableHeaders, columnsLength);
        }

        System.out.println(Tools.multiplyString(TABLE_CHAR, tableWidth));
    }

    private static void printHeader(String header, int length) {
        System.out.print(TABLE_CHAR + COLOR_CYAN_BACK + Tools.centerString(header, length) + COLOR_RESET);
    }

    private static void printHeaders(List<String> tableHeaders, List<Integer> columnsLength) {
        printDecor(columnsLength, COLOR_CYAN_BACK);
        for(int i = 0; i < tableHeaders.size(); ++i) {
            printHeader(tableHeaders.get(i), columnsLength.get(i));
        }
        System.out.println(TABLE_CHAR);
        printDecor(columnsLength, COLOR_CYAN_BACK);
    }

    private static void printRowsPart(List<Record> rows, List<Integer> columnsLength, int tableWidth) {
        for(Record row: rows) {
            printDecor(columnsLength);
            printRow(row.getRecordAttributes(), columnsLength);
            printDecor(columnsLength);
            System.out.println(Tools.multiplyString(TABLE_CHAR, tableWidth));
        }
    }

    private static void printDecor(List<Integer> columnsLength) {
        for(int i = 0; i < columnsLength.size(); ++i) {
            System.out.print(TABLE_CHAR + Tools.multiplyString(" ", columnsLength.get(i)));
        }
        System.out.println(TABLE_CHAR);
    }

    private static void printDecor(List<Integer> columnsLength, String color) {
        for(int i = 0; i < columnsLength.size(); ++i) {
            System.out.print(TABLE_CHAR + color + Tools.multiplyString(" ", columnsLength.get(i)) + COLOR_RESET);
        }
        System.out.println(TABLE_CHAR);
    }

    private static void printRow(List<String> row, List<Integer> columnsLength) {
        int rowSize = row.size();
        for(int i = 0; i < rowSize; ++i) {
            if(rowSize == 2 && i == 0)
                System.out.print(TABLE_CHAR + Tools.rightAllignString(" " + row.get(i) + " ", columnsLength.get(i)));
            else if(rowSize == 2 && i == 1) {
                System.out.print(TABLE_CHAR + Tools.leftAllignString(" " + row.get(i) + " ", columnsLength.get(i)));
            } else {
                System.out.print(TABLE_CHAR + Tools.centerString(row.get(i), columnsLength.get(i)));
            }
        }
        System.out.println(TABLE_CHAR);
    }
}
