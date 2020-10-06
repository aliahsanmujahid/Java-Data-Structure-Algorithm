/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg11.find.optimal.cost.pkg2;

import java.util.*;

/**
 *
 * @author Mujahid
 */
public class FindOptimalCost2 {

      // Find optimal cost to construct binary search tree from keys i to j
    // where each key k occurs freq[k] number of times
    public static int findOptimalCost(int[] freq, int i, int j, int level,
                                    Map<String, Integer> lookup)
    {
        // base case
        if (j < i) {
            return 0;
        }
 
        // construct an unique map key from dynamic elements of the input
        String key = i + "|" + j + "|" + level;
 
        // if sub-problem is seen for the first time, solve it and
        // store its result in a map
        if (!lookup.containsKey(key))
        {
            lookup.put(key, Integer.MAX_VALUE);
 
            int leftOptimalCost, rightOptimalCost;
 
            // consider each key as root and recursively find optimal solution
            for (int k = i; k <= j; k++)
            {
                // recursively find the optimal cost of left subtree
                leftOptimalCost = findOptimalCost(freq, i, k - 1, level + 1,
                                                    lookup);
 
                // recursively find the optimal cost of right subtree
                rightOptimalCost = findOptimalCost(freq, k + 1, j, level + 1,
                                                    lookup);
 
                // current node's cost is freq[k]*level
                int cost = freq[k]*level + leftOptimalCost + rightOptimalCost;
 
                // update optimal cost
                lookup.put(key, Integer.min (lookup.get(key), cost));
            }
        }
 
        // return the sub-problem solution from the map
        return lookup.get(key);
    }
 
    // main function
    public static void main(String[] args)
    {
        int[] freq = { 25, 10, 20 };
 
        // create a map to store solutions of sub-problems
        Map<String, Integer> lookup = new HashMap<>();
 
        System.out.println("The optimal cost of constructing BST is "
                + findOptimalCost(freq, 0, freq.length - 1, 1, lookup));
    }
}
