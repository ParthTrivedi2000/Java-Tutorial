package org.allTopics.Creational.Factory.FactoryExample.DataBaseExample.Version3;

public class PostgreSQLDatabase implements DataBase {

    @Override
    public DataBaseFactory createDatabaseFactory() {
        return new PostgreSQLDBFactory();
    }
}
