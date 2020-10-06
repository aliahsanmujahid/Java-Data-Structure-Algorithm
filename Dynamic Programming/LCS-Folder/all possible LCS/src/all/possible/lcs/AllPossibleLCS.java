
package all.possible.lcs;

public class AllPossibleLCS {

    public static void main(String[] args) {
        String X = "ABCBDAB", Y = "BDCABA";
        // T[i][j] stores the length of LCS of substring
        // X[0..i-1], Y[0..j-1]
        int[][] T = new int[X.length() + 1][Y.length() + 1];
         Set<String> lcs = LCS(X, Y, T);
 
        // print set elements
        System.out.print(lcs);
    }
    
}
