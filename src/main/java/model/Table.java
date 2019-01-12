package model;

import java.util.List;

public class Table {
    private String tableHeader;
    private List<String> columnHeaderList;
    private List<Record> recordList;

    public Table(String tableHeader, List<String> columnHeaderList, List<Record> recordList) {
        this.tableHeader = tableHeader;
        this.columnHeaderList = columnHeaderList;
        this.recordList = recordList;
    }

    public String getTableHeader() {
        return tableHeader;
    }

    public List<Record> getRecordList() {
        return recordList;
    }

    public List<String> getColumnHeaderList() {
        return columnHeaderList;
    }
}
