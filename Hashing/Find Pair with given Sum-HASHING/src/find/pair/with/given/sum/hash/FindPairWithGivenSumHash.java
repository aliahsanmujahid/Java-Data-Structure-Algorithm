
package find.pair.with.given.sum.hash;

import java.util.HashMap;
import java.util.Map;


public class FindPairWithGivenSumHash {
   // Naive method to find a pair in an array with given sum
    public static void findPair(int[] A, int sum)
    {
        // create an empty Hash Map
        Map<Integer, Integer> map = new HashMap<>();
 
        // do for each element
        for (int i = 0; i < A.length; i++)
        {
            // check if pair (arr[i], sum-arr[i]) exists
 
            // if difference is seen before, print the pair
            if (map.containsKey(sum - A[i]))
            {
                System.out.println("--"+(sum-A[i]));
                System.out.println("Pair found at index " +
                                   map.get(sum - A[i]) + " and " + i);
               // return;
            }
 
            // store index of current element in the map
            System.out.println(A[i]+"--"+i);
            map.put(A[i], i);
        }
 
        // No pair with given sum exists in the array
        System.out.println("Pair not found");
    }
   // Find pair with given sum in the array
    public static void main (String[] args)
    {
        int[] A = { 3, 4, -7, 3, 1, 3, 1, -4, -2, -2  };
        int sum = 0;
 
        findPair(A, sum);
    } 
}
