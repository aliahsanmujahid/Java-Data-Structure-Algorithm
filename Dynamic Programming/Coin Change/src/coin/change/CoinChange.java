package coin.change;

public class CoinChange {

    public static int findMinCoins(int S[],int sum){
        if(sum==0)
            return 0;
        if(sum<0)
            return 9999;
        int ans = 9999;
        for(int i=0;i<S.length;i++){
          int   num = findMinCoins(S,sum-S[i])+1;
        if(num <9999){
          ans=num;
        }
        }
        return ans;
    }
    public static void main(String[] args) {
       int[] S = { 1, 2, 3, 4 };
 
        // Total Change required
        int N = 15;
 
        System.out.println("Minimum number of coins required " + findMinCoins(S, N));
    }
    
}
