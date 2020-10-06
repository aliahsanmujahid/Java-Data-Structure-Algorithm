package pkg14.shuffle.a.given.array;

import java.util.Arrays;
import java.util.Random;

public class ShuffleAGivenArray {
  // Utility function to swap two elements A[i] and A[j] in the array
    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
 
    // Function to shuffle an array A[]
    public static void shuffle(int A[])
    {
        // read array from highest index to lowest
        for (int i = A.length - 1; i >= 1; i--)
        {
            Random rand = new Random();
 
            // generate a random number j such that 0 <= j <= i
            int j = rand.nextInt(i + 1);
 
            // swap current element with randomly generated index
            swap(A, i, j);
        }
    }
 
    // main function
    public static void main (String[] args)
    {
        int[] A = { 1, 2, 3, 4, 5, 6 };
 
        shuffle(A);
 
        // print the shuffled array
        System.out.println(Arrays.toString(A));
    }
}