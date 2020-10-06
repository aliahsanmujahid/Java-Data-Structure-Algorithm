package pkg5.find.a.duplicate.element.pkg4;

import java.util.stream.IntStream;

public class FindADuplicateElement4 {
   public static int findDuplicate(int[] A)
    {
        int actual_sum = IntStream.of(A).sum();
        int expected_sum = A.length * (A.length - 1) / 2;
 
        return actual_sum - expected_sum;
    }
 
    public static void main(String[] args)
    {
        int[] A = { 1, 2, 3, 4, 4 };
        System.out.println("The duplicate element is " + findDuplicate(A));
    }
}