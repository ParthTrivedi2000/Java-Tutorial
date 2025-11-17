package org.allTopics.Creational.Factory.FactoryExample.DataBaseExample.Version3;

public interface DataBase {

    // Here we have implemented the Abstract Factory Design Pattern, Since we have delegated the responsibility of
    // all the dependents objects which depends on DB object type --> to the separate Interface called DBFactory.
    DataBaseFactory createDatabaseFactory();

}
