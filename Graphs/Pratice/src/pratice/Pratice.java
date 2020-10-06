
package pratice;
import java.util.Scanner;


 class Pratice{
            public static void even(int i, int a[]){
              if(i==5){
                    return;
                }
               if(a[i]%2==0) {
                   System.out.print(a[i]+" ");
               }
               even(i+1, a);
           }
           public static void main(String[] args) {
               Scanner input = new Scanner(System.in);      
               int n=input.nextInt();
               int []a  = new int[5];
               
               for(int j=0;j<n;j++){
                   a[j] = input.nextInt();
               }
             even(0,a);

     }          
}
