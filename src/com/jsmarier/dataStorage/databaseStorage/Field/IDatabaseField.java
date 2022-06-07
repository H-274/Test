package com.jsmarier.dataStorage.databaseStorage.Field;

public interface IDatabaseField {

    String getName();

    void setName(String name);

    FieldDataType getDataType();

    FieldKeying getKeying();
}
