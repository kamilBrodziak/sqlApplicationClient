package view;

import model.Record;

import java.util.*;

public class Tools {

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static List<Integer> getColumnsLength(List<Record> recordList) {
        List<Integer> columnsLen = new ArrayList<>();
        int additionalSpace = 2;

        for(int i = 0; i < recordList.get(0).getRecordAttributes().size(); ++i) { columnsLen.add(0); }

        for(Record record: recordList) {
            List<String> recordAttributes = record.getRecordAttributes();
            for(int i = 0; i < recordAttributes.size(); ++i) {
                int currStatLen = recordAttributes.get(i).length() + additionalSpace;
                if(currStatLen > columnsLen.get(i)) {
                    columnsLen.set(i, currStatLen);
                }
            }
        }

        return columnsLen;
    }

    public static String centerString(String string, int length) {
        length -= string.length();
        while(length > 0) {
            string = " " + string;
            --length;
            if(length > 0) {
                string += " ";
                --length;
            }
        }
        return string;
    }

    public static String leftAllignString(String string, int length) {
        length -= string.length();
        while(length > 0) {
            string += " ";
            --length;
        }
        return string;
    }

    public static String rightAllignString(String string, int length) {
        length -= string.length();
        while(length > 0) {
            string = " " + string;
            --length;
        }
        return string;
    }

    public static String multiplyString(String string, int count) {
        count -= string.length();
        String outString = string;
        while(count > 0) {
            outString += string;
            count = count - 1;
        }
        return outString;
    }
}
