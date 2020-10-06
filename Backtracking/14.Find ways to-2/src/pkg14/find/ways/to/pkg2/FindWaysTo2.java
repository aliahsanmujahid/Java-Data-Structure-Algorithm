
package pkg14.find.ways.to.pkg2;
import java.util.ArrayList;
import java.util.List;
 
class Pair
{
    Integer num;
    Character sign;
 
    Pair(Integer num, Character sign) {
        this.num = num;
        this.sign = sign;
    }
}
 
public class FindWaysTo2 {
  private static void printList(List<Pair> list) {
        for (Pair p : list) {
            System.out.print("(" + p.sign + ")" + p.num + " ");
        }
        System.out.println();
    }
 
    // Print all ways to calculate a target from elements of specified array
    public static void printWays(int[] arr, int n, int sum, int target,
                                 List<Pair> list)
    {
        // base case: if target is found, print result list
        if (sum == target)
        {
            printList(list);
            return;
        }
 
        // base case: No elements are left
        if (n < 0) {
            return;
        }
 
        // Ignore the current element
        printWays(arr, n - 1, sum, target, list);
 
        // Consider the current element and subtract it from the target
        list.add(new Pair(arr[n], '+'));
        printWays(arr, n - 1, sum + arr[n], target, list);
        list.remove(list.size()-1);    // backtrack
 
        // Consider the current element and add it to the target
        list.add(new Pair(arr[n], '-'));
        printWays(arr, n - 1, sum - arr[n], target, list);
        list.remove(list.size() - 1);    // backtrack
    }
 
    public static void main(String[] args)
    {
        // input array and target number
        int[] arr = { 5, 3, -6, 2 };
        int target = 6;
 
        printWays(arr, arr.length - 1, 0, target, new ArrayList<>());
    }
}
