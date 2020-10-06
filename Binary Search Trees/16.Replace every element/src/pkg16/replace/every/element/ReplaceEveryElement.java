
package pkg16.replace.every.element;

import java.util.Arrays;

/**
 *
 * @author Mujahid
 */
public class ReplaceEveryElement {
    // Replace each element of the specified array with the
    // least greater element on its right
    public static void findInorderSuccessor(int[] arr)
    {
        // traverse the array from the beginning
        for (int i = 0; i < arr.length; i++)
        {
            int successor = -1;
            int diff = Integer.MAX_VALUE;
 
            // check every element on right of current element for successor
            for (int j = i + 1; j < arr.length; j++)
            {
                if (arr[j] > arr[i] && (arr[j] - arr[i] < diff))
                {
                    successor = arr[j];
                    diff = arr[j] - arr[i];
                }
            }
            arr[i] = successor;
        }
 
        // print the resultant array
        System.out.println(Arrays.toString(arr));
    }
 
    public static void main(String[] args)
    {
        int[] arr = { 10, 100, 93, 32, 35, 65, 80, 90, 94, 6};
 
        findInorderSuccessor(arr);
    }
}
