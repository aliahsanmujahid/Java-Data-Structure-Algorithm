
package pkg3.generate.power.set;
import java.util.ArrayDeque;
import java.util.Deque;
public class GeneratePowerSet {

   // Function to generate power set of given set S
    public static void findPowerSet(int[] S, Deque<Integer> set, int n)
    {
        // if we have considered all elements
        if (n == 0) {
            System.out.println(set);
            return;
        }
 
        // consider nth element
        set.addLast(S[n - 1]);
        findPowerSet(S, set, n - 1);
 
        // or don't consider nth element
        set.removeLast();
        findPowerSet(S, set, n - 1);
    }
 
    public static void main(String[] args)
    {
        int[] S = { 1, 2, 3 };
        Deque<Integer> set = new ArrayDeque<>();
        findPowerSet(S, set, S.length);
    }
}
