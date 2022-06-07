package com.jsmarier.dataStorage.databaseStorage.SQLite;

import com.jsmarier.dataStorage.databaseStorage.DatabaseRecord;
import com.jsmarier.dataStorage.databaseStorage.Field.IDatabaseField;
import com.jsmarier.dataStorage.databaseStorage.IDatabaseManager;
import com.jsmarier.dataStorage.databaseStorage.IDatabaseExecuter;
import com.jsmarier.dataStorage.databaseStorage.IDatabaseTable;

import java.util.HashSet;
import java.util.Set;

public class SQLiteDatabaseManager implements IDatabaseManager {

    IDatabaseExecuter executer;

    @Override
    public void setExecuter(IDatabaseExecuter executer) {
        this.executer = executer;
    }

    @Override
    public boolean createTable(String tableName, IDatabaseField... tableFields) {
        boolean isSuccessful = true;

        try {
            SQLiteTable newTable = new SQLiteTable(tableName);
            executer.execute(newTable.generateCreationQuery());

            for (IDatabaseField field : tableFields) {
                executer.execute(newTable.addField(field));
            }
        } catch (Exception e) {
            isSuccessful = false;
        }

        return isSuccessful;
    }

    @Override
    public Set<IDatabaseTable> fetchTableSet() {
        Set<IDatabaseTable> retSet = new HashSet<>();
        DatabaseRecord record = executer.fetch(new SQLiteQuery("fetchAllTablesQuery"));

        for (Object table : record.data()) {
            SQLiteTable currentTable = new SQLiteTable(table.toString());
            Set<IDatabaseField> fieldSet = currentTable.fetchFields(executer);

            for (IDatabaseField field : fieldSet) {
                currentTable.addField(field);
            }

            retSet.add(currentTable);
        }

        return retSet;
    }
}
