package com.jsmarier.dataStorage.databaseStorage.SQLite;

import com.jsmarier.dataStorage.databaseStorage.IDatabaseQuery;

public class SQLiteQuery implements IDatabaseQuery<String> {

    String query;

    public SQLiteQuery(String query) {
        this.query = query;
    }

    @Override
    public String getQuery() {
        return query;
    }
}
