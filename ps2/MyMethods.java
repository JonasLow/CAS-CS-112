public class MyMethods {
    public static void printDecreasing(String str) {
        for (int i = str.length(); i > 0; i--){
            System.out.println(str.substring(0, i));
        }
    }


    public static String firstAndLast(String str) {
        if (str.length() < 2) {
            return str;
        } else {
        return str.substring(0, 1) + str.substring(str.length() -1, str.length());
        }
    }


    public static int lastIndexOf(String str, char c) {
        for (int j = str.length() - 1; j >= 0; j--) {
            if (str.charAt(j) == c) {
                return j;
            }
        }
        return -1;
    }


    public static String repeat(String str, int n) {
        String returnString = "";
        for (int i = 0; i < n; i++) {
            returnString += str;
        }
        return returnString;
    }

    /* Testing code 
    public static void main(String[] args) {
        printDecreasing("method");
        
        System.out.println(firstAndLast("Boston"));
        System.out.println(firstAndLast("University"));
        System.out.println(firstAndLast("a"));

        System.out.println(lastIndexOf("Boston", 'o'));
        System.out.println(lastIndexOf("banana", 'a'));
        System.out.println(lastIndexOf("banana", 'b'));
        System.out.println(lastIndexOf("banana", 'x'));

        System.out.println(repeat("Java", 3));
        System.out.println(repeat("oh!", 7));
    }
    */
}
