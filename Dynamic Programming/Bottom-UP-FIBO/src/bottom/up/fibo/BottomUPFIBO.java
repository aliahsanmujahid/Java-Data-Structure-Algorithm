package bottom.up.fibo;

import java.util.Scanner;

public class BottomUPFIBO {

public static int fibo(int n){
if(n<=1)
    return n;
int f=0,l=1;
for(int i=0;i<n-1;i++){
    int t=f;
    f=l;
    l=t+f;
}
return l;
}
    public static void main(String[] args) {
             Scanner input = new Scanner(System.in);        
        //System.out.print("Enter :");
        int n=1000;
        for(int i=0;i<n;i++){
            int t= fibo(i);
            System.out.print(t+" + ");
        }
    }
    
}
