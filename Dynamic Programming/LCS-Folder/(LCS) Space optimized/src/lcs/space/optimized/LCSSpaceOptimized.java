package lcs.space.optimized;

public class LCSSpaceOptimized {
public static int LCSLength(String X, String Y)
    {
    int m=X.length(),n=Y.length();
    int curr[] = new int [n+1];
    int prev[] = new int [n+1];
    
    for(int i = 0; i <= m; i++){
        for(int j = 0; j <= n; j++){
             System.out.println(i+" ij "+j);
            if (i > 0 && j > 0)
                {
                      
                    // if current character of X and Y matches
                    if (X.charAt(i - 1) == Y.charAt(j - 1)) {
               
                        curr[j] = prev[j - 1] + 1;
                    }
                    // else if current character of X and Y don't match
                    else {
                        curr[j] = Integer.max(prev[j], curr[j - 1]);
                    }
        }
    }
     for (int r = 0; r <= n; r++){
          System.out.println( prev[r]+" "+ curr[r]); 
          prev[r] = curr[r];
          //System.out.println( prev[r]+" "+ curr[r]); 
     }
      System.out.println();
    }
    return curr[n];
    }
public static void main(String[] args)
    {
        String X = "ABC", Y = "ABCD";
 
        System.out.print("The length of LCS is "
                + LCSLength(X, Y));
 
    }
}
