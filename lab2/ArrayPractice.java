import java.util.*;

public class ArrayPractice {
    public static void main(String[] args) {
        int[] a = {2, 4, 6, 8};
        System.out.println(a);
        System.out.println(Arrays.toString(a));

        int[] a1 = {1, 2, 3, 4};
        int[] a2 = {1, 2, 3, 4};
        System.out.println(a1 == a2);
        System.out.println(a1.equals(a2));

        square(a1);
        System.out.println(Arrays.toString(a1));

        int[] a3 = {1, 2, 3, 4, 5, 6};
        System.out.println( shiftLeft(a3) );
        System.out.println( Arrays.toString(a3));

        int[] a4 = {1, 2, 3, 2, 2, 6};
        int numReplaced;
        // first test
        numReplaced = replace(a4, 2, 9);
        System.out.println( Arrays.toString(a4) );
        System.out.println( "numReplaced = " + numReplaced );
        // second test
        numReplaced = replace(a4, 2, 9);
        System.out.println( Arrays.toString(a4) );
        System.out.println( "numReplaced = " + numReplaced);

        int[] a5 = {1, 2, 3, 4, 5};
        int[] a6 = {6, 7, 8, 9, 10};
        int[] a7 = interleave(a5, a6);
        System.out.println( Arrays.toString(a7) );

        int[] a8 = {1, 2, 3, 4, 5};
        int[] a9 = {5, 4, 3, 2, 1};
        System.out.println( isMirror(a8, a9) );
        int[] a10 = {1, 4, 5, 2, 1};
        System.out.println( isMirror(a8, a10) );    

        String[] s1 = { "abc", "def", "ghi" };
        String[] s2 = new String[3];
        s2[0] = new String("ghi");
        s2[1] = new String("def");
        s2[2] = new String("abc");

        System.out.println( isStringMirror(s1, s2) );
    }


    public static void square(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] *= arr[i];
        }
    }


    public static int shiftLeft(int[] arr) {
        int output = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = 0;
        return output;
    }


    public static int replace(int[] arr, int val1, int val2) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val1) {
                count += 1;
                arr[i] = val2;
            }
        }
        return count;
    }


    public static int[] interleave(int[] arr1, int[] arr2) {
        int i = 0;
        int j = 0;
        int[] finalArr = new int[arr1.length + arr2.length];
        while (i < arr1.length && i < arr2.length) {
            finalArr[i + j] = arr1[i];
            j++;
            finalArr[i + j] = arr2[i];
            i++;
        }
        if (i == arr1.length && i < arr2.length) {
            for (int k = i; k < arr2.length; k++) {
                finalArr[k + j] = arr2[k];
            }
        } else if (i == arr2.length && i < arr1.length) {
            for (int k = i; k < arr1.length; k++) {
                finalArr[k + j] = arr1[k];
            }
        }
        return finalArr;
    }


    public static boolean isMirror(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[arr2.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }


    public static boolean isStringMirror(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        } 
        String[] copied1 = new String[arr1.length];
        for (int i = arr1.length - 1; i > -1; i--) {
            copied1[arr1.length - 1 - i] = arr1[i];
        }
        if (Arrays.deepEquals(copied1, arr2)) {
            return true;
        }
        return false;
    }
}
