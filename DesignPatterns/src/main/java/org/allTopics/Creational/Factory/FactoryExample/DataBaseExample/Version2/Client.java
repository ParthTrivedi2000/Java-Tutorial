package org.allTopics.Creational.Factory.FactoryExample.DataBaseExample.Version2;

public class Client {
    public static void main(String[] args) {

        DataBase db = new MySQLDatabase();

        // Creation of Query object depends on the Database Type Object. i.e. if it's Mysql the we should create
        // MysQLQuery. If it's Postgres then we should create PostGreSQLQuery. if it's Mongo, we should create MongoQuery.
        Query q = db.createQuery();
    }
}
