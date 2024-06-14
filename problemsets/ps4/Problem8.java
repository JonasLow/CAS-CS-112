import java.util.Arrays;

public class Problem8 {
    public static int[] intersect(int[] setA, int[] setB) {
        int[] temp = new int[Math.min(setA.length, setB.length)];

        Sort.quickSort(setA);
        Sort.quickSort(setB);

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < setA.length && j < setB.length) {
            if (setA[i] < setB[j]) {
                i++;
            } else if (setA[i] > setB[j]) {
                j++;
            } else if (k == 0 || temp[k - 1] != setA[i]){
                temp[k++] = setA[i++];
                j++;
            } else {
                i++;
                j++;
            }
        }

        return temp;
    }

    public static void main(String[] args) {
        int[] a1 = {10, 5, 7, 5, 9, 4};
int[] a2 = {7, 5, 15, 7, 7, 9, 10};
int[] result1 = intersect(a1, a2);
System.out.println("result1: " + Arrays.toString(result1));

int[] a3 = {0, 2, -4, 6, 10, 8};
int[] a4 = {12, 0, -4, 8};
int[] result2 = intersect(a3, a4);
System.out.println("result2: " + Arrays.toString(result2));
    }
}
