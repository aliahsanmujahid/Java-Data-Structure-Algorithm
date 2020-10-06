/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lrs;

/**
 *
 * @author Mujahid
 */
public class LRS {
 // Function to find the length of Longest repeated Subsequence
    // of substring X[0..m-1] and X[0..n-1]
    public static int LRSLength(String X, int m, int n)
    {
        // return if we have reached the end of either string
        if (m == 0 || n == 0) {
            return 0;
        }
 
        // if characters at index m and n matches and index is different
        if (X.charAt(m - 1) == X.charAt(n - 1) && m != n) {
            return LRSLength(X, m - 1, n - 1) + 1;
        }
 
        // else if characters at index m and n don't match
        return Integer.max(LRSLength(X, m, n - 1),
                LRSLength(X, m - 1, n));
    }
 
    // main function
    public static void main(String[] args)
    {
        String X = "ATACTCGGA";
        int m = X.length();
 
        System.out.print("Length of Longest Repeating Subsequence is " +
                LRSLength(X, m, m));
    }
}