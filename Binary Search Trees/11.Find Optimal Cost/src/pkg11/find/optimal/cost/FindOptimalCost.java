
package pkg11.find.optimal.cost;


public class FindOptimalCost {
  // Find optimal cost to construct binary search tree from keys
    // i to j where each key k occurs freq[k] number of times
    public static int findOptimalCost(int[] freq, int i, int j, int level)
    {
        // base case
        if (j < i) {
            return 0;
        }
 
        int optimalCost = Integer.MAX_VALUE;
 
        // consider each key as a root and recursively find optimal solution
        for (int k = i; k <= j; k++)
        {
            // recursively find the optimal cost of left subtree
            int leftOptimalCost = findOptimalCost(freq, i, k - 1, level + 1);
 
            // recursively find the optimal cost of right subtree
            int rightOptimalCost = findOptimalCost(freq, k + 1, j, level + 1);
 
            // current node's cost is freq[k]*level
            int cost = freq[k]*level + leftOptimalCost + rightOptimalCost;
 
            // update optimal cost
            optimalCost = Integer.min(optimalCost, cost);
        }
 
        // Return minimum value
        return optimalCost;
    }
 
    // main function
    public static void main(String[] args)
    {
        int[] freq = { 25, 10, 20 };
 
        System.out.println("The optimal cost of constructing BST is "
                        + findOptimalCost(freq, 0, freq.length - 1, 1));
    }
}
