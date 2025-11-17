package org.allTopics.Creational.Factory.FactoryExample.DataBaseExample.Version3;

public class PostgreSQLDBFactory implements DataBaseFactory{
    @Override
    public Query createQuery() {
        return new PostgreSQLQuery();
    }
}
