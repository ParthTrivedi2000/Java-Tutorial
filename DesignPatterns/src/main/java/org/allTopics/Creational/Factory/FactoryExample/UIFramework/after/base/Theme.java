package org.allTopics.Creational.Factory.FactoryExample.UIFramework.after.base;

public abstract class Theme {
    String name;
    String primaryColor;
    String authorName;

    // before implementing abstract factory pattern, these all factory pattern stays here. but then we have created
    // separate ThemeComponentFactory class/interface which contains all the factory methods only.

    // public abstract Button createButton();
    // public abstract Menu createMenu();
    // public abstract DropDown createDropDown();


    // And add only 1 method:- createThemComponentFactory() :-
    public abstract ThemeComponentFactory createThemeComponentFactory();

    public abstract boolean changePrimaryColor();
}
