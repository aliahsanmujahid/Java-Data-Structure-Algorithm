/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2.add.two.numbers.pkg2;

/**
 *
 * @author Mujahid
 */
public class AddTwoNumbers2 {
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
        System.out.println("Add: "+add(2,3));
                
                
                
                
    }
    
}
