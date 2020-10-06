
package rotations.in.a.circularly.sorted.array;

public class RotationsInACircularlySortedArray {
public static int findRotationCount(int[] A)
    {
       int left = 0;
       int right = A.length-1;
       
       while(left<=right){
           if(A[left]<=A[right]){
               return left;
           }
           int mid = (left+right)/2;
           
           int prev = (mid+1)%A.length;
           int next = (mid+A.length-1)%A.length;
           
           if(A[mid]<=A[prev]&&A[mid]<=A[next]){
               return mid;
           }
           
           if(A[mid]<=A[right]){
               right=mid-1;
           }
           if(A[mid]>=A[left]){
               left=mid+1;
           }
       }
       
       return -1;
    }
    public static void main(String[] args) {
        int[] A = { 8, 9, 10, 1, 2, 3, 4, 5, 6, 7 };
 
        System.out.println("The array is rotated " + findRotationCount(A) + " times");
    }
    
}
