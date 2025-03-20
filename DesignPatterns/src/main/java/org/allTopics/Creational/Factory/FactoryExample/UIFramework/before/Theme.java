package org.allTopics.Creational.Factory.FactoryExample.UIFramework.before;

public abstract class Theme {
    String name;
    String primaryColor;
    String authorName;

    public abstract Button createButton();
    public abstract Menu createMenu();
    public abstract DropDown createDropDown();

    public abstract boolean changePrimaryColor();
}
