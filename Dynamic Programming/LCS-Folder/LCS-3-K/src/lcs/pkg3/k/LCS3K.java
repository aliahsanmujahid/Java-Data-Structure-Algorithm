/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lcs.pkg3.k;

/**
 *
 * @author Mujahid
 */
public class LCS3K {
  // Function to return maximum of three integers
    public static int max(int a, int b, int c)
    {
        return Integer.max(Integer.max(a, b), c);
    }
 
    // Function to find length of Longest Common Subsequence of
    // sequences X[0..m-1], Y[0..n-1] and Z[0..o-1]
    public static int LCSLength(String X, String Y, String Z)
    {
        int m = X.length(), n = Y.length(), o = Z.length();
 
        // lookup table stores solution to already computed sub-problems
        // i.e. T[i][j][k] stores the length of LCS of substring
        // X[0..i-1], Y[0..j-1], Z[0..k-1]
        int[][][] T = new int[m + 1][n + 1][o + 1];
 
        // fill the lookup table in bottom-up manner
        for (int i = 1; i <= m; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                for (int k = 1; k <= o; k++)
                {
                    // if current character of X, Y and Z matches
                    if (X.charAt(i - 1) == Y.charAt(j - 1)
                            && Y.charAt(j - 1) == Z.charAt(k - 1)) {
                        T[i][j][k] = T[i - 1][j - 1][k - 1] + 1;
                    }
                    // else if current character of X, Y and Z don't match
                    else {
                        T[i][j][k] = max(T[i - 1][j][k],
                                        T[i][j - 1][k],
                                        T[i][j][k - 1]);
                    }
                }
            }
        }
 
        // LCS will be last entry in the lookup table
        return T[m][n][o];
    }
 
    // main function
    public static void main(String[] args)
    {
        String X = "ABCBDAB", Y = "BDCABA", Z = "BADACB";
 
        System.out.print("The length of LCS is " + LCSLength(X, Y, Z));
    }
}
