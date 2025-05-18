package org.allTopics.Creational.Factory.FactoryExample.UIFramework.after;

/*
Code structure:-
- we are having all the common abstract class/interfaces which will be implemented by all the corresponding types are
present inside the base package.
- And separate folders are created for all the different types.
 */

import org.allTopics.Creational.Factory.FactoryExample.UIFramework.after.base.*;

import java.util.Scanner;


/*
Now below you can see, we are having THEME_NAME variable. (currently it is kept as static final but else think for example
we are using Scanner class to ask user to enter the theme_name and then on basis of that we need to return the Themes
and corresponding component.

So in this case, we can use Simple Factory. which will return type of Theme Object.


public class Client {
    public static final String THEME_NAME = "ios";
    public static void main(String[] args) {

        Theme theme;

        if(THEME_NAME.equals("ios")) {
            theme = new IOSUITheme();
        }
        else if(THEME_NAME.equals("material")) {
            theme = new MaterialUITheme();
        }
        else {
            throw new Error("Unsupported theme: " + THEME_NAME);
        }
    }
}

 */


/*
- So just create the ThemeFactory class inside the base package since it is generic. And delegate the responsibility
to identify which kind of theme object to return.
- Make sure to return Theme object as return type (not specific concrete implementation class as return type).
 */

public class Client{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter which Theme you want to use: ");
        String themeName = scanner.nextLine();

        // creating theme by implementing Simple Factory Pattern via user ip string.
        Theme theme = ThemeFactory.createThemeByPlatformName(themeName);


        // getting themeFactory to generate corresponding UI components. And we have implemented
        // Factory method design pattern to get it (bec see the Theme class, it is having only 1 factory
        // method & main thing is wo factory method present h Theme class k ander bt it is not returning
        // Theme type object instead it is used to return some different type of object. So this is
        // the example of implementation of Factory Method Design Pattern.
        ThemeComponentFactory themeComponentFactory = theme.createThemeComponentFactory();

        // And getting the corresponding separate UI Components. And we have implemented the
        // Abstract Factory Method Design Pattern to get the corresponding UI components.
        Button myButton = themeComponentFactory.createButton();
        Menu myMenu = themeComponentFactory.createMenu();
        DropDown myDropDown = themeComponentFactory.createDropDown();
    }
}


/*
- Now this is actually very well structured, loosely coupled, & modular code.
- Because now if you are having requirement at high level to add new Theme called AndroidUITheme, then also simple
you can create separate folder called Android, & create all the components present inside the IOS/MaterialUI folder.

Homework for me:-
- Add the new theme AndroidUI, in the current UI Framework.

 */