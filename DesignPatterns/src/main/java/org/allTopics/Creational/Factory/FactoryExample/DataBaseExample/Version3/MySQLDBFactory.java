package org.allTopics.Creational.Factory.FactoryExample.DataBaseExample.Version3;

public class MySQLDBFactory implements DataBaseFactory{
    @Override
    public Query createQuery() {
        return new MySQLQuery();
    }
}
