/*
 * Problem Set 1
 * 
 * A simple interactive program that performs operations 
 * on a set of three integers.
 *
 * CS112
 *
 */

 import java.util.*;

 /*
  * Program Class Defintion
  */
 public class SimpleStats {
 
     /*
      * printMenu()
      *
      * Method to display user options.
      */
     public static void printMenu() {
         System.out.println("(0) Enter new numbers");
         System.out.println("(1) Find the largest");
         System.out.println("(2) Compute the sum");
         System.out.println("(3) Compute the range (largest - smallest)");
         System.out.println("(4) Compute the average");
         System.out.println("(5) Print the numbers in ascending order");
         System.out.println("(6) Quit");
         System.out.println();
     }
     
     /*** PUT YOUR SEPARATE HELPER METHODS FOR OPTIONS 1-5 HERE ***/
     
     
     /*
      * main()
      *
      * Program execution begins with this method.
      */
     public static void main(String[] args) {
         Scanner scan = new Scanner(System.in);        
 
         // variable declarations 
         int n1;
         int n2;
         int n3;
 
         boolean more_input = true;
         
     /*
       * Control loop
       */
         do {
             
             printMenu();
             
             /*
          * Write the conditional logic that processes the possible
          * menu choices.
              */
             
         } while (more_input);
         
         System.out.println("Have a nice day!");
     }
 }