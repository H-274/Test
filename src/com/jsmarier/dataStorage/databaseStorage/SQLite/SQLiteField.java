package com.jsmarier.dataStorage.databaseStorage.SQLite;

import com.jsmarier.dataStorage.databaseStorage.Field.FieldDataType;
import com.jsmarier.dataStorage.databaseStorage.Field.FieldKeying;
import com.jsmarier.dataStorage.databaseStorage.Field.IDatabaseField;

public class SQLiteField implements IDatabaseField {

    String name;
    FieldDataType dataType;
    FieldKeying keying;

    public SQLiteField(String name, FieldDataType dataType, FieldKeying keying) {
        this.name = name;
        this.dataType = dataType;
        this.keying = keying;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public FieldDataType getDataType() {
        return null;
    }

    @Override
    public FieldKeying getKeying() {
        return null;
    }
}
