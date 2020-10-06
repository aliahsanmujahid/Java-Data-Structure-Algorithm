
package lcs.k.pkg2;

import java.util.HashMap;
import java.util.Map;

public class LCSK2 {
public static int max(int a, int b, int c)
    {
        return Integer.max(Integer.max(a, b), c);
    }
 
    // Function to find length of Longest Common Subsequence of
    // sequences X[0..m-1], Y[0..n-1] and Z[0..o-1]
    public static int LCSLength(String X, String Y, String Z, int m, int n,
                                int o, Map<String, Integer> lookup)
    {
        // return if we have reached the end of either sequence
        if (m == 0 || n == 0 || o == 0)
            return 0;
 
        // construct a unique map key from dynamic elements of the input
        String key = m + "|" + n + "|" + o;
 
        // if sub-problem is seen for the first time, solve it and
        // store its result in a map
        if (!lookup.containsKey(key))
        {
            // if last character of X, Y and Z matches
            if (X.charAt(m - 1) == Y.charAt(n - 1) &&
                    Y.charAt(n - 1) == Z.charAt(o - 1)) {
                int lcs = LCSLength(X, Y, Z, m - 1, n - 1, o - 1, lookup);
                lookup.put(key, lcs + 1);
            }
            else {
                // else if last character of X, Y and Z don't match
                lookup.put(key, max(LCSLength(X, Y, Z, m - 1, n, o, lookup),
                                    LCSLength(X, Y, Z, m, n - 1, o, lookup),
                                    LCSLength(X, Y, Z, m, n, o - 1, lookup)));
            }
        }
 
        // return the sub-problem solution from the map
        return lookup.get(key);
    }
 
    // main function
    public static void main(String[] args)
    {
        String X = "ABCBDAB", Y = "BDCABA", Z = "BADACB";
 
        // create a map to store solutions of subproblems
        Map<String, Integer> lookup = new HashMap<>();
 
        System.out.print("The length of LCS is " +
            LCSLength(X, Y, Z, X.length(), Y.length(), Z.length(), lookup));
    }
}
