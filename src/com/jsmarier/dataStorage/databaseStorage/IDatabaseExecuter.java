package com.jsmarier.dataStorage.databaseStorage;

public interface IDatabaseExecuter {

    void execute(IDatabaseQuery query, String ... args);

    DatabaseRecord fetch(IDatabaseQuery query, String ... args);
}
