
package rod.cutting;

public class RodCutting {
          // length[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
       static  int price [] = { 1, 5, 8, 9, 10, 17, 17, 20 };
static int count=1;
    public static int rodCut( int n)
    {
        count++;
        // base case
        if (n <= 0) {
            return 0;
        }
 
        int maxValue = Integer.MIN_VALUE;
      
         
        // one by one partition the given rod of length n into
        //  two parts of length (1, n-1), (2, n-2), (3, n-3), ....
        // (n-1 , 1), (n, 0) and take maximum
        for (int i = 1; i <= n; i++)
        {
            // rod of length i has a cost price[i-1]
           // System.out.println(maxValue);
             maxValue = Integer.max(maxValue, price[i-1] + rodCut(n - i));
 
            
        }
 
        return maxValue;
    }
    public static void main(String[] args) {
 
        // rod length
        int n = 4;
 
        System.out.println("Profit is " + rodCut( n));
        System.out.println(count);
    }
    
}
