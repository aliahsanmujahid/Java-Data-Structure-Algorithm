package pkg0.pkg1.knapsack;

public class Knapsack {
public static int knapSack(int[] v, int[] w, int W)
    {
        System.out.println(v.length + 1+" vw "+(W + 1)); 
     int [][] T = new int [v.length + 1][W + 1];
      
       for (int i = 1; i <= v.length; i++){
            for (int j = 0; j <= W; j++){
                 System.out.println(i+" "+w[i-1]+" "+j);
      
               if (w[i-1] > j) {
                    System.out.println(i+" if "+j); 
                   
                   T[i][j] = T[i-1][j];
                   System.out.println(T[i][j]);
                    System.out.println();
                } 
               else {
                    // find maximum value we get by excluding or including 
                    // the i'th item
                    System.out.println(i+" else "+j); 
                    
                            
                    T[i][j] = Integer.max(T[i-1][j],
                            T[i-1][j-w[i-1]] + v[i-1]);
                    System.out.println(T[i][j]);
                    System.out.println();
                }
                
            }
           System.out.println();
       }
              for (int i = 1; i <= v.length; i++){
            for (int j = 0; j <= W; j++){
                System.out.print(T[i][j]+" ");
            }
                  System.out.println();
       }
       return T[v.length][W];
    }
    public static void main(String[] args) {
 // Input: set of items each with a weight and a value
        int[] v = { 10,20,30,40 };
        int[] w = { 2,4,5,3 };
 
        // Knapsack capacity
        int W = 10;
 
        System.out.println(knapSack(v,w,W));
               
    }
    
}
