
package c.lcs;


public class CLCS {
 public static int LCSLength(String X, String Y)
    {
        int m=X.length();
        int n=Y.length();
        System.out.println("m "+m+" n "+n);
        int T[][] = new int[m+1][n+1];
        
        for(int i = 1; i <= m; i++){
            System.out.println("I "+i+" m "+m);
            System.out.println();
            for(int j = 1; j <= n; j++){
                System.out.println("J "+j+" n "+n);
                 System.out.println();
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    System.out.println(X.charAt(i - 1) +" "+ Y.charAt(j - 1));
                    System.out.println((i - 1)+" "+(j - 1));
                    T[i][j] = T[i - 1][j - 1] + 1;
                    System.out.println(i+" ij "+j);
                    System.out.println("<-t "+ T[i - 1][j - 1] +" t = "+T[i][j]);
                    System.out.println();
                }
                // else if current character of X and Y don't match,
                else {
                   System.out.println(X.charAt(i - 1) +" "+ Y.charAt(j - 1));
                   System.out.println(i +" ij "+j );
                   System.out.println((i - 1)+" "+j+" ij "+i+" "+(j - 1));
                   T[i][j] = Integer.max(T[i - 1][j], T[i][j - 1]);
                   System.out.println("T "+T[i][j]);
                   System.out.println();
                }
            }
        }
        return T[m][n];
    }
 
    // main function
    public static void main(String[] args)
    {
        String X = "ABCD", Y = "AABCD";
 
        System.out.print("The length of LCS is "
                + LCSLength(X, Y));
    }
}
