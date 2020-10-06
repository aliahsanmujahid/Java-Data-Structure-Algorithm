package lis.iterative;

import java.util.Arrays;

public class LISIterative {

    public static int LIS(int A[]){
        int L[] = new int [A.length];
        L[0]=1;
        
        for(int i=1;i<A.length;i++){
            for(int j=0;j<i;j++){
                
                if(A[j]<A[i]&&L[j]>L[i]){
                    L[i] = L[j];
                }
            }
            L[i]++;
        }
        return Arrays.stream(L).max().getAsInt();
    }
    public static void main(String[] args) {
       int[] A = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };
 
        System.out.println("Length of LIS is " + LIS(A));
    }
    
}
