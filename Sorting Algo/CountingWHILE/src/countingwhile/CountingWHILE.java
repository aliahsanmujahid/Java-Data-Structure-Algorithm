
package countingwhile;

import java.util.Arrays;

public class CountingWHILE {
public static void countSort(int[] arr,int k)
    {
       int[] freq = new int[k];
 
        // using value of integer in the input array as index,
        // store count of each integer in freq[] array
        for (int i: arr) {
            freq[i]++;
        }
 
        // overwrite the input array with sorted order
        int index = 0;
        for (int i = 0; i < k; i++) {
            while (freq[i]-- > 0) {
                arr[index++] = i;
            }
        }
    }
    public static void main(String[] args) {
        int[] first = { 5, 8, 9, 3, 5, 7, 1, 3, 4, 9, 3, 5, 1, 8, 4 };
        // range of array elements
        int k = 10;
 
        countSort(first,k);
        System.out.println(Arrays.toString(first));
    }
    
}
