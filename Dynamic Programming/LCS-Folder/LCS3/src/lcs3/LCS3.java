
package lcs3;

public class LCS3 {
 public static int LCSLength(String x, String y)
    {
       int m = x.length(),n=y.length();
       int t [][]= new int[m+1][n+1];
       
       for(int i=1;i<=m;i++){
           for(int j=1;j<=n;j++){
               if(x.charAt(i-1)==y.charAt(j-1)){
                   t[i][j] = t[i-1][j-1]+1;
               }
                else {
                   t[i][j] = Integer.max(t[i - 1][j], t[i][j - 1]);
                }
           }
       }
       
       return t[m][n];
    }
    public static void main(String[] args) {
        String X = "XMJYAUZ", Y = "MZJAWXU";
 
        System.out.print("The length of LCS is " + LCSLength(X, Y));
    }
    
}
