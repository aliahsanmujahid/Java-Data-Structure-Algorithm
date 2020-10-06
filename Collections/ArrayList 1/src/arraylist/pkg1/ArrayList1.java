
package arraylist.pkg1;

public class ArrayList1 {

public static int add(int a,int b){
     
     while(a>0){
         b++;
         a--;
     }
       while(a<0){
         b--;
         a++;
     }
       return b;
 }
    public static void main(String[] args) {
        int t=add(2,3);
        System.out.println("Add: "+t+add(2,3));
                
                
                
                
    }
}
