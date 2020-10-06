
package longest.increasing.subsequence;

public class LongestIncreasingSubsequence {
  public static int LIS(int[] A, int i, int n, int prev)
    {
        System.out.println(i);

        // Base case: nothing is remaining
        if (i == n) {
            return 0;
        }
       // case 1: exclude the current element and process the
        // remaining elements
        int excl = LIS(A, i + 1, n, prev);
          System.out.println("----"); 
     
        // case 2: include the current element if it is greater
        // than previous element in LIS
        
              System.out.println("Excl "+excl);
        int incl = 0;
        System.out.println(" i "+i+" A[i] "+A[i]+" prev "+ prev ); 
       if (A[i] > prev) {
            incl = 1 + LIS(A, i + 1, n, A[i]);
        }
 
        // return maximum of above two choices
        int t= Integer.max(incl, excl);
        System.out.println(" t "+t);
        return t;
    }
    public static void main(String args[]) 
    { 
        int[] A = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15  };
        int t=LIS(A,0,A.length,Integer.MIN_VALUE);
        System.out.println(t);
                
                
    }
}
