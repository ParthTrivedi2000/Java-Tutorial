package org.allTopics.Creational.Factory.FactoryExample.DataBaseExample.Version1;

public class Client {
    public static void main(String[] args) {
        // Currently Hardcoding db to run program else it is giving error. But this db we will be passing via Dependency
        // Injection in the configuration.
        DataBase db = new MySQLDatabase();
        Query q;

        if(db instanceof MySQLDatabase) q = new MySQLQuery();
        else if(db instanceof PostgreSQLDatabase) q = new PostgreSQLQuery();
    }
}
