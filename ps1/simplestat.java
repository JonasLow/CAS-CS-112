import java.util.*;

public class simplestat {

    // Method to display user options.
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

    // Method to find the largest number
    public static int findLargest(int x, int y, int z) {
        if (y >= x && y >= z) {
            return y;
        } else if (x >= y && x >= z) {
            return x;
        } else {
            return z;
        }
    }

    // Method to compute the sum
    public static int computeSum(int x, int y, int z) {
        return x + y + z;
    }

    // Method to compute the range
    public static int computeRange(int x, int y, int z) {
        int largest = findLargest(x, y, z);
        int smallest = x;
        if (y <= x && y <= z) {
            smallest = y;
        } else if (z <= x && z <= y) {
            smallest = z;
        }
        return largest - smallest;
    }

    // Method to compute the average
    public static double computeAverage(int x, int y, int z) {
        int total = computeSum(x, y, z);
        return total / 3.0;
    }

    // Method to print numbers in ascending order
    public static String printAscending(int x, int y, int z) {
        int largest = findLargest(x, y, z);
        int smallest = x;
        if (y <= x && y <= z) {
            smallest = y;
        } else if (z <= x && z <= y) {
            smallest = z;
        }

        int middle = x + y + z - largest - smallest;
        return "The numbers in ascending order are: " + smallest + " " + middle + " " + largest;
    }

    // Program execution begins with this method.
    public static void main(String[] args) {
        System.out.println("Welcome to my program\nLet's do some math!");
        Scanner scan = new Scanner(System.in);

        // Variable declarations
        int n1 = 0;
        int n2 = 0;
        int n3 = 0;
        boolean initial = false;
        boolean moreInput = true;

        // Control loop
        while (moreInput) {
            printMenu();
            System.out.print("Enter your choice: ");
            int option = -1;
            try {
                option = scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between 0 and 6.");
                scan.next(); // Clear the invalid input
                continue;
            }

            switch (option) {
                case 0:
                    System.out.print("Enter the first integer: ");
                    n1 = scan.nextInt();
                    System.out.print("Enter the second integer: ");
                    n2 = scan.nextInt();
                    System.out.print("Enter the third integer: ");
                    n3 = scan.nextInt();
                    System.out.println("Numbers entered are: " + n1 + " " + n2 + " " + n3);
                    initial = true;
                    break;
                case 1:
                    if (!initial) {
                        System.out.println("Cannot compute, numbers have not been entered.");
                    } else {
                        int largest = findLargest(n1, n2, n3);
                        System.out.println("Largest number entered is: " + largest);
                    }
                    break;
                case 2:
                    if (!initial) {
                        System.out.println("Cannot compute, numbers have not been entered.");
                    } else {
                        int sum = computeSum(n1, n2, n3);
                        System.out.println("Sum is: " + sum);
                    }
                    break;
                case 3:
                    if (!initial) {
                        System.out.println("Cannot compute, numbers have not been entered.");
                    } else {
                        int range = computeRange(n1, n2, n3);
                        System.out.println("Range is: " + range);
                    }
                    break;
                case 4:
                    if (!initial) {
                        System.out.println("Cannot compute, numbers have not been entered.");
                    } else {
                        double average = computeAverage(n1, n2, n3);
                        System.out.println("Average is: " + average);
                    }
                    break;
                case 5:
                    if (!initial) {
                        System.out.println("Cannot compute, numbers have not been entered.");
                    } else {
                        String ascending = printAscending(n1, n2, n3);
                        System.out.println(ascending);
                    }
                    break;
                case 6:
                    moreInput = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            if (initial && moreInput) {
                System.out.println("");
                System.out.println("Numbers are: " + n1 + " " + n2 + " " + n3);
            }
        }

        System.out.println("Have a nice day!");
        scan.close();
    }
}
