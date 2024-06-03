/*
 * Ladder.java
 * 
 * A program that takes 2 inputs: height (in feet) and angle (in degrees).
 * It converts the angle to radians using the built in Math library.
 * Then, it calculates the reqired length of the ladder as a real number using the sine rule.
 * Finally, the terminal prints the required length in feet only, yards only, and feet and yard. 
 *  
 * completed by: Low Zhe Kai Jonas (lowjonas@bu.edu)
 * partner (if any): NIL
 */ 

import java.util.*;

public class Ladder {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.print("Height (nearest foot): ");
        int height = myObj.nextInt();
        System.out.print("Angle in degrees (nearest degree): ");
        int angle = myObj.nextInt();
        
        double radians = Math.PI * angle / 180;
        double length = height / Math.sin(radians);
        System.out.println("The required length is:");
        System.out.println(length + " feet");

        double lengthYards = length / 3;
        System.out.println(lengthYards + " yards");
        System.out.println((int) lengthYards + " yards and " + (length - (int) lengthYards * 3) + " feet");

        myObj.close();
    }
}
