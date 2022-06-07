package com.jsmarier.dataStorage.databaseStorage.SQLite;

import com.jsmarier.dataStorage.databaseStorage.DatabaseRecord;
import com.jsmarier.dataStorage.databaseStorage.IDatabaseExecuter;
import com.jsmarier.dataStorage.databaseStorage.IDatabaseQuery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SQLiteExecuter implements IDatabaseExecuter {

    @Override
    public void execute(IDatabaseQuery query, String ... args) {
        System.out.println(query.getQuery());
    }

    @Override
    public DatabaseRecord fetch(IDatabaseQuery query, String ... args) {
        if (query instanceof SQLiteQuery castQuery){
            List<String> returnedList = Arrays.asList(castQuery.getQuery());

            return new DatabaseRecord(new ArrayList<>(returnedList));
        }

        return null;
    }
}
