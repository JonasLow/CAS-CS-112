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
     public static int method1(int x, int y, int z){
         if (y >= x && y >= z) {
             return y;
         } else if (x >= y && x >= z) {
             return x;
         } else {
             return z;
         }
     }


     public static int method2(int x, int y, int z) {
         return x + y + z;
     }


     public static int method3(int x, int y, int z) {
         int largest = method1(x, y, z);
         int smallest = z;
         if (y <= x && y <= z) {
             smallest = y;
         } else if (x <= y && x <= z) {
             smallest = x;
         }
         return largest - smallest;
     }


     public static double method4(int x, int y, int z) {
         int total = method2(x, y, z);
         return total / 3.0;
     }


     public static String method5(int x, int y, int z) {
         int L = method1(x, y, z);
         int S = z;
         if (y <= x && y <= z) {
             S = y;
         } else if (x <= y && x <= z) {
             S = x;
         }

         int M = z;
         if (y <= x && y >= z) {
            M = y;
         } else if (x <= y && x >= z) {
             M = x;
         }

         return "The numbers in ascending order are: " + S + " " + M + " " + L;
     }
     
     /*
      * main()
      *
      * Program execution begins with this method.
      */
     public static void main(String[] args) {
         System.out.println("Welcome to my program/nLet's do some math!");
         Scanner scan = new Scanner(System.in);        
 
         // variable declarations
         int n1 = 0;
         int n2 = 0;
         int n3 = 0;
         boolean initial = false;
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
             System.out.print("Enter your choice: ");
             int option = scan.nextInt();
            
             if (option == 0) {
                System.out.print("Enter the first integer: "); 
                n1 = scan.nextInt();
                System.out.print("Enter the second integer: ");
                n2 = scan.nextInt();
                System.out.print("Enter the third integer: ");
                n3 = scan.nextInt();
                System.out.println("Numbers entered are: " + n1 +" "+ n2 +" "+ n3);
                initial = true;
             } else if (!initial) {
                System.out.println("Cannot compute, numbers have not been entered.");
                System.out.println("");
             } else if (option == 1) {
                int big = method1(n1, n2, n3);
                System.out.println("Largest number entered is: " + big);
             } else if (option == 2) {
                int summ = method2(n1, n2, n3);
                System.out.println("Sum is: " + summ);
             } else if (option == 3) {
                int range = method3(n2, n3, n1);
                System.out.println("Range is: " + range);
             } else if (option == 4) {
                double avg = method4(n2, n3, n1);
                System.out.println("Average is: " + avg);
             } else if (option == 5) {
                String ascendo = method5(n2, n3, n1);
                System.out.println("Ascending is: " + ascendo);
             } else if (option == 6) {
                more_input = false;
             } else {
                System.out.println("Invalid choice. Please try again.");
             }

             if (initial && more_input) {
                System.out.println("");
                System.out.println("Numbers are: " + n1 +" "+ n2 +" "+ n3);
             }
         } while (more_input);
         
         System.out.println("Have a nice day!");
         scan.close();
     }
 }