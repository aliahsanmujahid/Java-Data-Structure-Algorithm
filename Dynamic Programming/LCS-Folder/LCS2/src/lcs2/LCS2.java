
package lcs2;

import java.util.HashMap;
import java.util.Map;

public class LCS2 {
 public static int LCSLength(String X, String Y, int m, int n,
                                Map<String, Integer> lookup)
    {
        // return if we have reached the end of either string
        if (m == 0 || n == 0)
            return 0;
 
        // construct a unique map key from dynamic elements of the input
        String key = m + "|" + n;
 
        // if sub-problem is seen for the first time, solve it and
        // store its result in a map
        if (!lookup.containsKey(key))
        {
            // if last character of X and Y matches
            if (X.charAt(m - 1) == Y.charAt(n - 1)) {
                lookup.put(key, LCSLength(X, Y, m - 1, n - 1, lookup) + 1);
 
            }
            else {
                // else if last character of X and Y don't match
                lookup.put(key, Integer.max(LCSLength(X, Y, m, n-1, lookup),
                        LCSLength(X, Y, m-1, n, lookup)));
            }
        }
 
        // return the subproblem solution from the map
        return lookup.get(key);
    }
    public static void main(String[] args) {
         String X = "ABCBDAB", Y = "BDCABA";
          Map<String, Integer> lookup = new HashMap<>();
          
            System.out.print("The length of LCS is "
                + LCSLength(X, Y, X.length(), Y.length(), lookup));
         
    }
    
}
