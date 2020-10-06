/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lrs.pkg2;

/**
 *
 * @author Mujahid
 */
public class LRS2 {
 // Function to find the length of Longest repeated Subsequence
    // of substring X[0..n-1]
    public static int LRSLength(String X)
    {
        int n = X.length();
        
        // lookup table stores solution to already computed sub-problems
 
        // i.e. T[i][j] stores the length of LRS of substring
        // X[0..i-1] and X[0..j-1]
        int[][] T = new int[n + 1][n + 1];
 
        // fill the lookup table in bottom-up manner
        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                // if characters at index i and j matches
                // and the index is different
                if (X.charAt(i - 1) == X.charAt(j - 1) && i != j) {
                    T[i][j] = T[i - 1][j - 1] + 1;
                }
                // else if characters at index i and j are different
                else {
                    T[i][j] = Integer.max(T[i - 1][j], T[i][j - 1]);
                }
            }
        }
 
        // LRS will be last entry in the lookup table
        return T[n][n];
    }
 
    // main function
    public static void main(String[] args)
    {
        String X = "ATACTCGGA";
        
        System.out.print("Length of Longest Repeating Subsequence is " +
                LRSLength(X));
    }
}
