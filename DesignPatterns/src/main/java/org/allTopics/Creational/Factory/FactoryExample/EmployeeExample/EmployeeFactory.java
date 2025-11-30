package org.allTopics.Creational.Factory.FactoryExample.EmployeeExample;

public class EmployeeFactory {
    public Employee getEmployee(String str){
        if(str.trim().equalsIgnoreCase("ANDROID DEVELOPER")){
            return new AndroidDeveloper();
        }

        else if(str.trim().equalsIgnoreCase("WEB DEVELOPER")){
            return new WebDeveloper();
        }

        return null;
    }
}
