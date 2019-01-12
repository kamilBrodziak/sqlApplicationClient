package model;

import java.util.List;

public class Record {
    private List<String> record;

    public Record(List<String> record) {
        this.record = record;
    }

    public List<String> getRecordAttributes() {
        return record;
    }
}
