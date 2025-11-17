package org.allTopics.Creational.Factory.FactoryExample.DataBaseExample.Version3;

public class MySQLDatabase implements DataBase {

    @Override
    public DataBaseFactory createDatabaseFactory() {
        return new MySQLDBFactory();
    }

}
