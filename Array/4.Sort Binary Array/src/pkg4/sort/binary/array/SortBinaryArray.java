package pkg4.sort.binary.array;

import java.util.Arrays;

public class SortBinaryArray {
  // Function to sort binary array in linear time
    public static void sort(int[] A)
    {
        // count number of 0's
        int zeros = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                zeros++;
            }
        }
 
        // put 0's in the beginning
        int k = 0;
        while (zeros-- != 0) {
            A[k++] = 0;
        }
 
        // fill all remaining elements by 1
        while (k < A.length) {
            A[k++] = 1;
        }
    }
 
    // Sort binary array in linear time
    public static void main (String[] args)
    {
        int A[] = { 0, 0, 1, 0, 1, 1, 0, 1, 0, 0 };
 
        sort(A);
 
        // print the rearranged array
        System.out.println(Arrays.toString(A));
    }
}