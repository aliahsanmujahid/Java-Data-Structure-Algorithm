
package longest.bitonic.subsequence;

public class LongestBitonicSubsequence {
    public static int calculateLBS(int[] A)
    {
        // I[i] stores the length of the longest increasing subsequence
        // ending with A[i]
        int[] I = new int[A.length];
 
        // D[i] stores the length of the longest decreasing subsequence
        // starting with A[i]
        int[] D = new int[A.length];
 
        int n = A.length - 1;
 
        I[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i] && I[j] > I[i])
                    I[i] = I[j];
            }
            I[i]++;
        }
 
        D[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n; j > i; j--) {
                if (A[j] < A[i] && D[j] > D[i])
                    D[i] = D[j];
            }
            D[i]++;
        }
 
        // consider each element as peak and calculate LBS
        int lbs = 1;
        for (int i = 0; i <= n; i++) {
            lbs = Integer.max(lbs, I[i] + D[i] - 1);
        }
 
        return lbs;
    }

    public static void main(String[] args) {
     int[] A = { 1,5,2,10,4,3,9,1 };
 
        System.out.println("Length of Longest Bitonic Subsequence is " +
                calculateLBS(A));
    }
    
}
