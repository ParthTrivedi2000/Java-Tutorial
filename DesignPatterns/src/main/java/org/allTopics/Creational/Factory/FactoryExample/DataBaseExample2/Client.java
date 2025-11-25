package org.allTopics.Creational.Factory.FactoryExample.DataBaseExample2;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {

        // creating instance
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the DB you want to connect to: ");
        String dbName = sc.nextLine();

        DataBase db = DataBaseFactory.createDataBase(dbName);


    }
}
