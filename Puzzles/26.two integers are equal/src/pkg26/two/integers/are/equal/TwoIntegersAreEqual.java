
package pkg26.two.integers.are.equal;
import java.util.HashMap;
import java.util.Map;

public class TwoIntegersAreEqual {

    // Determine if two integers are equal without using comparison operators
    // and arithmetic operators
    public static boolean checkForEquality(int x, int y)
    {
        Map<Integer, Boolean> map = new HashMap<>();
        map.put(x, true);
 
        return map.containsKey(y);
    }
 
    public static void main(String[] args)
    {
        int x = 0, y = 2;
 
        if (checkForEquality(x, y)) {
            System.out.print("x is equal to y");
        }
        else {
            System.out.print("x is not equal to y");
        }
    } 
}
