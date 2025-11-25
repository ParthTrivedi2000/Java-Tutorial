package org.allTopics.Creational.Factory.FactoryExample.DataBaseExample2;

public interface DataBase {

//    public Query createQuery();
//    public Trasaction createTransaction();

    public void executeQuery(String query);
    public void executeTransaction(String transaction);

}
