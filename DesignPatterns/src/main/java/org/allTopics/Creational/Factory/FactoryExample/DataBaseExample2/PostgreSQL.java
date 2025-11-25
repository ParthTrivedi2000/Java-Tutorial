package org.allTopics.Creational.Factory.FactoryExample.DataBaseExample2;

public class PostgreSQL implements DataBase{
    @Override
    public void executeQuery(String query) {
        System.out.println("Executing query from Postgres: " + query);
    }

    @Override
    public void executeTransaction(String transaction) {
        System.out.println("Executing transaction from Postgres: " + transaction);
    }
}
