package com.jsmarier.dataStorage.databaseStorage.SQLite;

import com.jsmarier.dataStorage.databaseStorage.DatabaseRecord;
import com.jsmarier.dataStorage.databaseStorage.Field.IDatabaseField;
import com.jsmarier.dataStorage.databaseStorage.IDatabaseExecuter;
import com.jsmarier.dataStorage.databaseStorage.IDatabaseQuery;
import com.jsmarier.dataStorage.databaseStorage.IDatabaseTable;

import java.util.HashSet;
import java.util.Set;

public class SQLiteTable implements IDatabaseTable {

    String name;
    Set<IDatabaseField> fieldSet;

    public SQLiteTable(String name) {
        this.name = name;
        fieldSet = new HashSet<>();
    }

    @Override
    public Set<IDatabaseField> fetchFields(IDatabaseExecuter executer) {
        Set<IDatabaseField> retSet = new HashSet<>();
        DatabaseRecord record = executer.fetch(new SQLiteQuery("fetchFieldsQuery"));

        for (Object field : record.data()) {
            IDatabaseField castField = (IDatabaseField) field;

            retSet.add(castField);
        }

        return retSet;
    }

    @Override
    public IDatabaseQuery<String> addField(IDatabaseField field) {
        fieldSet.add(field);

        return new SQLiteQuery("table: " + name + " - field: " + field.getName() + " - AddFieldQuery");
    }

    @Override
    public void updateFields(IDatabaseExecuter executer) {
        fieldSet = new HashSet<>();

        fieldSet.addAll(fetchFields(executer));
    }

    @Override
    public IDatabaseQuery<String> generateCreationQuery() {
        return new SQLiteQuery("table: " + name + " - CreationQuery");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SQLiteTable)) return false;
        SQLiteTable that = (SQLiteTable) o;
        return name.equals(that.name);
    }
}
