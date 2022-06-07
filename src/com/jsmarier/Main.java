package com.jsmarier;

import com.jsmarier.dataStorage.databaseStorage.Field.FieldDataType;
import com.jsmarier.dataStorage.databaseStorage.Field.FieldKeying;
import com.jsmarier.dataStorage.databaseStorage.SQLite.SQLiteDatabaseManager;
import com.jsmarier.dataStorage.databaseStorage.SQLite.SQLiteExecuter;
import com.jsmarier.dataStorage.databaseStorage.SQLite.SQLiteField;

public class Main {

    public static void main(String[] args) {
        SQLiteDatabaseManager database = new SQLiteDatabaseManager();

        SQLiteField[] fields = {
                new SQLiteField("F1", FieldDataType.INT, FieldKeying.PRIMARY_KEY),
                new SQLiteField("F2", FieldDataType.DECIMAL, FieldKeying.NONE),
                new SQLiteField("F3", FieldDataType.DATE, FieldKeying.NONE),
                new SQLiteField("F4", FieldDataType.VARCHAR, FieldKeying.NONE)
        };

        database.setExecuter(new SQLiteExecuter());

        System.out.println(database.createTable("Table1", fields));

        System.out.println(database.fetchTableSet());
    }
}
