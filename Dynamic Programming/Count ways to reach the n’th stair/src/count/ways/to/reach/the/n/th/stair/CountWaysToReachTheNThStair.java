
package count.ways.to.reach.the.n.th.stair;

public class CountWaysToReachTheNThStair {

 public static int totalWays(int n)
    {
        // base case
        if (n < 0) {
            return 0;
        }
 
        // base case: there is one way to cover it with no steps
        if (n == 0) {
            return 1;
        }
 
        // combine results of taking 1 step or 2 steps or 3 steps at a time
        return totalWays(n - 1) + totalWays(n - 2) + totalWays(n - 3);
    }
 
    public static void main(String[] args)
    {
        int n = 4;
        System.out.printf("Total ways to reach the %d'th stair are %d",
                            n, totalWays(n));
    }
}
