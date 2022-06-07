package com.jsmarier.dataStorage.databaseStorage;

import com.jsmarier.dataStorage.databaseStorage.Field.IDatabaseField;

import java.util.Set;

public interface IDatabaseTable {

    Set<IDatabaseField> fetchFields(IDatabaseExecuter executer);

    IDatabaseQuery<String> addField(IDatabaseField field);

    void updateFields(IDatabaseExecuter executer);

    IDatabaseQuery generateCreationQuery();

    String getName();

    boolean equals(Object o);
}
