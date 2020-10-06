package pkg16.find.equilibrium.pkg2;

import java.util.stream.IntStream;

public class FindEquilibrium2 {
   // Optimized method to find equilibrium index of an array
    public static void equilibriumIndex(int[] A)
    {
        // total stores sum of all elements of the array
        int total = IntStream.of(A).sum();    // Java 8
    
        // right stores sum of elements of sub-array A[i+1..n)
        int right = 0;
    
        // traverse array from right to left
        for (int i = A.length - 1; i >= 0; i--)
        {
            /* i is equilibrium index if sum of elements of sub-array
               A[0..i-1] is equal to the sum of elements of sub-array
               A[i+1..n) i.e. (A[0] + A[1] + .. + A[i-1]) =
               (A[i+1] + A[i+2] + .. + A[n-1]) */
    
            // sum of elements of left sub-array A[0..i-1] is
            // (total - (A[i] + right))
            if (right == total - (A[i] + right)) {
                System.out.println("Equilibrium Index found at " + i);
            }
    
            // new right = A[i] + (A[i+1] + A[i+2] + .. + A[n-1])
            right += A[i];
        }
    }
 
    // Program to find the equilibrium index of an array
    public static void main (String[] args)
    {
        int[] A = { 0, -3, 5, -4, -2, 3, 1, 0 };
 
        equilibriumIndex(A);
    }
}