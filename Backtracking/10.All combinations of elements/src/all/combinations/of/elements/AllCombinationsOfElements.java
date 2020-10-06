
package all.combinations.of.elements;

import java.util.Arrays;

public class AllCombinationsOfElements {
    
    public static void findAllCombinations(int arr[],int elem,int n){
        //System.out.println(elem+" "+n);
        if(elem>n){
            System.out.println(elem);
             for (int i : arr)
               System.out.print(i + " ");
            System.out.println();
 
            return;
        }
        for(int i=0;i<2*n;i++){
            if(arr[i] == -1 && (i + elem + 1) < 2*n &&
                    arr[i + elem + 1] == -1){
                arr[i] = elem;
                arr[i + elem + 1] = elem;
                findAllCombinations(arr, elem + 1, n);
 

                arr[i] = -1;
                arr[i + elem + 1] = -1;
            }
        }
    }
    public static void main(String[] args) {
        int n = 7;
        int arr[] = new int [2*n];
        Arrays.fill(arr,-1);
        
        int elem = 1;
        findAllCombinations(arr,elem,n);
    }            
}
