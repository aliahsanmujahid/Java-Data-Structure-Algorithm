
package find.pair.with.given.sum;

public class FindPairWithGivenSum {
    public static void findPair(int a[]){
       for(int i=0;i<a.length-1;i++){
           for(int j=i+1;j<a.length;j++){
            if(a[i]+a[j]==0){
                System.out.println("Pair found at index "+ (i+1) + " and " + (j+1));
               // return;
            }   
           }
       } 
    }
    public static void main(String[] args) {
      int [] a = { 8, 4, 2, -8, 3, -4};
      int sum = 0;
      findPair(a);
    }
    
}
