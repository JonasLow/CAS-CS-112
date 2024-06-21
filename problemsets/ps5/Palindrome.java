/*
 * Palindrome.java
 */
   
public class Palindrome {
    // Add your definition of isPal here
    public static boolean isPal(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }

        if (str.length() < 2) {
            return true;
        }
        
        str = str.toLowerCase();
        ArrayStack <Character> stack = new ArrayStack<>(str.length());
        ArrayQueue <Character> queue = new ArrayQueue<>(str.length());

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                stack.push(str.charAt(i));
                queue.insert(str.charAt(i));
            }
        }

        while (!stack.isEmpty() && !queue.isEmpty()) {
            if (stack.pop() != queue.remove()) {
                return false;
            }
        }

        return true;
    }
    
    public static void main(String[] args) {
        System.out.println("--- Testing method isPal ---");
        System.out.println();

        System.out.println("(0) Testing on \"A man, a plan, a canal, Panama!\"");
        try {
            boolean results = isPal("A man, a plan, a canal, Panama!");
            System.out.println("actual results:");
            System.out.println(results);
            System.out.println("expected results:");
            System.out.println("true");
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(results == true);
        } catch (Exception e) {
            System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        }
        
        System.out.println();    // include a blank line between tests
        
        /*
         * Add five more unit tests that test a variety of different
         * cases. Follow the same format that we have used above.
         */

        System.out.println("(1) Testing on \"racecar\"");
        // Test 1: Simple palindrome without any punctuation or spaces
        try {
            String test1 = "racecar";
            boolean result1 = isPal(test1);
            boolean expected1 = true;
            System.out.println("Test 1: Checking if \"" + test1 + "\" is a palindrome.");
            System.out.println("Actual: " + result1);
            System.out.println("Expected: " + expected1);
            System.out.println("Test 1 " + (result1 == expected1 ? "PASSED" : "FAILED"));
        } catch (Exception e) {
            System.out.println("Test 1 FAILED due to exception: " + e.getMessage());
        }
        System.out.println();

        System.out.println("(2) Testing on \"hello\"");
        // Test 2: Non-palindrome string
        try {
            String test2 = "hello";
            boolean result2 = isPal(test2);
            boolean expected2 = true;
            System.out.println("Test 2: Checking if \"" + test2 + "\" is a palindrome.");
            System.out.println("Actual: " + result2);
            System.out.println("Expected: " + expected2);
            System.out.println("Test 2 " + (result2 == expected2 ? "PASSED" : "FAILED"));
        } catch (Exception e) {
            System.out.println("Test 1 FAILED due to exception: " + e.getMessage());
        }
        System.out.println();

        System.out.println("(3) Testing on \"\"");
        // Test 3: Empty String
        try {
            String test3 = "";
            boolean result3 = isPal(test3);
            boolean expected3 = true;
            System.out.println("Test 3: Checking if \"" + test3 + "\" is a palindrome.");
            System.out.println("Actual: " + result3);
            System.out.println("Expected: " + expected3);
            System.out.println("Test 3 " + (result3 == expected3 ? "PASSED" : "FAILED"));
        } catch (Exception e) {
            System.out.println("Test 3 FAILED due to exception: " + e.getMessage());
        }
        System.out.println();

        System.out.println("(4) Testing on \"X\"");
        // Test 4: Single Character
        try {
            String test4 = "X";
            boolean result4 = isPal(test4);
            boolean expected4 = true;
            System.out.println("Test 4: Checking if \"" + test4 + "\" is a palindrome.");
            System.out.println("Actual: " + result4);
            System.out.println("Expected: " + expected4);
            System.out.println("Test 4 " + (result4 == expected4 ? "PASSED" : "FAILED"));
        } catch (Exception e) {
            System.out.println("Test 4 FAILED due to exception: " + e.getMessage());
        }
        System.out.println();

        System.out.println("(5) Testing on null string");
        // Test 5: Simple palindrome without any punctuation or spaces
        try {
            String test5 = null;
            boolean result5 = isPal(test5);
            boolean expected5 = true;
            System.out.println("Test 5: Checking if \"" + test5 + "\" is a palindrome.");
            System.out.println("Actual: " + result5);
            System.out.println("Expected: " + expected5);
            System.out.println("Test 5 " + (result5 == expected5 ? "PASSED" : "FAILED"));
        } catch (Exception e) {
            System.out.println("Test 5 FAILED due to exception: " + e.getMessage());
        }
        System.out.println();
    }
}