package org.allTopics.Creational.Factory.FactoryExample.DataBaseExample.Version2;

public class MySQLDatabase implements DataBase {
    @Override
    public Query createQuery() {
        return new MySQLQuery();
    }
}
