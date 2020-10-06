
package lis.maximum.sum.pkg2;

import java.util.Arrays;

/**
 *
 * @author Mujahid
 */
public class LISMAXIMUMSUM2 {

  // Iterative function to find maximum sum of an increasing sub-sequence
    public static int MSIS(int[] A)
    {
        // array to store sub-problem solution. sum[i] stores the maximum
        // sum of the increasing sub-sequence that ends with A[i]
        int[] sum = new int[A.length];
 
        // base case
        sum[0] = A[0];
 
        // start from second element in the array
        for (int i = 1; i < A.length; i++)
        {
            // do for each element in sub-array A[0..i-1]
            for (int j = 0; j < i; j++)
            {
                // find increasing sub-sequence with maximum sum that ends
                // with A[j] where A[j] is less than the current element A[i]
 
                if (sum[i] < sum[j] && A[i] > A[j]) {
                    sum[i] = sum[j];
                }
            }
 
            // include A[i] in MSIS
            sum[i] += A[i];
        }
 
        // find increasing sub-sequence with maximum sum
        return Arrays.stream(sum).max().getAsInt();
    }
 
    // main function
    public static void main(String[] args)
    {
        int[] A = { 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11 };
 
        System.out.print("Maximum sum of increasing subsequence is " +
                        MSIS(A));
    }
}
