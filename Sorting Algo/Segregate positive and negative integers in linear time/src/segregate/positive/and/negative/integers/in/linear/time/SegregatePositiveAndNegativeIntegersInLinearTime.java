
package segregate.positive.and.negative.integers.in.linear.time;

import java.util.Arrays;

public class SegregatePositiveAndNegativeIntegersInLinearTime {
       public static void partition(int[] a, int start, int end)
    {
        int pivot = 1;
        int pIndex = start;
        // each time we find a negative number, pIndex is incremented
        // and that element would be placed before the pivot
        for (int i = start; i <= end; i++)
        {
            if (a[i] < pivot)   // pivot is 0
            {
                swap(a, i, pIndex);
                pIndex++;
            }
        }
    }
 
    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
 
    public static void main(String[] args)
    {
        int a[] = { 1, 0, 0, 0, 1, 0, 1, 1 };
 
        partition(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
}
