
package lcs.space.approach.pkg2;

import javax.xml.transform.Source;

public class LCSSpaceApproach2 {
public static int LCSLength(String X, String Y)
    {
        int m = X.length(), n = Y.length();
 
        // allocate storage for one-dimensional array curr
        int[] curr = new int[n + 1];
        int prev;
 
        // fill the lookup table in bottom-up manner
        for (int i = 0; i <= m; i++)
        {
            prev = curr[0];
            for (int j = 0; j <= n; j++)
            {
                int backup = curr[j];
             
                if (i == 0 || j == 0) {
                    curr[j] = 0;
                }
                else
                {
                    // if current character of X and Y matches
                    if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                        curr[j] = prev + 1;
                    }
                    // else if current character of X and Y don't match
                    else {
                        curr[j] = Integer.max(curr[j], curr[j - 1]);
                    }
                }
                prev = backup;
            }
        }
 
        // LCS will be last entry in the lookup table
        return curr[n];
    }
    public static void main(String[] args) {
      String X = "ABCD", Y = "ABCD";
      if (X.length() > Y.length()) {
            System.out.print("The length of LCS is " + LCSLength(X, Y));
        } else {
            System.out.print("The length of LCS is " + LCSLength(Y, X));
        }
    }
    
}
