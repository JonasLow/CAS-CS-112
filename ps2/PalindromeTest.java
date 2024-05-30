import java.util.*;

public class PalindromeTest {
    public static boolean isPalindrome(String s) {
        boolean isPal = false;    // assume that it is not
     
        // code to determine if the string s is a palindrome
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        String s1 = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            s1 += s.substring(i, i + 1);
        }
        
        if (s.toLowerCase().equals(s1.toLowerCase()) && s.length() > 0) {
            isPal = true;
        }
        // If the default (as above) assumes the string is not a palindrome,
        // the logic here should determine if it is and reassign the return
        // variable isPal appropriately, or vice verse.
     
        return(isPal);
    }
    

    public static int[] inputStringPalindrome() {
        System.out.println("\nWelcome to the Palindrome Program!");
        System.out.println("This checks how many of the input strings are palindromes.");

        // Declare a scanner object for user input

        Scanner userInput = new Scanner(System.in);
        int[] result = new int[2];

        System.out.print("\nType in a line of text (a String) or \"quit\" to end: ");

        // Continue to receive user input until some
        // sentinal (i.e. final) value is entered.
        // In this case, the user must enter the
        // word "quit".
        do {
            String line = userInput.nextLine();
            if (line.equals("quit")) {
            // User has specified input it over,
            // break out of the loop.
                break;
            } else {
                System.out.println("You input: " + line);
                result[0]++;
                if (isPalindrome(line)) {
                    result[1]++;
                }
                System.out.print("\nType in a line of text (a String) or \"quit\" to end: ");
            }
        } while (userInput.hasNextLine());

        System.out.println("bye!");
        userInput.close();
        return result;
    }

    /* Testing code
    public static void main(String[] args) {
        System.out.println(isPalindrome("racecar"));
        System.out.println(Arrays.toString(inputStringPalindrome()));
    }
    */
}
