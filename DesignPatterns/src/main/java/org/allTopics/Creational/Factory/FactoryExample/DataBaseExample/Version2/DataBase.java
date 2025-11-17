package org.allTopics.Creational.Factory.FactoryExample.DataBaseExample.Version2;

public interface DataBase {

    // Instead of writing logic here to create Object based on other Object type, we are delegating that responsibility
    // to respective Child class itself.

    Query createQuery();

    // createConnection
    // createTransaction
    // createSecurityLayer

}
