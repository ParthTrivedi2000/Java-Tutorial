package org.allTopics.Creational.Factory.Code;

import java.awt.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        // Taking input from user
        String platformName = scn.nextLine();

        // Without Factory
        /*
        if(platformName.equals("Android")){
            return new Android();
        }
        else if(platformName.equals("Windows")) return new Windows();
        else if(platformName.equals("IOS")) return new IOS();


        - So here we need different objects based on the user input. So we will create seperate
        PlatformFactory class to provide the objects which is known as Simple Factory Pattern.
         */

    }
}
