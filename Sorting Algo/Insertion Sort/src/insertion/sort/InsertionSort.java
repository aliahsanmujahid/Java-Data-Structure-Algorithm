
package insertion.sort;

import java.util.Arrays;

public class InsertionSort {
 public static void sort(int arr[]) 
    { 
      int n = arr.length;
      
      for(int i=1;i<n;i++){
          int value = arr[i];
          int j=i-1;
          while(j>=0&&arr[j]>value){
              arr[j+1] = arr[j];
                      j--;
          }
          arr[j+1] = value;
      }
    } 
  
  
    public static void main(String[] args) {
       int[] arr = { 3, 8, 5, 114, 1, 9, -2 };
 
        sort(arr);
 
        // print the sorted array
        System.out.println(Arrays.toString(arr));
    }
    
}
