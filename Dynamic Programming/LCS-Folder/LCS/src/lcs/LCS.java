package lcs;

public class LCS {
 // Function to find length of Longest Common Subsequence of
    // sequences X[0..m-1] and Y[0..n-1]
    public static int LCSLength(String X, String Y, int m, int n)
    {
       if(m==0||n==0){
           return 0;
       }
        if(X.charAt(m-1)==Y.charAt(n-1)){
            return 1+LCSLength(X,Y,m-1,n-1);
        }
       
        //See 10number video Tutirial
        return Integer.max(LCSLength(X,Y,m,n-1),LCSLength(X,Y,m-1,n));
    }
 
  
    public static void main(String[] args)
    {
       String s1 = "ABCBDAB",s2 = "BDCABA";
       
        System.out.println("The LCS Length is "+ LCSLength(s1,s2,s1.length(),s2.length()));
    }
}
