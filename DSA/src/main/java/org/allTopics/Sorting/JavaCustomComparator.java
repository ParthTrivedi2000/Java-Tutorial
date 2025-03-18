package org.allTopics.Sorting;

import java.lang.*;
import java.util.*;

public class JavaCustomComparator {
    public static void main(String[] args)
    {
        ArrayList<Student> ar = new ArrayList<Student>();

        ar.add(new Student(111, "Mayank", "london"));
        ar.add(new Student(131, "Anshul", "nyc"));
        ar.add(new Student(121, "Solanki", "jaipur"));
        ar.add(new Student(101, "Aggarwal", "Hongkong"));

        System.out.println("Unsorted");

        for (int i = 0; i < ar.size(); i++)
            System.out.println(ar.get(i));

        // Sorting student entries by roll number
        Collections.sort(ar, new Sortbyroll());

        System.out.println("\nSorted by rollno");

        for (int i = 0; i < ar.size(); i++)
            System.out.println(ar.get(i));

        // Sorting student entries by name
        Collections.sort(ar, new Sortbyname());

        System.out.println("\nSorted by name");

        for (int i = 0; i < ar.size(); i++)
            System.out.println(ar.get(i));
    }
}



// A class to represent a Student
class Student {

    // Attributes of a stude
    int rollno;
    String name, address;

    // Constructor
    public Student(int rollno, String name, String address)
    {
        this.rollno = rollno;
        this.name = name;
        this.address = address;
    }

    // Method of Student class
    // To print student details in main()
    public String toString()
    {

        // Returning attributes of Student
        return this.rollno + " " + this.name + " "
                + this.address;
    }
}

// Helper class to sort by roll no implementing Comparator interface
class Sortbyroll implements Comparator<Student> {

    // Sorting in ascending order of roll number
    public int compare(Student a, Student b)
    {

        if(a.rollno <b.rollno)return -1;
        else if(a.rollno>b.rollno)return 1;
        else return 0;
    }
}

// Helper class to sort by name implementing Comparator interface
class Sortbyname implements Comparator<Student> {

    // Method
    // Sorting in ascending order of name
    public int compare(Student a, Student b)
    {

        return a.name.compareTo(b.name);
        //compareTo function is used to compare two strings lexicographically
		 /*
		 If the first string is lexicographically greater than the second string,
		 it returns a positive number (difference of character value).
		 If the first string is less than the second string lexicographically,
		 it returns a negative number, and if the first string is lexicographically
		 equal to the second string, it returns 0.
		 */

    }
}

