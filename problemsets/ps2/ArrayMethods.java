public class ArrayMethods {
    public static final String[] DAYS = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};


    public static void swapAdjacent(int[] values) {
        for (int i = 0; i < values.length - 1; i += 2) {
            int temp = values[i];
            values[i] = values[i + 1];
            values[i + 1] = temp;
        }
    }


    public static int[] copyReplace(int[] values, int oldVal, int newVal) {
        if (values == null) {
            throw new IllegalArgumentException("Input array cannot be null!");
        }

        int[] newArr = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            if (values[i] == oldVal) {
                newArr[i] = newVal;
            } else {
                newArr[i] = values[i];
            }
        }

        return newArr;
    }


    public static int maxSorted(int[] values) {
        if (values == null) {
            throw new IllegalArgumentException("The parameter is null.");
        } else if (values.length < 2) {
            return values.length;
        }
        int max = 1;
        int count = 1;
        for (int i = 0; i < values.length - 1; i++) {
            count++;
            if (values[i] > values[i + 1]) {
                count = 1;
            } else {
                if (count > max) {
                    max = count;
                }
            }
        }
        return max;
    }


    public static int getIndexOfDay(String day) {
        if (day == null) {
            return -1;
        }
        day = day.toLowerCase();
        for (int i = 0; i < DAYS.length; i++) {
            if (DAYS[i].toLowerCase().equals(day)) {
                return i;
            }
        }
        return -1;
    }


    public static int[] reverseInterchange( int[] arr1, int [] arr2 ) {
        if (arr1 == null || arr2 == null) {
            throw new IllegalArgumentException("Parameter is null!");
        }
        int minLen = 0;
        if (arr1.length <= arr2.length) {
            minLen = arr1.length;
        } else {
            minLen = arr2.length;
        }
        int[] finalArr = new int[minLen * 2];
        for (int i = 0; i < minLen; i++) {
            finalArr[2 * i] = arr1[i];
            finalArr[2 * i + 1] = arr2[arr2.length - 1 - i];
        }
        return finalArr;
    }

    /* Testing code
    public static void main(String[] args) {
        int[] a1 = {0, 2, 4, 6, 8, 10};
        ArrayMethods.swapAdjacent(a1);
        System.out.println( Arrays.toString(a1) );

        int[] a2 = {1, 2, 3, 4, 5, 6, 7};
        ArrayMethods.swapAdjacent(a2);
        System.out.println( Arrays.toString(a2) );

        int[] a3 = {2, 5, 4, 2, 7, 4, 2};
        int[] a4 = ArrayMethods.copyReplace(a3, 4, 0);
        System.out.println( Arrays.toString(a4) );
        int[] a5 = ArrayMethods.copyReplace(a3, 2, -1);
        System.out.println( Arrays.toString(a5) );
        System.out.println( Arrays.toString(a3) );

        int[] a6 = {3, 8, 6, 14, -3, 0, 14, 207, 98, 12};
        System.out.println( ArrayMethods.maxSorted(a6) );
        int[] a7 = {17, 42, 3, 5, 5, 5, 8, 4, 6, 1, 19};
        System.out.println( ArrayMethods.maxSorted(a7) );

        System.out.println( ArrayMethods.getIndexOfDay("Monday") );

        int a8[] = {1,2,3,4,5,6};
        int a9[] = {10,11,12,13};
        System.out.println( Arrays.toString( ArrayMethods.reverseInterchange(a8, a9) ) );
    }
    */
}
