package org.allTopics.Creational.Factory.FactoryExample.DataBaseExample.Version2;

public class PostgreSQLDatabase implements DataBase {
    @Override
    public Query createQuery() {
        return new PostgreSQLQuery();
    }
}
