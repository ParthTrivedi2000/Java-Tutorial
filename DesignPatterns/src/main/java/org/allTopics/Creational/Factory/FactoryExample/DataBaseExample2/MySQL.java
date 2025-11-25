package org.allTopics.Creational.Factory.FactoryExample.DataBaseExample2;

public class MySQL implements DataBase{

    @Override
    public void executeQuery(String query) {
        System.out.println("Executing Query from MySQL..." + query);
    }

    @Override
    public void executeTransaction(String transaction) {
        System.out.println("Executing Transaction from MySQL..." + transaction);

    }
}
