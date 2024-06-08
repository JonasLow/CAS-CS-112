public class StringRecursion {
    public static void printReverse(String str) {
        if (str.length() == 1) {
            System.out.println(str);
        }

        if (str.length() > 1 && str != null) {
            System.out.print(str.charAt(str.length() - 1));
            printReverse(str.substring(0, str.length() - 1));
        }
    }


    public static String trim(String str) {
        if (str == null) {
            return null;
        } else if (str.length() == 0) {
            return "";
        } else {
            if (str.charAt(0) == ' ') {
                return trim(str.substring(1, str.length()));
            }
            
            if (str.charAt(str.length() - 1) == ' ') {
                return trim(str.substring(0, str.length() - 1));
            }
            
            return str;
        }
    }


    public static int find(char ch, String str) {
        if (str == null) {
            return -1;
        }

        if (str.length() == 0) {
            return -1;
        }

        if (str.charAt(0) == ch) {
            return 0;
        } 
        
        int result = find(ch, str.substring(1));
        if (result != -1) {
            return 1 + result;
        } else {
            return -1;
        }
    }


    public static String weave(String str1, String str2) {
        if (str1 == null) {
            throw new IllegalArgumentException();
        }
        if (str2 == null) {
            throw new IllegalArgumentException();
        }
        
        if (str1.equals("")) {
            return str2;
        } else if (str2.equals("")) {
            return str1;
        } else {
            return str1.charAt(0) + "" + str2.charAt(0) + "" + weave(str1.substring(1), str2.substring(1));
        }
    }

    // Literally works the same way as the find method
    public static int indexOf(char ch, String str) {
        if (str == null) {
            return -1;
        }

        if (str.length() == 0) {
            return -1;
        }

        if (str.charAt(0) == ch) {
            return 0;
        } 
        
        int result = find(ch, str.substring(1));
        if (result != -1) {
            return 1 + result;
        } else {
            return -1;
        }
    }

    /* 
    public static void main(String[] args) {
        printReverse("help");
        System.out.println(trim(" hello world      "));
        System.out.println(find('b', "Rabbit"));
        System.out.println(find('P', "Rabbit"));
        System.out.println( weave("aaaa", "bbbb") );
        System.out.println( weave("hello", "world") );
        System.out.println(weave("recurse", "NOW"));
        System.out.println(weave("hello", ""));
        System.out.println(weave("",""));
        System.out.println( indexOf('b', "Rabbit") ); 
        System.out.println( indexOf('P', "Rabbit") );
    }
    */
}
