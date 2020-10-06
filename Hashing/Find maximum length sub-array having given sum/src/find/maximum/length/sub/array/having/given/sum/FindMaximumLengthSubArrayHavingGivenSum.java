
package find.maximum.length.sub.array.having.given.sum;

public class FindMaximumLengthSubArrayHavingGivenSum {
 // Naive function to find maximum length sub-array with sum S present
    // in the given array
    public static void maxLengthSubArray(int[] A, int S)
    {
        // len stores the maximum length of sub-array with sum S
        int len = 0;
 
        // stores ending index of maximum length sub-array having sum S
        int ending_index = -1;
 
        // consider all sub-arrays starting from i
        for (int i = 0; i < A.length; i++)
        {
            int sum = 0;
 
            // consider all sub-arrays ending at j
            for (int j = i; j < A.length; j++)
            {
                // sum of elements in current sub-array
                sum += A[j];
                System.out.println("--["+sum);
                        
                // if we have found a sub-array with sum S
                if (sum == S)
                {
                    // update length & ending index of max length subarray
                    if (len < j - i + 1)
                    {
                        len =  j - i + 1;
                        System.out.println("--["+len);
                        ending_index = j;
                        System.out.println("--["+j);
                    }
                }
            }
        }
 
        // print the sub-array
        System.out.println("[" + (ending_index - len + 1) 
                            + ", " + ending_index + "]");
    }
 
    // main function
    public static void main (String[] args)
    {
        int[] A = { 5, 6, -5, 5, 3, 5, 3, -2, 0 };
        int sum = 8;
 
        maxLengthSubArray(A, sum);
    }
}
