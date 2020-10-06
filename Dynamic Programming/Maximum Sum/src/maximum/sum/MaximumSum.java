
package maximum.sum;

public class MaximumSum {
    
    public static int MSIS(int[] A, int i, int n, int prev, int sum)
    {
        System.out.println(i+" "+prev+" "+sum);
                
        // Base case: nothing is remaining
        if (i == n) {
            return sum;
        }
 
        // case 1: exclude the current element and process the
        // remaining elements
        int excl = MSIS(A, i + 1, n, prev, sum);
             System.out.println("excl "+excl);
        // case 2: include the current element if it is greater
        // than previous element
        int incl = sum;
        System.out.println("----"+i+" "+A[i]+" "+prev+" sum= "+sum);
        
            if(A[i] > prev){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        if (A[i] > prev) {
            incl = MSIS(A, i + 1, n, A[i], sum + A[i]);
            System.out.println("incl "+incl);
        }
 
        // return maximum of above two choices
        return Integer.max(incl, excl);
    }
 
 public static void main(String[] args)
    {
        int[] A = { 8, 4, 12};
 int t= MSIS(A, 0, A.length, Integer.MIN_VALUE, 0);
        System.out.print("Maximum sum of increasing subsequence is " +
                       t);
    }

}
