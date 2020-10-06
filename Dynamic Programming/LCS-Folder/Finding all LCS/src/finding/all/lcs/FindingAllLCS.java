
package finding.all.lcs;

public class FindingAllLCS {
     public static String LCS(String X, String Y, int m, int n, int[][] T){
         
       if (m == 0 || n == 0) {
           return "";
        }
         // if last character of X and Y matches
        if (X.charAt(m - 1) == Y.charAt(n - 1))
        {
            // append current character (X[m-1] or Y[n-1]) to LCS of
            // substring X[0..m-2] and Y[0..n-2]
          //  System.out.println(X.charAt(m - 1));
            return LCS(X, Y, m - 1, n - 1, T) + X.charAt(m - 1);
        }
         System.out.println(m+" mn "+n);
          System.out.println((m - 1)+" "+n+"--"+m+" "+(n-1));
          System.out.println(T[m - 1][n] +" "+ T[m][n - 1]);
          if (T[m - 1][n] > T[m][n - 1]) {
            return LCS(X, Y, m - 1, n, T);
        }
        else {
            // if left cell of current cell has more value than the top
            // cell, then drop current character of String Y and find LCS
            // of substring X[0..m-1], Y[0..n-2]
 
            return LCS(X, Y, m, n - 1, T);
        }
         
         
     }

     // Function to fill lookup table by finding the length of LCS
    // of substring X[0..m-1] and Y[0..n-1]
    public static void LCSLength(String X, String Y, int m, int n, int[][] T)
    {
      for(int i=1;i<=m;i++){
          for(int j=1;j<=n;j++){
              if(X.charAt(i - 1) == Y.charAt(j - 1)){
                  T[i][j] = T[i-1][j-1]+1;
              }else{
                  T[i][j] =Integer.max( T[i-1][j], T[i][j-1]);
              }
          }
      }
    }
    public static void main(String[] args) {
        String X = "abcd", Y = "abcd";
        int m = X.length(), n = Y.length();
         int[][] T = new int[m + 1][n + 1];
         
        LCSLength(X, Y, m, n, T);
      for(int i=0;i<=m;i++){
          for(int j=0;j<=n;j++){
              System.out.print(T[i][j]+" ");
          }
          System.out.println();
      }
      
         System.out.print(LCS(X, Y, m, n, T));
         System.out.println();
    }
    
}
