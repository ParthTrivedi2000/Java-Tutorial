package org.allTopics.Creational.Factory.FactoryExample.DataBaseExample2;

public class DataBaseFactory {
    public static DataBase createDataBase(String databaseName) {
        if(databaseName.equalsIgnoreCase("mysql")) {return new MySQL();}
        else if(databaseName.equalsIgnoreCase("postgresql")) {return new PostgreSQL();}
        else if(databaseName.equalsIgnoreCase("oracle")) {return new Oracle();}
        return null;
    }
}
