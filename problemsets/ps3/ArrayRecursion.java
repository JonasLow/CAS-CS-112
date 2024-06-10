public class ArrayRecursion {
    public static boolean search(Object item, Object[] arr, int start) {
        if (arr == null || start < 0) {
            throw new IllegalArgumentException();
        }
    
        if (start >= arr.length) {
            return false;
        }

        if (arr[start].equals(item)) {
            return true;
        }
        return search(item, arr, start + 1);
    }
    


    public static String reverseArrayToString(Object[] arr, int index) {
        if (arr == null) {
            return "";
        }
        
        if (arr.length < index) {
            return "";
        }

        if (index == 0 && arr.length == 0) {
            return "[]";
        }

        if (index == arr.length - 1 && index != 0) {
            return "[" + arr[index];
        } else if (index == 0) {
            if (arr.length == 1) {
                return "[" + arr[index] + "]";
            } else{
                return reverseArrayToString(arr, index + 1) + ", " + arr[index] + "]";
            }
        }
        return reverseArrayToString(arr, index + 1) + ", " + arr[index];
    }
    
    /*
    public static void main(String[] args) {

        String a[] = { "abc", "def", "ghi", "klm", "nop", "qrs" };
        System.out.println(search("ghi", a, 0));
        System.out.println(search("xyz", a, 0));
        System.out.println(reverseArrayToString(a, 0));

        Object[] intArray = {1, 2, 3, 4, 5};
        System.out.println(search(3, intArray, 0));
        System.out.println(search("5", intArray, 0));
        System.out.println(reverseArrayToString(intArray, 0)); 

        Object[] mixedArray = {"hello", 42, 'A', 3.14};
        System.out.println(search('A', mixedArray, 0));
        System.out.println(search("42", mixedArray, 0));
        System.out.println(reverseArrayToString(mixedArray, 0)); 
        // Testing with empty array
        Object[] emptyArray = {};
        System.out.println(search("ghi", emptyArray, 0));
        System.out.println(reverseArrayToString(emptyArray, 0)); 

        // Testing with null array
        Object[] nullArray = null;
        // System.out.println(search("ghi", nullArray, 0));
        System.out.println(reverseArrayToString(nullArray, 0)); 
    }
    */
}
