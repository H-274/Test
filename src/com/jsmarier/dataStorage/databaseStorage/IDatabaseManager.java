package com.jsmarier.dataStorage.databaseStorage;

import com.jsmarier.dataStorage.databaseStorage.Field.IDatabaseField;

import java.util.Set;

public interface IDatabaseManager {

    void setExecuter(IDatabaseExecuter executer);

    boolean createTable(String tableName, IDatabaseField... tableFields);

    Set<IDatabaseTable> fetchTableSet();
}
