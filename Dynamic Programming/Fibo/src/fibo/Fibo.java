package fibo;

public class Fibo {
    static int lookup[];
    public static void lookup(int n){
        lookup = new int [n+1];    
        for(int i=0;i<=n;i++){
            lookup[i]=-1;
        }
    }
    public static int printfibo(int n){
  if(lookup[n] !=-1){
               return lookup[n]; 
        }
      if(n ==0){
           lookup[n]=n;
               return lookup[n]; 
        }
       if(n ==1){
           lookup[n]=n;
               return lookup[n]; 
        }
       lookup[n]= printfibo(n - 1) + printfibo(n - 2);
       return lookup[n];
    
    }
    
       public static int fibo(int n){
   if (lookup[n] == -1) 
    { 
      if (n <= 1) 
          lookup[n] = n; 
      else
          lookup[n] = fibo(n-1) + fibo(n-2); 
    } 
    return lookup[n]; 
    }             
    public static void main(String[] args) {
        int n  = 44;
        lookup(n);
        for(int i=0;i<n;i++){
            int m= fibo(i);
        System.out.print(m+" ");
        }
    }
}