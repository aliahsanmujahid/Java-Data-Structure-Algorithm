package maximum.sum.increasing.subsequence;

import java.util.Arrays;

public class MaximumSumIncreasingSubsequence {

    static int maxSumIS(int A[], int n) 
    { 
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
     public static void main(String args[]) 
    { 
        int arr[] = new int[]{8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11}; 
        int n = arr.length; 
        System.out.println("Sum of maximum sum "+ 
                            "increasing subsequence is "+ 
                              maxSumIS(arr, n)); 
    } 
}
