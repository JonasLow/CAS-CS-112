/* 
 * Lab 3 - Greeting Program
 * 
 * DESCRIPTION
 * The code requires two inputs: first is your name and second is your age
 * After inputing your name, the terminal will greet you with "Hello <name>,
 * welcome to CS112!!!"
 * 
 * Then the terminal will ask for your input for your age
 * Then the terminal will return a customised greeting for your age for its
 * respective age range
 * 
 * name: Jonas Low
 * email: lowjonas@bu.edu
 *
 */

import java.util.*;

public class Greeting {
    public static void main(String[] args) {
        Scanner person = new Scanner(System.in);
        System.out.print("Please enter your first name: ");
        String name = person.nextLine();
        System.out.println("Hello " + name + ", welcome to CS112!!!");

        System.out.print("How old are you " + name + "? ");
        int age = person.nextInt();
        String finalGreeting = ageGreeting(name, age);
        System.out.println(finalGreeting);
        
        person.close();
    }

    public static String ageGreeting(String name, int age){
        if (age < 11) {
            return ("Wow " + name + "! You are sweet!");
        } else if (age < 18) {
            return ("Wow " + name + "! You are such a dweeb!!");
        } else if (age < 21) {
            int ageDiff = 21 - age;
            return ("Wow " + name + "! You have " + ageDiff + " more years to go!!");
        } else if (age == 21) {
            return ("Wow " + name + "! You just made it!");
        } else if (age < 30) {
            int ageDiff = 30 - age;
            return ("Wow " + name + "! You have " + ageDiff + " more years to go!!");
        } else if (age < 40) {
            return ("Wow " + name + "! You are suffering!");
        } else if (age < 50) {
            return ("Wow " + name + "! You are miserable!");
        } else {
            return ("Wow " + name + "! I am speechless!");
        }
    }
}
