
package lcs.k;

public class LCSK {
  // Function to return maximum of three integers
    public static int max(int a, int b, int c) {
        return Integer.max(Integer.max(a, b), c);
    }
 
    // Function to find length of Longest Common Subsequence of
    // sequences X[0..m-1], Y[0..n-1] and Z[0..o-1]
    public static int LCSLength(String X, String Y, String Z,
                                        int m, int n, int o)
    {
        // return if we have reached the end of either sequence
        if (m == 0 || n == 0 || o == 0) {
            return 0;
        }
 
        // if last character of X, Y and Z matches
        if (X.charAt(m - 1) == Y.charAt(n - 1) &&
                Y.charAt(n - 1) == Z.charAt(o - 1)) {
            return LCSLength(X, Y, Z, m - 1, n - 1, o - 1) + 1;
        }
 
        // else if last character of X, Y and Z don't match
        return max( LCSLength(X, Y, Z, m - 1, n, o),
                LCSLength(X, Y, Z, m, n - 1, o),
                LCSLength(X, Y, Z, m, n, o - 1));
    }
 
    // main function
    public static void main(String[] args)
    {
        String X = "ABCBDAB", Y = "BDCABA", Z = "BADACB";
 
        System.out.print("The length of LCS is " +
                LCSLength(X, Y, Z, X.length(), Y.length(), Z.length()));
    }
  
}
