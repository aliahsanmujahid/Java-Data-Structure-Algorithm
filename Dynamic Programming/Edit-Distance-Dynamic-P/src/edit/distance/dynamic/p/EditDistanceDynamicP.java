package edit.distance.dynamic.p;

public class EditDistanceDynamicP {

     static int min(int x,int y,int z){
         System.out.println("xyz "+x+" "+y+" "+z);
        if (x<=y && x<=z) return x; 
        if (y<=x && y<=z) return y; 
        else return z; 
    }
    public static int editDist(String str1 , String str2 , int m ,int n){
       
        int dp[][] = new int [m+1][n+1];
        
        for(int i=0; i<=m; i++){
         //   System.out.println();
            for(int j=0; j<=n; j++){
                if(i==0){   
                  dp[i][j] = j;  
                   System.out.println(i +" ij "+ j+" dp "+dp[i][j]);
                }          
                else if(j==0){
                    dp[i][j] = i; 
                    System.out.println(i +" ij "+ j+" dp "+dp[i][j]);
                }
                   
                else if(str1.charAt(i-1) == str2.charAt(j-1)){
                    System.out.println(i +" ij "+ j+" dp "+dp[i-1][j-1]);
                    dp[i][j] = dp[i-1][j-1]; 
                }
                     
                else{
                     System.out.println(i +" ij "+ j+" dp "+dp[i-1][j-1]);
                    dp[i][j] = 1 + min(dp[i][j-1],  // Insert 
                                       dp[i-1][j],  // Remove 
                                       dp[i-1][j-1]); // Replace 
                    System.out.println(dp[i][j]);
                }
                    
            }
          System.out.println();
        }
        
                for(int i=0; i<= str1.length(); i++){
            for(int j=0; j<=str2.length(); j++){
                System.out.print(dp[i][j]+" ");
        }
                    System.out.println();
    }
        return dp[m][n]; 
    }
    public static void main(String[] args) {
       String str1 = "kitten",str2= "sitting";
        System.out.println(editDist( str1 , str2 , str1.length(), str2.length()) );
      
}
}
